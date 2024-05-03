package org.jeecg.modules.demo.nl_questionnaire_list.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.modules.demo.nl_questionnaire_index.mapper.NlQuestionnaireIndexMapper;
import org.jeecg.modules.demo.nl_questionnaire_list.entity.NlQuestionnaireList;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.demo.nl_questionnaire_list.vo.NlQuestionnaireListVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

/**
 * @Description: 测评问卷生成
 * @Author: jeecg-boot
 * @Date: 2024-04-21
 * @Version: V1.0
 */
public interface INlQuestionnaireListService extends IService<NlQuestionnaireList> {



    IPage<NlQuestionnaireListVO> getQuestionnairePage(Page<NlQuestionnaireListVO> page, HashMap<String, String> params);

    void saveWithRandomQuestion(NlQuestionnaireList nlQuestionnaireList);

    void updateWithQuestion(NlQuestionnaireList nlQuestionnaireList);

    void removeByIdWithQuestion(String id);

    void removeByIdsWithQuestion(List<String> ids);
}
