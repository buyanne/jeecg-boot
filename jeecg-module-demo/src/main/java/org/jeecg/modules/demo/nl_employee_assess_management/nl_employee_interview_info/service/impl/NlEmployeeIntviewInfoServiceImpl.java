package org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_interview_info.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_interview_info.entity.NlEmployeeIntviewInfo;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_interview_info.mapper.NlEmployeeIntviewInfoMapper;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_interview_info.service.INlEmployeeIntviewInfoService;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_interview_info.vo.SpecialistInterviewVO;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 专家面试预约
 * @Author: jeecg-boot
 * @Date:   2024-03-27
 * @Version: V1.0
 */
@Service
public class NlEmployeeIntviewInfoServiceImpl extends ServiceImpl<NlEmployeeIntviewInfoMapper, NlEmployeeIntviewInfo> implements INlEmployeeIntviewInfoService {

    @Override
    public IPage<SpecialistInterviewVO> listWithName(Page<SpecialistInterviewVO> page) {
        return baseMapper.listWithName(page);
    }
}
