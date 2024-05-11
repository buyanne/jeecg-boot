package org.jeecg.modules.demo.nl_skill_reply.service.impl;

import org.jeecg.modules.demo.nl_skill_reply.entity.NlEmployeeSkillRequestReply;
import org.jeecg.modules.demo.nl_skill_reply.mapper.NlEmployeeSkillRequestReplyMapper;
import org.jeecg.modules.demo.nl_skill_reply.service.INlEmployeeSkillRequestReplyService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * @Description: 技能测评
 * @Author: jeecg-boot
 * @Date:   2024-05-11
 * @Version: V1.0
 */
@Service
public class NlEmployeeSkillRequestReplyServiceImpl extends ServiceImpl<NlEmployeeSkillRequestReplyMapper, NlEmployeeSkillRequestReply> implements INlEmployeeSkillRequestReplyService {

    @Override
    public List<NlEmployeeSkillRequestReply> getByQuestionnaireIdAndEmployeeId(Integer listId, String employeeId) {
        return this.baseMapper.getByQuestionnaireIdAndEmployeeId(listId,employeeId);
    }
}
