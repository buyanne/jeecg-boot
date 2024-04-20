package org.jeecg.modules.demo.nl_questionnaire_db_single.vo;

import lombok.Data;
import org.jeecg.modules.demo.nl_questionnaire_db_choice_single.entity.NlQuestionnaireDbChoiceSingle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class NlQuestionnaireSingleVO implements Serializable {
    private static final long serialVersionUID = 1L;

    private java.lang.Integer id;
    private java.lang.Integer questionnaireType;
    private java.lang.String questionnaireIndexName;
    private java.lang.String questionName;
    private java.lang.Integer delFlag;
//    private List<NlQuestionnaireDbChoiceSingle> choiceList;
    private java.lang.String choiceList;
    public NlQuestionnaireSingleVO() {
//        this.choiceList = new ArrayList<>();
        this.delFlag = 0;
    }


}
