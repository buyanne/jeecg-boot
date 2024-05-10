package org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_interview_info.vo;

import cn.hutool.core.date.DateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

@Data
public class SpecialistInterviewVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private java.lang.Integer id;
    private java.lang.String employeeId;
    private java.lang.String employeeName;
    private java.lang.String specialistId;
    private java.lang.String specialistName;
    private java.util.Date interviewerStartTime;
    private java.util.Date interviewerEndTime;
    private java.lang.String interviewPlace;
    private java.lang.String createBy;
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private java.util.Date createTime;
}
