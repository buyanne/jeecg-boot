package org.jeecg.modules.demo.physiology_info.service;

import org.jeecg.modules.demo.physiology_info.entity.NlEmployeePhysiologyInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: 生理状况测评
 * @Author: jeecg-boot
 * @Date:   2024-05-11
 * @Version: V1.0
 */
public interface INlEmployeePhysiologyInfoService extends IService<NlEmployeePhysiologyInfo> {

    NlEmployeePhysiologyInfo getByEmployeeId(String id);
}
