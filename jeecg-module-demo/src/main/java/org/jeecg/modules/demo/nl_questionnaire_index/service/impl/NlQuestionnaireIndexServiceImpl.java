package org.jeecg.modules.demo.nl_questionnaire_index.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.jeecg.modules.demo.nl_questionnaire_index.entity.NlQuestionnaireIndex;
import org.jeecg.modules.demo.nl_questionnaire_index.mapper.NlQuestionnaireIndexMapper;
import org.jeecg.modules.demo.nl_questionnaire_index.service.INlQuestionnaireIndexService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @Description: nl_questionnaire_index
 * @Author: jeecg-boot
 * @Date: 2024-04-19
 * @Version: V1.0
 */
@Service
public class NlQuestionnaireIndexServiceImpl extends ServiceImpl<NlQuestionnaireIndexMapper, NlQuestionnaireIndex> implements INlQuestionnaireIndexService {

    /**
     * 传入一个id，获得该id以及它的子树的id
     * @param id
     */
    @Override
    @Transactional
    public void removeByIdWithSubTree(String id) {
        Collection<String> ids = getSubTreeIds(id);

        this.baseMapper.deleteBatchIds(ids);
    }

    /**
     * 获得一个id序列，将每个id以及它的子树都存起来，统一删除
     * @param list
     */
    @Override
    public void removeByIdsWithSubTree(List<String> list) {
        List<NlQuestionnaireIndex> metaList = this.baseMapper.selectList(new QueryWrapper<>());
        Set<String> ids=new HashSet<>();
        for (String id : list) {
            trace(ids,id,metaList);
        }

        this.baseMapper.deleteBatchIds(ids);
    }

    private Collection<String> getSubTreeIds(String id) {
        List<NlQuestionnaireIndex> metaList = this.baseMapper.selectList(new QueryWrapper<>());
        Set<String> ids=new HashSet<>();
        trace(ids, id, metaList);
        return ids;
    }

    /**
     * 递归获得 id 的所有子树序列
     * @param ids
     * @param id
     * @param metaList
     */
    private void trace(Collection<String> ids, String id, List<NlQuestionnaireIndex> metaList) {
        ids.add(id);
        for (NlQuestionnaireIndex index : metaList) {
            if (index.getParentId().toString().equals(id)) {
                ids.add(String.valueOf(index.getId()));
                trace(ids, String.valueOf(index.getId()), metaList);
            }
        }
    }

}
