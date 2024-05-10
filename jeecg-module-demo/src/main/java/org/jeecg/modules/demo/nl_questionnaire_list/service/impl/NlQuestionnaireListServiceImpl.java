package org.jeecg.modules.demo.nl_questionnaire_list.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.modules.demo.nl_questionnaire_db_single.entity.NlQuestionnaireDbSingle;
import org.jeecg.modules.demo.nl_questionnaire_db_single.service.impl.NlQuestionnaireDbSingleServiceImpl;
import org.jeecg.modules.demo.nl_questionnaire_index.entity.NlQuestionnaireIndex;
import org.jeecg.modules.demo.nl_questionnaire_index.service.impl.NlQuestionnaireIndexServiceImpl;
import org.jeecg.modules.demo.nl_questionnaire_index.vo.IndexTreeVO;
import org.jeecg.modules.demo.nl_questionnaire_list.entity.NlQuestionnaireList;
import org.jeecg.modules.demo.nl_questionnaire_list.mapper.NlQuestionnaireListMapper;
import org.jeecg.modules.demo.nl_questionnaire_list.service.INlQuestionnaireListService;
import org.jeecg.modules.demo.nl_questionnaire_list.vo.NlQuestionnaireListVO;
import org.jeecg.modules.demo.nl_questionnaire_list.vo.QuestionVO;
import org.jeecg.modules.demo.nl_questionnaire_list_single.entity.NlQuestionnaireListSingle;
import org.jeecg.modules.demo.nl_questionnaire_list_single.service.impl.NlQuestionnaireListSingleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description: 测评问卷生成
 * @Author: jeecg-boot
 * @Date: 2024-04-21
 * @Version: V1.0
 */
@Service
public class NlQuestionnaireListServiceImpl extends ServiceImpl<NlQuestionnaireListMapper, NlQuestionnaireList> implements INlQuestionnaireListService {

    @Autowired
    private NlQuestionnaireIndexServiceImpl indexService;

    @Autowired
    private NlQuestionnaireListSingleServiceImpl listSingleService;

    @Autowired
    private NlQuestionnaireDbSingleServiceImpl singleService;


    @Override
    public IPage<NlQuestionnaireListVO> getQuestionnairePage(Page<NlQuestionnaireListVO> page, HashMap<String, String> params) {
        return this.baseMapper.getQuestionnairePage(page, params);
    }


    private void getTreeList(List<IndexTreeVO> treeList, List<NlQuestionnaireIndex> metaList) {
        for (NlQuestionnaireIndex index : metaList) {
            IndexTreeVO tree = new IndexTreeVO(index);
            if (tree.getParentId() == 0) {
                treeList.add(tree);
                addChildren(tree, metaList);
            }
        }
        treeList.sort(new Comparator<IndexTreeVO>() {
            @Override
            public int compare(IndexTreeVO o1, IndexTreeVO o2) {
                return o1.getOrderNum().compareTo(o2.getOrderNum());
            }
        });
    }

    private void addChildren(IndexTreeVO parent, List<NlQuestionnaireIndex> metaList) {
        List<IndexTreeVO> children = new ArrayList<>();
        for (NlQuestionnaireIndex index : metaList) {
            if (index.getParentId().equals(parent.getId()) || index.getParentId().intValue() == parent.getId().intValue()) {
                IndexTreeVO childTree = new IndexTreeVO(index);
                children.add(childTree);
                addChildren(childTree, metaList);
            }
        }
        children.sort(new Comparator<IndexTreeVO>() {
            @Override
            public int compare(IndexTreeVO o1, IndexTreeVO o2) {
                return o1.getOrderNum().compareTo(o2.getOrderNum());
            }
        });
        parent.setChildren(children);
    }

