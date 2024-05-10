package org.jeecg.modules.demo.nl_pyschology_reply.service;

import org.jeecg.modules.demo.nl_pyschology_reply.entity.NlEmployeePyschologyRequestReply;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Description: 心理状况回答表
 * @Author: jeecg-boot
 * @Date:   2024-05-10
 * @Version: V1.0
 */
public interface INlEmployeePyschologyRequestReplyService extends IService<NlEmployeePyschologyRequestReply> {

    List<NlEmployeePyschologyRequestReply> getByQuestionnaireIdAndEmployeeId(Integer listId1, String employeeId);
}
