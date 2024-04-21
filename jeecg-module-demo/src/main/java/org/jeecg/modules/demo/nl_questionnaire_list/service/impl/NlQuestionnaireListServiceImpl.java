package org.jeecg.modules.demo.nl_questionnaire_list.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.modules.demo.nl_questionnaire_list.entity.NlQuestionnaireList;
import org.jeecg.modules.demo.nl_questionnaire_list.mapper.NlQuestionnaireListMapper;
import org.jeecg.modules.demo.nl_questionnaire_list.service.INlQuestionnaireListService;
import org.jeecg.modules.demo.nl_questionnaire_list.vo.NlQuestionnaireListVO;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.HashMap;

/**
 * @Description: 测评问卷生成
 * @Author: jeecg-boot
 * @Date: 2024-04-21
 * @Version: V1.0
 */
@Service
public class NlQuestionnaireListServiceImpl extends ServiceImpl<NlQuestionnaireListMapper, NlQuestionnaireList> implements INlQuestionnaireListService {

    @Override
    public IPage<NlQuestionnaireListVO> getQuestionnairePage(Page<NlQuestionnaireListVO> page, HashMap<String, String> params) {
        return this.baseMapper.getQuestionnairePage(page, params);
    }
}
