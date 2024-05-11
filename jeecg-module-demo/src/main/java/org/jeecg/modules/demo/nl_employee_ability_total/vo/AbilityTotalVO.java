package org.jeecg.modules.demo.nl_employee_ability_total.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class AbilityTotalVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String employeeId;
    private String employeeName;
    private String planId;
    private String planName;
    private String idNum;
    private Integer handleState;

}
