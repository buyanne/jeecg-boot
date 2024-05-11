package org.jeecg.modules.demo.nl_employee_management_assessment.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.jeecg.modules.demo.nl_employee_management_assessment.entity.NlEmployeeManagementAssessment;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.demo.nl_employee_management_assessment.vo.OrgManagementVO;

import java.util.Map;

/**
 * @Description: 管理沟通能力
 * @Author: jeecg-boot
 * @Date:   2024-05-11
 * @Version: V1.0
 */
public interface INlEmployeeManagementAssessmentService extends IService<NlEmployeeManagementAssessment> {

    IPage<OrgManagementVO> listWithName(Integer pageNo, Integer pageSize, Map<String, String> params);

    NlEmployeeManagementAssessment getByEmployeeId(String employeeId);
}
