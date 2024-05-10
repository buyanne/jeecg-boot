package org.jeecg.modules.demo.sleep_reply.service.impl;

import org.jeecg.modules.demo.sleep_reply.entity.NlEmployeeSleepRequestReply;
import org.jeecg.modules.demo.sleep_reply.mapper.NlEmployeeSleepRequestReplyMapper;
import org.jeecg.modules.demo.sleep_reply.service.INlEmployeeSleepRequestReplyService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

/**
 * @Description: 睡眠质量测评
 * @Author: jeecg-boot
 * @Date:   2024-05-11
 * @Version: V1.0
 */
@Service
public class NlEmployeeSleepRequestReplyServiceImpl extends ServiceImpl<NlEmployeeSleepRequestReplyMapper, NlEmployeeSleepRequestReply> implements INlEmployeeSleepRequestReplyService {

    @Override
    public List<NlEmployeeSleepRequestReply> getByQuestionnaireIdAndEmployeeId(Integer listId, String employeeId) {
        return this.baseMapper.getByQuestionnaireIdAndEmployeeId(listId,employeeId);
    }
}
