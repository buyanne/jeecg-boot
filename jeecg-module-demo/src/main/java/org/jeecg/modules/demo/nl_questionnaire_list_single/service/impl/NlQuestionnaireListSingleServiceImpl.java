package org.jeecg.modules.demo.nl_questionnaire_list_single.service.impl;

import org.jeecg.modules.demo.nl_questionnaire_list_single.entity.NlQuestionnaireListSingle;
import org.jeecg.modules.demo.nl_questionnaire_list_single.mapper.NlQuestionnaireListSingleMapper;
import org.jeecg.modules.demo.nl_questionnaire_list_single.service.INlQuestionnaireListSingleService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 问卷表和题库表的中间表
 * @Author: jeecg-boot
 * @Date:   2024-05-02
 * @Version: V1.0
 */
@Service
public class NlQuestionnaireListSingleServiceImpl extends ServiceImpl<NlQuestionnaireListSingleMapper, NlQuestionnaireListSingle> implements INlQuestionnaireListSingleService {
    public void removeByListId(Integer listId) {
        this.baseMapper.deleteByListId(listId);
    }
}
