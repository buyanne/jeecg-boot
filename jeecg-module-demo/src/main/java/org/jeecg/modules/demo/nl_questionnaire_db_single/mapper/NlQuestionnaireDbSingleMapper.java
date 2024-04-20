package org.jeecg.modules.demo.nl_questionnaire_db_single.mapper;

import java.util.HashMap;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.modules.demo.nl_questionnaire_db_single.entity.NlQuestionnaireDbSingle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jeecg.modules.demo.nl_questionnaire_db_single.vo.NlQuestionnaireSingleVO;

/**
 * @Description: 问卷题库管理
 * @Author: jeecg-boot
 * @Date:   2024-04-20
 * @Version: V1.0
 */
public interface NlQuestionnaireDbSingleMapper extends BaseMapper<NlQuestionnaireDbSingle> {

    IPage<NlQuestionnaireSingleVO> getQuestionWithName(Page<NlQuestionnaireSingleVO> page, HashMap<String, Object> params);
}
