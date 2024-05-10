package org.jeecg.modules.demo.nl_questionnaire_list.vo;

import lombok.Data;
import org.jeecg.modules.demo.nl_questionnaire_list.dto.ChoiceDTO;

import java.io.Serializable;
import java.util.List;

@Data
public class QuestionVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String questionName;
    private List<ChoiceDTO> choiceList;

}
