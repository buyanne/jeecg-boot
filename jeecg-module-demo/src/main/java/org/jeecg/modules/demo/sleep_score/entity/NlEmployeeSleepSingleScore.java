package org.jeecg.modules.demo.sleep_score.entity;

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
 * @Description: 睡眠测评得分
 * @Author: jeecg-boot
 * @Date:   2024-05-11
 * @Version: V1.0
 */
@Data
@TableName("nl_employee_sleep_single_score")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="nl_employee_sleep_single_score对象", description="睡眠测评得分")
public class NlEmployeeSleepSingleScore implements Serializable {
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
	/**问卷id*/
	@Excel(name = "问卷id", width = 15)
    @ApiModelProperty(value = "问卷id")
    private java.lang.Integer questionnaireId;
	/**问卷得分*/
	@Excel(name = "问卷得分", width = 15)
    @ApiModelProperty(value = "问卷得分")
    private java.lang.Double questionScore;
	/**提交时间*/
	@Excel(name = "提交时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "提交时间")
    private java.util.Date submitTime;
}
