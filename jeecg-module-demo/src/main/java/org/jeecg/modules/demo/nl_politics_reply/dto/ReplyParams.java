package org.jeecg.modules.demo.nl_politics_reply.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReplyParams {
    private Integer listId;
    private List<SelectedChoice> questionList;
}
