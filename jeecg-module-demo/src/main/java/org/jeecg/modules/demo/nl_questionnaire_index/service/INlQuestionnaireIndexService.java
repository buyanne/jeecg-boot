package org.jeecg.modules.demo.nl_questionnaire_index.service;

import org.jeecg.modules.demo.nl_questionnaire_index.entity.NlQuestionnaireIndex;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Description: nl_questionnaire_index
 * @Author: jeecg-boot
 * @Date:   2024-04-19
 * @Version: V1.0
 */
public interface INlQuestionnaireIndexService extends IService<NlQuestionnaireIndex> {

    void removeByIdWithSubTree(String id);

    void removeByIdsWithSubTree(List<String> list);
}