    public void saveWithQuestionByTypeWithChild(NlQuestionnaireList nlQuestionnaireList) {
        List<NlQuestionnaireIndex> metaList = indexService.list();
        List<IndexTreeVO> treeList = new ArrayList<>();
        getTreeList(treeList, metaList);

        Integer questionType = nlQuestionnaireList.getQuestionType();

        IndexTreeVO index = null;
        for (IndexTreeVO indexTreeVO : treeList) {
            for (IndexTreeVO child : indexTreeVO.getChildren()) {
                for (IndexTreeVO childChild : child.getChildren()) {
                    if (questionType.equals(childChild.getId())) {
                        index = childChild;
                        break;
                    }
                }
                if (questionType.equals(child.getId())) {
                    index = child;
                    break;
                }
            }
            if (questionType.equals(indexTreeVO.getId())) {
                index = indexTreeVO;
                break;
            }
        }
        List<Integer> canUseType = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        canUseType.add(index.getId());
        set.add(index.getId());
        if (!index.getChildren().isEmpty()) {
            for (IndexTreeVO child : index.getChildren()) {
                if (child.getChildren().isEmpty()) {
                    canUseType.add(child.getId());
                    set.add(child.getId());
                } else {
                    for (IndexTreeVO childChild : child.getChildren()) {
                        if (childChild.getChildren().isEmpty()) {
                            canUseType.add(childChild.getId());
                            set.add(childChild.getId());
                        }
                    }
                }
            }
        }
        List<NlQuestionnaireDbSingle> list = singleService.list();
        List<NlQuestionnaireDbSingle> canUseList = new ArrayList<>();
        for (NlQuestionnaireDbSingle single : list) {
            Integer questionnaireType = single.getQuestionnaireType();
            if (set.contains(questionnaireType)) {
                canUseList.add(single);
            }
        }
        Integer questionNum = nlQuestionnaireList.getSingleNum();
        // 防止溢出
        if (questionNum > canUseList.size()) {
            questionNum = canUseList.size();
            nlQuestionnaireList.setSingleNum(questionNum);
            nlQuestionnaireList.setTotalScore(nlQuestionnaireList.getSingleScore() * nlQuestionnaireList.getSingleNum());
        }

        List<NlQuestionnaireListSingle> insertListSingleList = new ArrayList<>();

        Random random = new Random(System.currentTimeMillis());
        HashSet<Integer> indexSet = new HashSet<>();

        for (int i = 0; i < questionNum; i++) {
            int i1 = random.nextInt(canUseList.size());
            while (indexSet.contains(i1)) {
                i1 = random.nextInt(canUseList.size());
            }
            indexSet.add(i1);
            NlQuestionnaireDbSingle single = canUseList.get(i1);
            NlQuestionnaireListSingle listSingle = new NlQuestionnaireListSingle();
            listSingle.setListId(nlQuestionnaireList.getId());
            listSingle.setQuestionnaireId(single.getId());
            insertListSingleList.add(listSingle);
        }
    }


    @Override
    @Transactional
    public void saveWithRandomQuestion(NlQuestionnaireList nlQuestionnaireList) {
        List<NlQuestionnaireIndex> metaList = indexService.list();
        List<IndexTreeVO> treeList = new ArrayList<>();
        getTreeList(treeList, metaList);

        Integer questionType = nlQuestionnaireList.getQuestionType();

        IndexTreeVO index = null;
        for (IndexTreeVO indexTreeVO : treeList) {
            for (IndexTreeVO child : indexTreeVO.getChildren()) {
                for (IndexTreeVO childChild : child.getChildren()) {
                    if (questionType.equals(childChild.getId())) {
                        index = childChild;
                        break;
                    }
                }
                if (questionType.equals(child.getId())) {
                    index = child;
                    break;
                }
            }
            if (questionType.equals(indexTreeVO.getId())) {
                index = indexTreeVO;
                break;
            }
        }
        List<Integer> canUseType = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        canUseType.add(index.getId());
        set.add(index.getId());
        if (!index.getChildren().isEmpty()) {
            for (IndexTreeVO child : index.getChildren()) {
                if (child.getChildren().isEmpty()) {
                    canUseType.add(child.getId());
                    set.add(child.getId());
                } else {
                    for (IndexTreeVO childChild : child.getChildren()) {
                        if (childChild.getChildren().isEmpty()) {
                            canUseType.add(childChild.getId());
                            set.add(childChild.getId());
                        }
                    }
                }
            }
        }
        List<NlQuestionnaireDbSingle> list = singleService.list();
        List<NlQuestionnaireDbSingle> canUseList = new ArrayList<>();
        for (NlQuestionnaireDbSingle single : list) {
            Integer questionnaireType = single.getQuestionnaireType();
            if (set.contains(questionnaireType)) {
                canUseList.add(single);
            }
        }
        Integer questionNum = nlQuestionnaireList.getSingleNum();
        // 防止溢出
        if (questionNum > canUseList.size()) {
            questionNum = canUseList.size();
            nlQuestionnaireList.setSingleNum(questionNum);
            nlQuestionnaireList.setTotalScore(nlQuestionnaireList.getSingleScore() * nlQuestionnaireList.getSingleNum());
        }
        this.baseMapper.insert(nlQuestionnaireList);

        List<NlQuestionnaireListSingle> insertListSingleList = new ArrayList<>();

        Random random = new Random(System.currentTimeMillis());
        HashSet<Integer> indexSet = new HashSet<>();

        for (int i = 0; i < questionNum; i++) {
            int i1 = random.nextInt(canUseList.size());
            while (indexSet.contains(i1)) {
                i1 = random.nextInt(canUseList.size());
            }
            indexSet.add(i1);
            NlQuestionnaireDbSingle single = canUseList.get(i1);
            NlQuestionnaireListSingle listSingle = new NlQuestionnaireListSingle();
            listSingle.setListId(nlQuestionnaireList.getId());
            listSingle.setQuestionnaireId(single.getId());
            insertListSingleList.add(listSingle);
        }

        listSingleService.saveBatch(insertListSingleList);


    }

