package org.jeecg.modules.demo.nl_employee_management_assessment.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.modules.demo.nl_employee_management_assessment.entity.NlEmployeeManagementAssessment;
import org.jeecg.modules.demo.nl_employee_management_assessment.mapper.NlEmployeeManagementAssessmentMapper;
import org.jeecg.modules.demo.nl_employee_management_assessment.service.INlEmployeeManagementAssessmentService;
import org.jeecg.modules.demo.nl_employee_management_assessment.vo.OrgManagementVO;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Map;

/**
 * @Description: 管理沟通能力
 * @Author: jeecg-boot
 * @Date: 2024-05-11
 * @Version: V1.0
 */
@Service
public class NlEmployeeManagementAssessmentServiceImpl extends ServiceImpl<NlEmployeeManagementAssessmentMapper, NlEmployeeManagementAssessment> implements INlEmployeeManagementAssessmentService {

    @Override
    public IPage<OrgManagementVO> listWithName(Integer pageNo, Integer pageSize, Map<String, String> params) {
        Page<OrgManagementVO> page = new Page<>(pageNo, pageSize);
        return this.baseMapper.listWithName(page, params);
    }

    @Override
    public NlEmployeeManagementAssessment getByEmployeeId(String employeeId) {
        return this.baseMapper.getByEmployeeid(employeeId);
    }
}
