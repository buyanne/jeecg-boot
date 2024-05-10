package org.jeecg.modules.demo.nl_politics_reply.service;

import org.jeecg.modules.demo.nl_politics_reply.entity.NlEmployeePoliticsRequestReply;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.demo.nl_questionnaire_list.entity.NlQuestionnaireList;

import java.util.List;

/**
 * @Description: 思想状态回答表
 * @Author: jeecg-boot
 * @Date:   2024-05-08
 * @Version: V1.0
 */
public interface INlEmployeePoliticsRequestReplyService extends IService<NlEmployeePoliticsRequestReply> {

    List<NlEmployeePoliticsRequestReply> getByQuestionnaireIdAndEmployeeId(Integer listId1, String employeeId);
}
