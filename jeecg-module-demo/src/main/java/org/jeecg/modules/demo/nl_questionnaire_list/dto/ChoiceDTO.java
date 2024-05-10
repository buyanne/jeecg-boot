package org.jeecg.modules.demo.nl_questionnaire_list.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ChoiceDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private Integer questionId;
    private String choiceContent;
    private Double choiceScoreWeight;
}
