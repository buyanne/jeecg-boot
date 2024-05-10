package org.jeecg.modules.demo.nl_employee_management_assessment.entity;

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
 * @Description: 管理沟通能力
 * @Author: jeecg-boot
 * @Date:   2024-05-11
 * @Version: V1.0
 */
@Data
@TableName("nl_employee_management_assessment")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="nl_employee_management_assessment对象", description="管理沟通能力")
public class NlEmployeeManagementAssessment implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.Integer id;
	/**employeeId*/
	@Excel(name = "employeeId", width = 15)
    @ApiModelProperty(value = "employeeId")
    private java.lang.String employeeId;
	/**测评计划id*/
	@Excel(name = "测评计划id", width = 15)
    @ApiModelProperty(value = "测评计划id")
    private java.lang.Integer planId;
	/**领导能力打分*/
	@Excel(name = "领导能力打分", width = 15)
    @ApiModelProperty(value = "领导能力打分")
    private java.lang.Double leadershipScore;
	/**组织协调能力打分*/
	@Excel(name = "组织协调能力打分", width = 15)
    @ApiModelProperty(value = "组织协调能力打分")
    private java.lang.Double orgCoordinationScore;
	/**沟通交流能力打分*/
	@Excel(name = "沟通交流能力打分", width = 15)
    @ApiModelProperty(value = "沟通交流能力打分")
    private java.lang.Double communicationScore;
	/**specialistId*/
	@Excel(name = "specialistId", width = 15)
    @ApiModelProperty(value = "specialistId")
    private java.lang.String specialistId;
}