    @Override
    @Transactional
    public void updateWithQuestion(NlQuestionnaireList nlQuestionnaireList) {
        Integer questionType = nlQuestionnaireList.getQuestionType();
//        如果题目数量和题目类型都没有变化就只更新其余信息，否则需要删除题目并重新插入
        NlQuestionnaireList temp = this.baseMapper.selectById(nlQuestionnaireList.getId());
        if (nlQuestionnaireList.getSingleNum().equals(temp.getSingleNum()) && questionType.equals(temp.getQuestionType())) {
            this.baseMapper.updateById(nlQuestionnaireList);
            return;
        }
//        删除原本的问题
        listSingleService.removeByListId(nlQuestionnaireList.getId());

//        重新插入新的随机问题
        List<NlQuestionnaireIndex> metaList = indexService.list();
        List<IndexTreeVO> treeList = new ArrayList<>();
        getTreeList(treeList, metaList);

        questionType = nlQuestionnaireList.getQuestionType();

        IndexTreeVO index = null;
        for (IndexTreeVO indexTreeVO : treeList) {
            for (IndexTreeVO child : indexTreeVO.getChildren()) {
                for (IndexTreeVO childChild : child.getChildren()) {
                    if (questionType.equals(childChild.getId())) {
                        index = childChild;
                        break;
                    }
                }
                if (questionType.equals(child.getId())) {
                    index = child;
                    break;
                }
            }
            if (questionType.equals(indexTreeVO.getId())) {
                index = indexTreeVO;
                break;
            }
        }
        List<Integer> canUseType = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        canUseType.add(index.getId());
        set.add(index.getId());
        if (!index.getChildren().isEmpty()) {
            for (IndexTreeVO child : index.getChildren()) {
                if (child.getChildren().isEmpty()) {
                    canUseType.add(child.getId());
                    set.add(child.getId());
                } else {
                    for (IndexTreeVO childChild : child.getChildren()) {
                        if (childChild.getChildren().isEmpty()) {
                            canUseType.add(childChild.getId());
                            set.add(childChild.getId());
                        }
                    }
                }
            }
        }
        List<NlQuestionnaireDbSingle> list = singleService.list();
        List<NlQuestionnaireDbSingle> canUseList = new ArrayList<>();
        for (NlQuestionnaireDbSingle single : list) {
            Integer questionnaireType = single.getQuestionnaireType();
            if (set.contains(questionnaireType)) {
                canUseList.add(single);
            }
        }
        Integer questionNum = nlQuestionnaireList.getSingleNum();
        // 防止溢出
        if (questionNum > canUseList.size()) {
            questionNum = canUseList.size();
            nlQuestionnaireList.setSingleNum(questionNum);
            nlQuestionnaireList.setTotalScore(nlQuestionnaireList.getSingleScore() * nlQuestionnaireList.getSingleNum());
        }
        this.baseMapper.updateById(nlQuestionnaireList);

        List<NlQuestionnaireListSingle> insertListSingleList = new ArrayList<>();

        Random random = new Random(System.currentTimeMillis());
        HashSet<Integer> indexSet = new HashSet<>();

        for (int i = 0; i < questionNum; i++) {
            int i1 = random.nextInt(canUseList.size());
            while (indexSet.contains(i1)) {
                i1 = random.nextInt(canUseList.size());
            }
            indexSet.add(i1);
            NlQuestionnaireDbSingle single = canUseList.get(i1);
            NlQuestionnaireListSingle listSingle = new NlQuestionnaireListSingle();
            listSingle.setListId(nlQuestionnaireList.getId());
            listSingle.setQuestionnaireId(single.getId());
            insertListSingleList.add(listSingle);
        }

        listSingleService.saveBatch(insertListSingleList);


    }

    @Override
    @Transactional
    public void removeByIdWithQuestion(String id) {
        NlQuestionnaireList nlQuestionnaireList = this.baseMapper.selectById(id);
        listSingleService.removeByListId(nlQuestionnaireList.getId());
        this.baseMapper.deleteById(id);
    }

    @Override
    @Transactional
    public void removeByIdsWithQuestion(List<String> ids) {
        for (String id : ids) {
            this.removeByIdWithQuestion(id);
        }
    }

    @Override
    public List<QuestionVO> getQuestionByListId(String listId) {
        return this.baseMapper.getQuestionByListId(listId);
    }
}
