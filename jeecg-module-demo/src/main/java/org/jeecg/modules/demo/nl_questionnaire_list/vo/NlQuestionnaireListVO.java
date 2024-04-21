package org.jeecg.modules.demo.nl_questionnaire_list.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

@Data
public class NlQuestionnaireListVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private java.lang.Integer id;
    private java.lang.Integer planId;
    private java.lang.String planName;
    private java.lang.Integer questionnaireType;
    private java.lang.String indexName;
    private java.lang.String questionTitle;
    private java.lang.String questionDescription;
    // 适用的人员类型
    private java.lang.String roleList;
    private java.lang.Double singleScore;
    private java.lang.Integer singleNum;
    private java.lang.Double multiScore;
    private java.lang.Integer multiNum;
    private java.lang.Double totalScore;
    private java.lang.String totalTime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date questionStartTime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date questionEndTime;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private java.util.Date questionAddTime;
}
