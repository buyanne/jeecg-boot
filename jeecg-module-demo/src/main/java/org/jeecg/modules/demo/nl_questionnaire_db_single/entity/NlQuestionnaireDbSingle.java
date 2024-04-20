package org.jeecg.modules.demo.nl_questionnaire_db_single.entity;

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
 * @Description: 问卷题库管理
 * @Author: jeecg-boot
 * @Date: 2024-04-20
 * @Version: V1.0
 */
@Data
@TableName("nl_questionnaire_db_single")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "nl_questionnaire_db_single对象", description = "问卷题库管理")
public class NlQuestionnaireDbSingle implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.Integer id;
    /**
     * 题目类型
     */
    @Excel(name = "题目类型", width = 15)
    @ApiModelProperty(value = "题目类型")
    private java.lang.Integer questionnaireType;
    /**
     * 问题描述
     */
    @Excel(name = "问题描述", width = 15)
    @ApiModelProperty(value = "问题描述")
    private java.lang.String questionName;
    /**
     * 创建时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private java.util.Date createTime;
    /**
     * 创建人
     */
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
    /**
     * 是否逻辑删除
     */
    @Excel(name = "是否逻辑删除", width = 15)
    @ApiModelProperty(value = "是否逻辑删除")
//    @TableLogic(value = "false")
    private java.lang.Integer delFlag;
}
