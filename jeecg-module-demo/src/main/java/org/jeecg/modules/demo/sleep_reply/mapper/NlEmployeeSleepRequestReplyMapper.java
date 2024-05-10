package org.jeecg.modules.demo.sleep_reply.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.sleep_reply.entity.NlEmployeeSleepRequestReply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 睡眠质量测评
 * @Author: jeecg-boot
 * @Date:   2024-05-11
 * @Version: V1.0
 */
public interface NlEmployeeSleepRequestReplyMapper extends BaseMapper<NlEmployeeSleepRequestReply> {

    List<NlEmployeeSleepRequestReply> getByQuestionnaireIdAndEmployeeId(Integer listId, String employeeId);
}
