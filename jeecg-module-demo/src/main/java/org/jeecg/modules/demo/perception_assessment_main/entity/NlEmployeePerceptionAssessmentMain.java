package org.jeecg.modules.demo.perception_assessment_main.entity;

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
 * @Description: 综合感知测评主表
 * @Author: jeecg-boot
 * @Date:   2024-05-10
 * @Version: V1.0
 */
@Data
@TableName("nl_employee_perception_assessment_main")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="nl_employee_perception_assessment_main对象", description="综合感知测评主表")
public class NlEmployeePerceptionAssessmentMain implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.Integer id;
	/**用户id*/
	@Excel(name = "用户id", width = 15)
    @ApiModelProperty(value = "用户id")
    private java.lang.Integer employeeId;
	/**测评计划id*/
	@Excel(name = "测评计划id", width = 15)
    @ApiModelProperty(value = "测评计划id")
    private java.lang.Integer planId;
	/**速度感知能力分数*/
	@Excel(name = "速度感知能力分数", width = 15)
    @ApiModelProperty(value = "速度感知能力分数")
    private java.lang.Double speedPerceptionScore;
	/**距离感知能力分数*/
	@Excel(name = "距离感知能力分数", width = 15)
    @ApiModelProperty(value = "距离感知能力分数")
    private java.lang.Double disPerceptionScore;
	/**空间感知能力分数*/
	@Excel(name = "空间感知能力分数", width = 15)
    @ApiModelProperty(value = "空间感知能力分数")
    private java.lang.Double spacePerceptionScore;
}
