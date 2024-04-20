package org.jeecg.modules.demo.nl_questionnaire_db_choice_single.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.nl_questionnaire_db_choice_single.entity.NlQuestionnaireDbChoiceSingle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: nl_questionnaire_db_choice_single
 * @Author: jeecg-boot
 * @Date:   2024-04-20
 * @Version: V1.0
 */
public interface NlQuestionnaireDbChoiceSingleMapper extends BaseMapper<NlQuestionnaireDbChoiceSingle> {

    void add(NlQuestionnaireDbChoiceSingle choice);

    void deleteByQuestionId(String questionId);

    List<NlQuestionnaireDbChoiceSingle> getChoiceByQuestionId(Integer questionId);
}
