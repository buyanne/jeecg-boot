package org.jeecg.modules.demo.nl_questionnaire_index.vo;

import lombok.Data;
import org.jeecg.modules.demo.nl_questionnaire_index.entity.NlQuestionnaireIndex;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class IndexTreeVO implements Serializable {
    private static final long serialVersionUID = 1L;
    private java.lang.Integer id;
    private java.lang.Integer parentId;
    private List<IndexTreeVO> children;
    private java.lang.String indexName;
    private java.lang.Double indexWeight;
    private java.lang.Integer orderNum;
    private java.lang.Integer stageType;

    public IndexTreeVO() {
        this.orderNum = 0;
        this.parentId = 0;
        this.children = new ArrayList<>();
        this.stageType = 0;
    }

    public IndexTreeVO(NlQuestionnaireIndex index) {
        this.id = index.getId();
        this.parentId = index.getParentId();
        children = new ArrayList<>();
        this.indexName = index.getIndexName();
        this.indexWeight = index.getIndexWeight();
        this.orderNum = index.getOrderNum();
        this.stageType = index.getStageType();
    }

}
