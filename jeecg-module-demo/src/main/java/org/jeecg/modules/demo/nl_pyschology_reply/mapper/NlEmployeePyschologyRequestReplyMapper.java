package org.jeecg.modules.demo.nl_pyschology_reply.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.nl_pyschology_reply.entity.NlEmployeePyschologyRequestReply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 心理状况回答表
 * @Author: jeecg-boot
 * @Date:   2024-05-10
 * @Version: V1.0
 */
public interface NlEmployeePyschologyRequestReplyMapper extends BaseMapper<NlEmployeePyschologyRequestReply> {

    List<NlEmployeePyschologyRequestReply> getByQuestionnaireIdAndEmployeeId(Integer listId, String employeeId);
}
