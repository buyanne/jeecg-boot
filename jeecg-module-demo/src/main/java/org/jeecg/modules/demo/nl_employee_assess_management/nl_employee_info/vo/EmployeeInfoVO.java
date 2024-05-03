package org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_info.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

@Data
public class EmployeeInfoVO  implements Serializable {
    private static final long serialVersionUID = 1L;
    private java.lang.Integer id;
    private java.lang.String employeeId;
    private java.lang.String realname;
    private java.lang.Integer sex;
    private java.lang.String idNum;
    private java.util.Date birthday;
    private java.lang.String ancestral;
    private java.lang.Integer nation;

    private java.lang.Integer diploma;
    /**政治面貌*/
    private java.lang.Integer politicalOutlook;
    /**婚姻状态*/
    private java.lang.Integer maritalStatus;
    /**收入*/
    private java.lang.Integer income;
    /**首次获得驾驶证年份*/
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private java.util.Date firstDriverLiocenseDate;
    /**上传驾驶证相关证明材料*/
    @Excel(name = "上传驾驶证相关证明材料", width = 15)
    @ApiModelProperty(value = "上传驾驶证相关证明材料")
    private java.lang.String driverLicenseField;
    /**所属企业*/
    private java.lang.String enterprises;
    /**工作经验*/
    private java.lang.String workExperience;
    /**驾驶员资质*/
    private java.lang.String driverQualification;
    /**上传船员证*/
    private java.lang.String driverQualificationField;
    /**水上交通违法记录*/
    private java.lang.Integer trafficViolationRecord;
    /**驾驶岗位*/
    private java.lang.Integer driverPost;
    /**船员服务簿*/
    private java.lang.String recordBookField;
    private java.lang.Integer handleState;
    private java.lang.String handleOpinions;
    /**创建时间*/
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private java.util.Date createTime;
    /**更新时间*/
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private java.util.Date updateTime;


}
