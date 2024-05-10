package org.jeecg.modules.demo.sleep_reply.service;

import org.jeecg.modules.demo.sleep_reply.entity.NlEmployeeSleepRequestReply;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Description: 睡眠质量测评
 * @Author: jeecg-boot
 * @Date:   2024-05-11
 * @Version: V1.0
 */
public interface INlEmployeeSleepRequestReplyService extends IService<NlEmployeeSleepRequestReply> {

    List<NlEmployeeSleepRequestReply> getByQuestionnaireIdAndEmployeeId(Integer listId1, String employeeId);
}
