package org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_info.service;

import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_info.entity.NlEmployeeInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_info.vo.EmployeeInfoVO;

/**
 * @Description: 个体特征确认
 * @Author: jeecg-boot
 * @Date:   2024-01-31
 * @Version: V1.0
 */
public interface INlEmployeeInfoService extends IService<NlEmployeeInfo> {


    EmployeeInfoVO getInfoByEmployeeIdWithName(String id);
}
