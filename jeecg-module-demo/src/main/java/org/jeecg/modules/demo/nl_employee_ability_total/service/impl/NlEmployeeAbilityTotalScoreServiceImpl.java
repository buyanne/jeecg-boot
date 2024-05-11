package org.jeecg.modules.demo.nl_employee_ability_total.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.jeecg.modules.demo.nl_employee_ability_total.entity.NlEmployeeAbilityTotalScore;
import org.jeecg.modules.demo.nl_employee_ability_total.mapper.NlEmployeeAbilityTotalScoreMapper;
import org.jeecg.modules.demo.nl_employee_ability_total.service.INlEmployeeAbilityTotalScoreService;
import org.jeecg.modules.demo.nl_employee_ability_total.vo.AbilityTotalVO;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 适岗能力终评
 * @Author: jeecg-boot
 * @Date:   2024-05-11
 * @Version: V1.0
 */
@Service
public class NlEmployeeAbilityTotalScoreServiceImpl extends ServiceImpl<NlEmployeeAbilityTotalScoreMapper, NlEmployeeAbilityTotalScore> implements INlEmployeeAbilityTotalScoreService {

    @Override
    public IPage<AbilityTotalVO> queryWithName(Integer pageNo, Integer pageSize) {
        Page<AbilityTotalVO >page=new Page<>(pageNo,pageSize);
        return this.baseMapper.queryWithName(page);
    }
}
