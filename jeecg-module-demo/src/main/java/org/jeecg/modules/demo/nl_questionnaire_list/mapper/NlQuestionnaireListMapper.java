package org.jeecg.modules.demo.nl_questionnaire_list.mapper;

import java.util.HashMap;
import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.nl_questionnaire_list.entity.NlQuestionnaireList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jeecg.modules.demo.nl_questionnaire_list.vo.NlQuestionnaireListVO;
import org.jeecg.modules.demo.nl_questionnaire_list.vo.QuestionVO;

/**
 * @Description: 测评问卷生成
 * @Author: jeecg-boot
 * @Date:   2024-04-21
 * @Version: V1.0
 */
public interface NlQuestionnaireListMapper extends BaseMapper<NlQuestionnaireList> {

    IPage<NlQuestionnaireListVO> getQuestionnairePage(Page<NlQuestionnaireListVO> page, HashMap<String, String> params);

    List<QuestionVO> getQuestionByListId(String listId);
}
