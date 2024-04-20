package org.jeecg.modules.demo.nl_questionnaire_db_single.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.modules.demo.nl_questionnaire_db_single.entity.NlQuestionnaireDbSingle;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.demo.nl_questionnaire_db_single.vo.NlQuestionnaireSingleVO;

import java.util.HashMap;
import java.util.List;

/**
 * @Description: 问卷题库管理
 * @Author: jeecg-boot
 * @Date:   2024-04-20
 * @Version: V1.0
 */
public interface INlQuestionnaireDbSingleService extends IService<NlQuestionnaireDbSingle> {


    IPage<NlQuestionnaireSingleVO> getQuestionPage(Page<NlQuestionnaireSingleVO> page, HashMap<String, Object> params);

    void saveQuestionWithChoice(NlQuestionnaireSingleVO singleVO);

    void removeQuestionByIdWithChoice(String id);

    void updateQuestion(NlQuestionnaireSingleVO questionVO);

    void removeQuestionByIdsWithChoice(List<String> list);
}
