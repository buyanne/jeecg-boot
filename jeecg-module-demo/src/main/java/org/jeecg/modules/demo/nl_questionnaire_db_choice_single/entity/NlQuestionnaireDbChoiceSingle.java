package org.jeecg.modules.demo.nl_questionnaire_db_choice_single.entity;

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
 * @Description: nl_questionnaire_db_choice_single
 * @Author: jeecg-boot
 * @Date:   2024-04-20
 * @Version: V1.0
 */
@Data
@TableName("nl_questionnaire_db_choice_single")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="nl_questionnaire_db_choice_single对象", description="nl_questionnaire_db_choice_single")
public class NlQuestionnaireDbChoiceSingle implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.Integer id;
	/**问题编号*/
	@Excel(name = "问题编号", width = 15)
    @ApiModelProperty(value = "问题编号")
    private java.lang.Integer questionId;
	/**选项内容*/
	@Excel(name = "选项内容", width = 15)
    @ApiModelProperty(value = "选项内容")
    private java.lang.String choiceContent;
	/**选项分数权重*/
	@Excel(name = "选项分数权重", width = 15)
    @ApiModelProperty(value = "选项分数权重")
    private java.lang.Double choiceScoreWeight;
	/**次序*/
	@Excel(name = "次序", width = 15)
    @ApiModelProperty(value = "次序")
    private java.lang.Integer sort;
	/**是否逻辑删除*/
	@Excel(name = "是否逻辑删除", width = 15)
    @ApiModelProperty(value = "是否逻辑删除")
//    @TableLogic
    private java.lang.Integer delFlag;
}
