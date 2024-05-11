package org.jeecg.modules.demo.nl_employee_ability_total.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.modules.demo.nl_employee_ability_total.entity.NlEmployeeAbilityTotalScore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jeecg.modules.demo.nl_employee_ability_total.vo.AbilityTotalVO;

/**
 * @Description: 适岗能力终评
 * @Author: jeecg-boot
 * @Date:   2024-05-11
 * @Version: V1.0
 */
public interface NlEmployeeAbilityTotalScoreMapper extends BaseMapper<NlEmployeeAbilityTotalScore> {

    IPage<AbilityTotalVO> queryWithName(Page<AbilityTotalVO> page);
}
