package org.jeecg.modules.demo.nl_employee_management_assessment.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrgManagementVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String employeeId;
    private String employeeName;
    private String specialistId;
    private String specialistName;
    private Double leadershipScore;
    private Double orgCoordinationScore;
    private Double communicationScore;
}
