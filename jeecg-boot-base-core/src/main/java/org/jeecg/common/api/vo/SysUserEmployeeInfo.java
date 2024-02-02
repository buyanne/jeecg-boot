package org.jeecg.common.api.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
public class SysUserEmployeeInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private java.lang.Integer id;

    private java.lang.String employeeId;

    private java.lang.String name;

    private java.lang.Integer sex;
    private java.lang.String idNum;
    private java.util.Date birthday;
    private java.lang.String ancestral;
    private java.lang.Integer nation;
    private java.lang.Integer diploma;
    private java.lang.Integer politicalOutlook;
    private java.lang.Integer maritalStatus;
    private java.lang.Integer income;
    private java.util.Date firstDriverLiocenseDate;
    private java.lang.String driverLicenseFileid;
    private java.lang.String enterprises;
    private java.lang.String workExperience;
    private java.lang.String driverQualification;
    private java.lang.String driverQualificationFileid;
    private java.lang.Integer trafficViolationRecord;
    private java.lang.Integer driverPost;
    private java.lang.String recordBookFileid;
    private java.lang.Integer handleState;
    private java.lang.String handleOpinions;
    private java.util.Date createTime;
    private java.util.Date updateTime;
}