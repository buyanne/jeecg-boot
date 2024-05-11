package org.jeecg.modules.demo.nl_skill_reply.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jeecg.modules.demo.nl_skill_reply.entity.NlEmployeeSkillRequestReply;

import java.util.List;

/**
 * @Description: 技能测评
 * @Author: jeecg-boot
 * @Date:   2024-05-11
 * @Version: V1.0
 */
public interface NlEmployeeSkillRequestReplyMapper extends BaseMapper<NlEmployeeSkillRequestReply> {

    List<NlEmployeeSkillRequestReply> getByQuestionnaireIdAndEmployeeId(Integer listId, String employeeId);
}
