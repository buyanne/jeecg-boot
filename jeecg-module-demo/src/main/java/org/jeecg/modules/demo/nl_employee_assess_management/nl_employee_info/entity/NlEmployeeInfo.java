package org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_info.entity;

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
 * @Description: 个体特征确认
 * @Author: jeecg-boot
 * @Date:   2024-01-31
 * @Version: V1.0
 */
@Data
@TableName("nl_employee_info")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="nl_employee_info对象", description="个体特征确认")
public class NlEmployeeInfo implements Serializable {
    private static final long serialVersionUID = 1L;

	/**id*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private java.lang.Integer id;
	/**用户id*/
	@Excel(name = "用户id", width = 15)
    @ApiModelProperty(value = "用户id")
    private java.lang.String employeeId;
	/**性别*/
	@Excel(name = "性别", width = 15)
    @ApiModelProperty(value = "性别")
    private java.lang.Integer sex;

	/**身份证号*/
	@Excel(name = "身份证号", width = 15)
    @ApiModelProperty(value = "身份证号")
    private java.lang.String idNum;
	/**出生年月*/
	@Excel(name = "出生年月", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "出生年月")
    private java.util.Date birthday;
	/**籍贯*/
	@Excel(name = "籍贯", width = 15)
    @ApiModelProperty(value = "籍贯")
    private java.lang.String ancestral;
	/**民族*/
	@Excel(name = "民族", width = 15)
    @ApiModelProperty(value = "民族")
    private java.lang.Integer nation;
	/**文化程度*/
	@Excel(name = "文化程度", width = 15)
    @ApiModelProperty(value = "文化程度")
    private java.lang.Integer diploma;
	/**政治面貌*/
	@Excel(name = "政治面貌", width = 15)
    @ApiModelProperty(value = "政治面貌")
    private java.lang.Integer politicalOutlook;
	/**婚姻状态*/
	@Excel(name = "婚姻状态", width = 15)
    @ApiModelProperty(value = "婚姻状态")
    private java.lang.Integer maritalStatus;
	/**收入*/
	@Excel(name = "收入", width = 15)
    @ApiModelProperty(value = "收入")
    private java.lang.Integer income;
	/**首次获得驾驶证年份*/
	@Excel(name = "首次获得驾驶证年份", width = 15, format = "yyyy-MM-dd")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    @ApiModelProperty(value = "首次获得驾驶证年份")
    private java.util.Date firstDriverLiocenseDate;
	/**上传驾驶证相关证明材料*/
	@Excel(name = "上传驾驶证相关证明材料", width = 15)
    @ApiModelProperty(value = "上传驾驶证相关证明材料")
    private java.lang.String driverLicenseField;
	/**所属企业*/
	@Excel(name = "所属企业", width = 15)
    @ApiModelProperty(value = "所属企业")
    private java.lang.String enterprises;
	/**工作经验*/
	@Excel(name = "工作经验", width = 15)
    @ApiModelProperty(value = "工作经验")
    private java.lang.String workExperience;
	/**驾驶员资质*/
	@Excel(name = "驾驶员资质", width = 15)
    @ApiModelProperty(value = "驾驶员资质")
    private java.lang.String driverQualification;
	/**上传船员证*/
	@Excel(name = "上传船员证", width = 15)
    @ApiModelProperty(value = "上传船员证")
    private java.lang.String driverQualificationField;
	/**水上交通违法记录*/
	@Excel(name = "水上交通违法记录", width = 15)
    @ApiModelProperty(value = "水上交通违法记录")
    private java.lang.Integer trafficViolationRecord;
	/**驾驶岗位*/
	@Excel(name = "驾驶岗位", width = 15)
    @ApiModelProperty(value = "驾驶岗位")
    private java.lang.Integer driverPost;
	/**船员服务簿*/
	@Excel(name = "船员服务簿", width = 15)
    @ApiModelProperty(value = "船员服务簿")
    private java.lang.String recordBookField;
	/**处理状态*/
	@Excel(name = "处理状态", width = 15)
    @ApiModelProperty(value = "处理状态")
    private java.lang.Integer handleState;
	/**处理意见*/
	@Excel(name = "处理意见", width = 15)
    @ApiModelProperty(value = "处理意见")
    private java.lang.String handleOpinions;
	/**创建时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private java.util.Date createTime;
	/**更新时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private java.util.Date updateTime;
}
