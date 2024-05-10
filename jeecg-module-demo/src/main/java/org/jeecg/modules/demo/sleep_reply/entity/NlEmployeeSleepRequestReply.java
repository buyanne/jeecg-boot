package org.jeecg.modules.demo.sleep_reply.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 睡眠质量测评
 * @Author: jeecg-boot
 * @Date:   2024-05-11
 * @Version: V1.0
 */
@Data
@TableName("nl_employee_sleep_request_reply")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="nl_employee_sleep_request_reply对象", description="睡眠质量测评")
public class NlEmployeeSleepRequestReply implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.Integer id;
	/**用户id*/
	@Excel(name = "用户id", width = 15)
    @ApiModelProperty(value = "用户id")
    private java.lang.String employeeId;
	/**测评计划id*/
	@Excel(name = "测评计划id", width = 15)
    @ApiModelProperty(value = "测评计划id")
    private java.lang.Integer planId;
	/**问卷编号*/
	@Excel(name = "问卷编号", width = 15)
    @ApiModelProperty(value = "问卷编号")
    private java.lang.Integer questionnaireId;
	/**问题id*/
	@Excel(name = "问题id", width = 15)
    @ApiModelProperty(value = "问题id")
    private java.lang.Integer questionId;
	/**用户的选项*/
	@Excel(name = "用户的选项", width = 15)
    @ApiModelProperty(value = "用户的选项")
    private java.lang.Integer answerId;
	/**本题得分*/
	@Excel(name = "本题得分", width = 15)
    @ApiModelProperty(value = "本题得分")
    private java.lang.Double score;
}
