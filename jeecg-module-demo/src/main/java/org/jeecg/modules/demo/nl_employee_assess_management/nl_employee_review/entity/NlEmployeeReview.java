package org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.entity;

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
 * @Description: 适岗能力初评
 * @Author: jeecg-boot
 * @Date:   2024-02-04
 * @Version: V1.0
 */
@Data
@TableName("nl_employee_review")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="nl_employee_review对象", description="适岗能力初评")
public class NlEmployeeReview implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.Integer id;
	/**审核信息的id*/
	@Excel(name = "审核信息的id", width = 15)
    @ApiModelProperty(value = "审核信息的id")
    private java.lang.Integer infoId;
	/**审核信息的类型*/
	@Excel(name = "审核信息的类型", width = 15)
    @ApiModelProperty(value = "审核信息的类型")
    private java.lang.Integer reviewType;
	/**审核结论*/
	@Excel(name = "审核结论", width = 15)
    @ApiModelProperty(value = "审核结论")
    private java.lang.Integer reviewResult;
	/**审核说明*/
	@Excel(name = "审核说明", width = 15)
    @ApiModelProperty(value = "审核说明")
    private java.lang.String reviewMsg;
	/**审核人id*/
	@Excel(name = "审核人id", width = 15)
    @ApiModelProperty(value = "审核人id")
    private java.lang.String reviewBy;
	/**审核时间*/
	@Excel(name = "审核时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "审核时间")
    private java.util.Date reviewTime;
}
