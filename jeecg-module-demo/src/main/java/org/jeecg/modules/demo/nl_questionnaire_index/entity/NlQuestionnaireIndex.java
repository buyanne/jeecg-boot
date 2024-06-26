package org.jeecg.modules.demo.nl_questionnaire_index.entity;

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
 * @Description: nl_questionnaire_index
 * @Author: jeecg-boot
 * @Date:   2024-04-19
 * @Version: V1.0
 */
@Data
@TableName("nl_questionnaire_index")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="nl_questionnaire_index对象", description="nl_questionnaire_index")
public class NlQuestionnaireIndex implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.Integer id;
	/**上级节点*/
	@Excel(name = "上级节点", width = 15)
    @ApiModelProperty(value = "上级节点")
    private java.lang.Integer parentId;
	/**指标名称*/
	@Excel(name = "指标名称", width = 15)
    @ApiModelProperty(value = "指标名称")
    private java.lang.String indexName;
	/**指标权重*/
	@Excel(name = "指标权重", width = 15)
    @ApiModelProperty(value = "指标权重")
    private java.lang.Double indexWeight;
	/**指标顺序*/
	@Excel(name = "指标顺序", width = 15)
    @ApiModelProperty(value = "指标顺序")
    private java.lang.Integer orderNum;
	/**适用阶段*/
	@Excel(name = "适用阶段", width = 15)
    @ApiModelProperty(value = "适用阶段")
    private java.lang.Integer stageType;
}
