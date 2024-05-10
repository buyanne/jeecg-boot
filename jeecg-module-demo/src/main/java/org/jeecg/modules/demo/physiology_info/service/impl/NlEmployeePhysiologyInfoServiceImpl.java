package org.jeecg.modules.demo.physiology_info.service.impl;

import org.jeecg.modules.demo.physiology_info.entity.NlEmployeePhysiologyInfo;
import org.jeecg.modules.demo.physiology_info.mapper.NlEmployeePhysiologyInfoMapper;
import org.jeecg.modules.demo.physiology_info.service.INlEmployeePhysiologyInfoService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 生理状况测评
 * @Author: jeecg-boot
 * @Date:   2024-05-11
 * @Version: V1.0
 */
@Service
public class NlEmployeePhysiologyInfoServiceImpl extends ServiceImpl<NlEmployeePhysiologyInfoMapper, NlEmployeePhysiologyInfo> implements INlEmployeePhysiologyInfoService {

    @Override
    public NlEmployeePhysiologyInfo getByEmployeeId(String employeeId) {
        return  this.baseMapper.getByEmployeeId(employeeId);
    }
}
