package org.jeecg.modules.demo.physiology_info.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.physiology_info.entity.NlEmployeePhysiologyInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: 生理状况测评
 * @Author: jeecg-boot
 * @Date:   2024-05-11
 * @Version: V1.0
 */
public interface NlEmployeePhysiologyInfoMapper extends BaseMapper<NlEmployeePhysiologyInfo> {

    NlEmployeePhysiologyInfo getByEmployeeId(String employeeId);
}
