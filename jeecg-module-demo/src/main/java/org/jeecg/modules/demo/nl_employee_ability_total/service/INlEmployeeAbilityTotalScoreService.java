package org.jeecg.modules.demo.nl_employee_ability_total.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.jeecg.modules.demo.nl_employee_ability_total.entity.NlEmployeeAbilityTotalScore;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.demo.nl_employee_ability_total.vo.AbilityTotalVO;

/**
 * @Description: 适岗能力终评
 * @Author: jeecg-boot
 * @Date:   2024-05-11
 * @Version: V1.0
 */
public interface INlEmployeeAbilityTotalScoreService extends IService<NlEmployeeAbilityTotalScore> {

    IPage<AbilityTotalVO> queryWithName(Integer pageNo, Integer pageSize);
}
