package org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_info.entity.NlEmployeeInfo;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.entity.NlEmployeeReview;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.vo.NlReviewVO;

import java.util.Map;

/**
 * @Description: 适岗能力初评
 * @Author: jeecg-boot
 * @Date:   2024-02-04
 * @Version: V1.0
 */
public interface INlEmployeeReviewService extends IService<NlEmployeeReview> {
    Page<NlReviewVO> listWithName(Integer pageNo, Integer pageSize, Map<String, Object> params);

    void updateByInfoId(NlEmployeeReview review);

    NlEmployeeInfo getByInfoId(Integer infoId);
}
