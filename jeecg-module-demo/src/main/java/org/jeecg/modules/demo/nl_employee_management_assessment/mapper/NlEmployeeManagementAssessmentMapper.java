package org.jeecg.modules.demo.nl_employee_management_assessment.mapper;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.nl_employee_management_assessment.entity.NlEmployeeManagementAssessment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jeecg.modules.demo.nl_employee_management_assessment.vo.OrgManagementVO;

/**
 * @Description: 管理沟通能力
 * @Author: jeecg-boot
 * @Date:   2024-05-11
 * @Version: V1.0
 */
public interface NlEmployeeManagementAssessmentMapper extends BaseMapper<NlEmployeeManagementAssessment> {

    IPage<OrgManagementVO> listWithName(Page<OrgManagementVO> page, Map<String, String> params);

    NlEmployeeManagementAssessment getByEmployeeid(String employeeId);
}
