package org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_interview_info.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_interview_info.entity.NlEmployeeIntviewInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_interview_info.vo.SpecialistInterviewVO;

/**
 * @Description: 专家面试预约
 * @Author: jeecg-boot
 * @Date:   2024-03-27
 * @Version: V1.0
 */
public interface NlEmployeeIntviewInfoMapper extends BaseMapper<NlEmployeeIntviewInfo> {

    Page<SpecialistInterviewVO> listWithName(Page<SpecialistInterviewVO> page);
}
