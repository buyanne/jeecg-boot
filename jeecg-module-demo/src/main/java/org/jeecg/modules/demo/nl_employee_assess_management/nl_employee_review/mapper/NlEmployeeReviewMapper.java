package org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Select;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.entity.NlEmployeeReview;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.vo.NlReviewVO;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
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
}
