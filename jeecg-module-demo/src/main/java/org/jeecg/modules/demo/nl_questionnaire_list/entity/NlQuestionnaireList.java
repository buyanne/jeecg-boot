package org.jeecg.modules.demo.nl_questionnaire_list.entity;

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
 * @Description: 测评问卷生成
 * @Author: jeecg-boot
 * @Date:   2024-04-21
 * @Version: V1.0
 */
@Data
@TableName("nl_questionnaire_list")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="nl_questionnaire_list对象", description="测评问卷生成")
public class NlQuestionnaireList implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.Integer id;
	/**测评计划id*/
	@Excel(name = "测评计划id", width = 15)
    @ApiModelProperty(value = "测评计划id")
    private java.lang.Integer planId;
	/**问卷类型*/
	@Excel(name = "问卷类型", width = 15)
    @ApiModelProperty(value = "问卷类型")
    private java.lang.Integer questionnaireType;
	/**问卷标题*/
	@Excel(name = "问卷标题", width = 15)
    @ApiModelProperty(value = "问卷标题")
    private java.lang.String questionTitle;
	/**问卷说明*/
	@Excel(name = "问卷说明", width = 15)
    @ApiModelProperty(value = "问卷说明")
    private java.lang.String questionDescription;
	/**单选题小分*/
	@Excel(name = "单选题小分", width = 15)
    @ApiModelProperty(value = "单选题小分")
    private java.lang.Double singleScore;
	/**单选题数量*/
	@Excel(name = "单选题数量", width = 15)
    @ApiModelProperty(value = "单选题数量")
    private java.lang.Integer singleNum;
	/**多选题小分*/
	@Excel(name = "多选题小分", width = 15)
    @ApiModelProperty(value = "多选题小分")
    private java.lang.Double multiScore;
	/**多选题数量*/
	@Excel(name = "多选题数量", width = 15)
    @ApiModelProperty(value = "多选题数量")
    private java.lang.Integer multiNum;
	/**问卷总分*/
	@Excel(name = "问卷总分", width = 15)
    @ApiModelProperty(value = "问卷总分")
    private java.lang.Double totalScore;
	/**问卷完成总时间*/
	@Excel(name = "问卷完成总时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
//	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "问卷完成总时间")
    private java.lang.String totalTime;
	/**问卷开始时间*/
	@Excel(name = "问卷开始时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "问卷开始时间")
    private java.util.Date questionStartTime;
	/**问卷结束时间*/
	@Excel(name = "问卷结束时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "问卷结束时间")
    private java.util.Date questionEndTime;
	/**问卷创建时间*/
	@Excel(name = "问卷创建时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "问卷创建时间")
    private java.util.Date questionAddTime;
	/**创建人id*/
    @ApiModelProperty(value = "创建人id")
    private java.lang.String createBy;

    private java.lang.String questionType;
}
