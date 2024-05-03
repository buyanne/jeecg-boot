package org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.entity.NlEmployeeReview;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.vo.NlReviewVO;

import java.util.List;
import java.util.Map;

/**
 * @Description: 适岗能力初评
 * @Author: jeecg-boot
 * @Date:   2024-02-04
 * @Version: V1.0
 */
public interface INlEmployeeReviewService extends IService<NlEmployeeReview> {
    Page<NlReviewVO> listWithName(Integer pageNo, Integer pageSize, Map<String, Object> params);
}
