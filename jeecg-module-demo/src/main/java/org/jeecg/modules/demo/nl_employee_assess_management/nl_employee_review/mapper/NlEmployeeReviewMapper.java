package org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_info.entity.NlEmployeeInfo;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.entity.NlEmployeeReview;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.vo.NlReviewVO;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * @Description: 适岗能力初评
 * @Author: jeecg-boot
 * @Date:   2024-02-04
 * @Version: V1.0
 */
@Repository
public interface NlEmployeeReviewMapper extends BaseMapper<NlEmployeeReview> {
    Page<NlReviewVO> getEmployeeReviewWithName(Page<NlReviewVO> page, Map<String,Object> params);

    void updateByInfoId(NlEmployeeReview review);

    NlEmployeeInfo getByInfoId(Integer infoId);
}
