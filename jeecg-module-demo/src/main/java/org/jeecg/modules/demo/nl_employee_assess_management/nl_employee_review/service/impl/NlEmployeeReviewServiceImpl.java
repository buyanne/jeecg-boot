package org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_info.entity.NlEmployeeInfo;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.entity.NlEmployeeReview;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.mapper.NlEmployeeReviewMapper;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.service.INlEmployeeReviewService;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.vo.NlReviewVO;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTNumLvl;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;
import java.util.Map;

/**
 * @Description: 适岗能力初评
 * @Author: jeecg-boot
 * @Date: 2024-02-04
 * @Version: V1.0
 */
@Service
public class NlEmployeeReviewServiceImpl extends ServiceImpl<NlEmployeeReviewMapper, NlEmployeeReview> implements INlEmployeeReviewService {
    @Override
    public Page<NlReviewVO> listWithName(Integer pageNo, Integer pageSize, Map<String, Object> params) {
        Page<NlReviewVO> page = new Page<>(pageNo, pageSize);
        Page<NlReviewVO> res = baseMapper.getEmployeeReviewWithName(page, params);
        return res;
    }

    @Override
    public void updateByInfoId(NlEmployeeReview review) {
        this.baseMapper.updateByInfoId(review);
    }

    @Override
    public NlEmployeeInfo getByInfoId(Integer infoId) {
        return this.baseMapper.getByInfoId(infoId);
    }

}
