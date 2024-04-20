package org.jeecg.modules.demo.nl_questionnaire_db_single.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.modules.demo.nl_questionnaire_db_choice_single.entity.NlQuestionnaireDbChoiceSingle;
import org.jeecg.modules.demo.nl_questionnaire_db_choice_single.mapper.NlQuestionnaireDbChoiceSingleMapper;
import org.jeecg.modules.demo.nl_questionnaire_db_single.entity.NlQuestionnaireDbSingle;
import org.jeecg.modules.demo.nl_questionnaire_db_single.mapper.NlQuestionnaireDbSingleMapper;
import org.jeecg.modules.demo.nl_questionnaire_db_single.service.INlQuestionnaireDbSingleService;
import org.jeecg.modules.demo.nl_questionnaire_db_single.vo.NlQuestionnaireSingleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: 问卷题库管理
 * @Author: jeecg-boot
 * @Date: 2024-04-20
 * @Version: V1.0
 */
@Service
public class NlQuestionnaireDbSingleServiceImpl extends ServiceImpl<NlQuestionnaireDbSingleMapper, NlQuestionnaireDbSingle> implements INlQuestionnaireDbSingleService {

    @Autowired
    private NlQuestionnaireDbChoiceSingleMapper nlQuestionnaireDbChoiceSingleMapper;

    @Override
    public IPage<NlQuestionnaireSingleVO> getQuestionPage(Page<NlQuestionnaireSingleVO> page, HashMap<String, Object> params) {
//        return this.baseMapper.getSingleWithName(page, params);
        IPage<NlQuestionnaireSingleVO> pageList = this.baseMapper.getQuestionWithName(page, params);
        List<NlQuestionnaireSingleVO> records = pageList.getRecords();
        for (NlQuestionnaireSingleVO record : records) {
            List<NlQuestionnaireDbChoiceSingle> choices = nlQuestionnaireDbChoiceSingleMapper.getChoiceByQuestionId(record.getId());
            Map<String, Object> map = new HashMap<>();
            for (NlQuestionnaireDbChoiceSingle choice : choices) {
                map.put(choice.getChoiceContent(), choice.getChoiceScoreWeight().toString());
            }
            JSONObject jsonObject = new JSONObject(map);
            String choiceList = jsonObject.toJSONString();
            record.setChoiceList(choiceList);
        }


        return pageList;
    }

    @Override
    @Transactional
    public void saveQuestionWithChoice(NlQuestionnaireSingleVO questionVO) {
        NlQuestionnaireDbSingle question = new NlQuestionnaireDbSingle();
        question.setDelFlag(questionVO.getDelFlag());
        question.setQuestionnaireType(questionVO.getQuestionnaireType());
        question.setQuestionName(questionVO.getQuestionName());
        this.baseMapper.insert(question);


        String choices = questionVO.getChoiceList();
        Map<String, String> choiceMap = (Map<String, String>) JSON.parse(choices);
        List<NlQuestionnaireDbChoiceSingle> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : choiceMap.entrySet()) {
            String choiceContent = entry.getKey();
            Double choiceWeight = Double.parseDouble(entry.getValue());
            Integer questionId = question.getId();
            NlQuestionnaireDbChoiceSingle choice = new NlQuestionnaireDbChoiceSingle();
            choice.setQuestionId(questionId);
            choice.setChoiceContent(choiceContent);
            choice.setChoiceScoreWeight(choiceWeight);
            choice.setDelFlag(0);
            choice.setSort(0);
//            nlQuestionnaireDbChoiceSingleMapper.insert(choice);
            nlQuestionnaireDbChoiceSingleMapper.add(choice);
//            int i = 1 / 0;
        }

    }

    @Override
    @Transactional
    public void removeQuestionByIdWithChoice(String id) {
//        List<String> choiceIds = nlQuestionnaireDbChoiceSingleMapper.getChoiceByQuestionId(id);
        this.baseMapper.deleteById(id);
        nlQuestionnaireDbChoiceSingleMapper.deleteByQuestionId(id);
    }

    @Override
    @Transactional
    public void updateQuestion(NlQuestionnaireSingleVO questionVO) {
        String choices = questionVO.getChoiceList();
        Map<String, String> choiceMap = (Map<String, String>) JSON.parse(choices);
        nlQuestionnaireDbChoiceSingleMapper.deleteByQuestionId(String.valueOf(questionVO.getId()));
        for (Map.Entry<String, String> entry : choiceMap.entrySet()) {
            String choiceContent = entry.getKey();
            Double choiceWeight = Double.parseDouble(entry.getValue());
            Integer questionId = questionVO.getId();
            NlQuestionnaireDbChoiceSingle choice = new NlQuestionnaireDbChoiceSingle();
            choice.setQuestionId(questionId);
            choice.setChoiceContent(choiceContent);
            choice.setChoiceScoreWeight(choiceWeight);
            choice.setDelFlag(0);
            choice.setSort(0);
//            nlQuestionnaireDbChoiceSingleMapper.insert(choice);
            nlQuestionnaireDbChoiceSingleMapper.add(choice);
//            int i = 1 / 0;
        }
    }

    @Override
    @Transactional
    public void removeQuestionByIdsWithChoice(List<String> ids) {
        for (String id : ids) {
            this.removeQuestionByIdWithChoice(id);
        }
    }
}
