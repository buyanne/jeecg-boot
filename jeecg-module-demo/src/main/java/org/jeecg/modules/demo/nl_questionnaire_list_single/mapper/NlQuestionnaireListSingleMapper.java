package org.jeecg.modules.demo.nl_questionnaire_list_single.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.nl_questionnaire_list_single.entity.NlQuestionnaireListSingle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 问卷表和题库表的中间表
 * @Author: jeecg-boot
 * @Date:   2024-05-02
 * @Version: V1.0
 */
public interface NlQuestionnaireListSingleMapper extends BaseMapper<NlQuestionnaireListSingle> {


    void deleteByListId(Integer listId);
}
