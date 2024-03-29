package org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_interview_info.vo;

import cn.hutool.core.date.DateTime;
import lombok.Data;

import java.io.Serializable;

@Data
public class SpecialistInterviewVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private java.lang.Integer id;
    private java.lang.String employeeId;
    private java.lang.String name;
    private java.lang.String specialistId;
    private java.lang.String specialistName;
    private java.util.Date interviewerStartTime;
    private java.util.Date interviewerEndTime;
    private java.lang.String interviewPlace;

}
