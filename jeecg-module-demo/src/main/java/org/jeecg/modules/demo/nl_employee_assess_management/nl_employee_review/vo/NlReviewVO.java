package org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class NlReviewVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private java.lang.Integer id;
    private java.lang.Integer infoId;
    private java.lang.Integer reviewType;
    private java.lang.Integer reviewResult;

    private java.lang.String realname;

}
