package org.jeecg.modules.demo.nl_skill_reply.service;

import org.jeecg.modules.demo.nl_skill_reply.entity.NlEmployeeSkillRequestReply;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Description: 技能测评
 * @Author: jeecg-boot
 * @Date:   2024-05-11
 * @Version: V1.0
 */
public interface INlEmployeeSkillRequestReplyService extends IService<NlEmployeeSkillRequestReply> {

    List<NlEmployeeSkillRequestReply> getByQuestionnaireIdAndEmployeeId(Integer listId, String employeeId);
}
