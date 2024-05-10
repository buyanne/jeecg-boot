package org.jeecg.modules.demo.physiology_info.entity;

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
 * @Description: 生理状况测评
 * @Author: jeecg-boot
 * @Date:   2024-05-11
 * @Version: V1.0
 */
@Data
@TableName("nl_employee_physiology_info")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="nl_employee_physiology_info对象", description="生理状况测评")
public class NlEmployeePhysiologyInfo implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.Integer id;
	/**用户id*/
	@Excel(name = "用户id", width = 15)
    @ApiModelProperty(value = "用户id")
    private java.lang.String employeeId;
	/**升高（cm）*/
	@Excel(name = "升高（cm）", width = 15)
    @ApiModelProperty(value = "升高（cm）")
    private java.math.BigDecimal height;
	/**体重（kg）*/
	@Excel(name = "体重（kg）", width = 15)
    @ApiModelProperty(value = "体重（kg）")
    private java.math.BigDecimal weight;
	/**肢体*/
	@Excel(name = "肢体", width = 15)
    @ApiModelProperty(value = "肢体")
    private java.lang.Integer limbs;
	/**听力*/
	@Excel(name = "听力", width = 15)
    @ApiModelProperty(value = "听力")
    private java.lang.Integer hearing;
	/**左眼视力*/
	@Excel(name = "左眼视力", width = 15)
    @ApiModelProperty(value = "左眼视力")
    private java.math.BigDecimal eyesightLeft;
	/**右眼视力*/
	@Excel(name = "右眼视力", width = 15)
    @ApiModelProperty(value = "右眼视力")
    private java.math.BigDecimal eyesightRight;
	/**语言能力*/
	@Excel(name = "语言能力", width = 15)
    @ApiModelProperty(value = "语言能力")
    private java.lang.Integer languageAbility;
	/**呼吸频次（次/分钟）*/
	@Excel(name = "呼吸频次（次/分钟）", width = 15)
    @ApiModelProperty(value = "呼吸频次（次/分钟）")
    private java.lang.Integer respiratoryRate;
	/**舒张压*/
	@Excel(name = "舒张压", width = 15)
    @ApiModelProperty(value = "舒张压")
    private java.lang.String diastolicPressure;
	/**收缩压*/
	@Excel(name = "收缩压", width = 15)
    @ApiModelProperty(value = "收缩压")
    private java.lang.String systolicPressure;
	/**心率*/
	@Excel(name = "心率", width = 15)
    @ApiModelProperty(value = "心率")
    private java.lang.Integer heartRate;
	/**心电*/
	@Excel(name = "心电", width = 15)
    @ApiModelProperty(value = "心电")
    private java.lang.Integer electrocardiograph;
	/**睡眠质量*/
	@Excel(name = "睡眠质量", width = 15)
    @ApiModelProperty(value = "睡眠质量")
    private java.lang.Double sleepSingleId;
	/**血常规异常项数量*/
	@Excel(name = "血常规异常项数量", width = 15)
    @ApiModelProperty(value = "血常规异常项数量")
    private java.lang.Integer abnormalBlooddRoutineNum;
	/**血常规异常项*/
	@Excel(name = "血常规异常项", width = 15)
    @ApiModelProperty(value = "血常规异常项")
    private java.lang.String abnorrmalBloodRoutine;
	/**尿常规异常项数量*/
	@Excel(name = "尿常规异常项数量", width = 15)
    @ApiModelProperty(value = "尿常规异常项数量")
    private java.lang.Integer abnormalUrineRoutineNum;
	/**尿常规异常项*/
	@Excel(name = "尿常规异常项", width = 15)
    @ApiModelProperty(value = "尿常规异常项")
    private java.lang.String abnormalUrineRoutine;
	/**肝功能异常项数量*/
	@Excel(name = "肝功能异常项数量", width = 15)
    @ApiModelProperty(value = "肝功能异常项数量")
    private java.lang.Integer abnormalLiverFunctionNum;
	/**肝功能异常项*/
	@Excel(name = "肝功能异常项", width = 15)
    @ApiModelProperty(value = "肝功能异常项")
    private java.lang.String abnormalLiverFunction;
	/**血糖*/
	@Excel(name = "血糖", width = 15)
    @ApiModelProperty(value = "血糖")
    private java.math.BigDecimal bloodSugar;
	/**胸部x线检查描述*/
	@Excel(name = "胸部x线检查描述", width = 15)
    @ApiModelProperty(value = "胸部x线检查描述")
    private java.lang.String chestxrayDescribe;
	/**胸部x线检查结论*/
	@Excel(name = "胸部x线检查结论", width = 15)
    @ApiModelProperty(value = "胸部x线检查结论")
    private java.lang.Integer chestxrayConclusion;
	/**既往史*/
	@Excel(name = "既往史", width = 15)
    @ApiModelProperty(value = "既往史")
    private java.lang.Integer pasthistoryDisease;
	/**疾病*/
	@Excel(name = "疾病", width = 15)
    @ApiModelProperty(value = "疾病")
    private java.lang.Integer disease;
	/**上传体检报告*/
	@Excel(name = "上传体检报告", width = 15)
    @ApiModelProperty(value = "上传体检报告")
    private java.lang.String medicalexaminaFiled;
	/**上传时间*/
	@Excel(name = "上传时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "上传时间")
    private java.util.Date updoadDate;
	/**处理状态*/
	@Excel(name = "处理状态", width = 15)
    @ApiModelProperty(value = "处理状态")
    private java.lang.Integer handleState;
	/**处理意见*/
	@Excel(name = "处理意见", width = 15)
    @ApiModelProperty(value = "处理意见")
    private java.lang.String handleOpinions;
}
