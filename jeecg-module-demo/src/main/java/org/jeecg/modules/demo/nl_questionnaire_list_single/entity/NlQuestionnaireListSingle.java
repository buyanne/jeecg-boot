package org.jeecg.modules.demo.nl_questionnaire_list_single.entity;

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
 * @Description: 问卷表和题库表的中间表
 * @Author: jeecg-boot
 * @Date:   2024-05-02
 * @Version: V1.0
 */
@Data
@TableName("nl_questionnaire_list_single")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="nl_questionnaire_list_single对象", description="问卷表和题库表的中间表")
public class NlQuestionnaireListSingle implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.Integer id;
	/**questionnaireId*/
	@Excel(name = "questionnaireId", width = 15)
    @ApiModelProperty(value = "questionnaireId")
    private java.lang.Integer questionnaireId;
	/**listId*/
	@Excel(name = "listId", width = 15)
    @ApiModelProperty(value = "listId")
    private java.lang.Integer listId;
	/**createTime*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "createTime")
    private java.util.Date createTime;
	/**createBy*/
    @ApiModelProperty(value = "createBy")
    private java.lang.String createBy;
}
