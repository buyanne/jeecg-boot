package org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_interview_info.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 专家面试预约
 * @Author: jeecg-boot
 * @Date:   2024-03-27
 * @Version: V1.0
 */
@Data
@TableName("nl_employee_intview_info")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="nl_employee_intview_info对象", description="专家面试预约")
public class NlEmployeeIntviewInfo implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.String id;
	/**面试人id*/
	@Excel(name = "面试人id", width = 15)
    @ApiModelProperty(value = "面试人id")
    private java.lang.String employeeId;
	/**面试专家id*/
	@Excel(name = "面试专家id", width = 15)
    @ApiModelProperty(value = "面试专家id")
    private java.lang.Integer specialistId;
	/**面试开始时间*/
	@Excel(name = "面试开始时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "面试开始时间")
    private java.util.Date interviewerStartTime;
	/**面试结束时间*/
	@Excel(name = "面试结束时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "面试结束时间")
    private java.util.Date interviewerEndTime;
	/**面试地点*/
	@Excel(name = "面试地点", width = 15)
    @ApiModelProperty(value = "面试地点")
    private java.lang.String interviewPlace;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private java.util.Date createTime;
}
