package org.jeecg.modules.demo.nl_employee_ability_total.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.demo.nl_employee_ability_total.entity.NlEmployeeAbilityTotalScore;
import org.jeecg.modules.demo.nl_employee_ability_total.service.INlEmployeeAbilityTotalScoreService;
import org.jeecg.modules.demo.nl_employee_ability_total.vo.AbilityTotalVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * @Description: 适岗能力终评
 * @Author: jeecg-boot
 * @Date: 2024-05-11
 * @Version: V1.0
 */
@Api(tags = "适岗能力终评")
@RestController
@RequestMapping("/nl_employee_ability_total/nlEmployeeAbilityTotalScore")
@Slf4j
public class NlEmployeeAbilityTotalScoreController extends JeecgController<NlEmployeeAbilityTotalScore, INlEmployeeAbilityTotalScoreService> {
    @Autowired
    private INlEmployeeAbilityTotalScoreService nlEmployeeAbilityTotalScoreService;

    /**
     * 分页列表查询
     *
     * @param nlEmployeeAbilityTotalScore
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "适岗能力终评-分页列表查询")
    @ApiOperation(value = "适岗能力终评-分页列表查询", notes = "适岗能力终评-分页列表查询")
    @GetMapping(value = "/list")
    public Result<IPage<AbilityTotalVO>> queryPageList(NlEmployeeAbilityTotalScore nlEmployeeAbilityTotalScore,
                                                       @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                       @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                       HttpServletRequest req) {


        IPage<AbilityTotalVO> pageList = this.nlEmployeeAbilityTotalScoreService.queryWithName(pageNo, pageSize);
        return Result.OK(pageList);
    }

    /**
     * 添加
     *
     * @param nlEmployeeAbilityTotalScore
     * @return
     */
    @AutoLog(value = "适岗能力终评-添加")
    @ApiOperation(value = "适岗能力终评-添加", notes = "适岗能力终评-添加")
    @RequiresPermissions("nl_employee_ability_total:nl_employee_ability_total_score:add")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody NlEmployeeAbilityTotalScore nlEmployeeAbilityTotalScore) {
        nlEmployeeAbilityTotalScoreService.save(nlEmployeeAbilityTotalScore);
        return Result.OK("添加成功！");
    }

    /**
     * 编辑
     *
     * @param nlEmployeeAbilityTotalScore
     * @return
     */
    @AutoLog(value = "适岗能力终评-编辑")
    @ApiOperation(value = "适岗能力终评-编辑", notes = "适岗能力终评-编辑")
    @RequiresPermissions("nl_employee_ability_total:nl_employee_ability_total_score:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody NlEmployeeAbilityTotalScore nlEmployeeAbilityTotalScore) {
        nlEmployeeAbilityTotalScoreService.updateById(nlEmployeeAbilityTotalScore);
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "适岗能力终评-通过id删除")
    @ApiOperation(value = "适岗能力终评-通过id删除", notes = "适岗能力终评-通过id删除")
    @RequiresPermissions("nl_employee_ability_total:nl_employee_ability_total_score:delete")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
        nlEmployeeAbilityTotalScoreService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "适岗能力终评-批量删除")
    @ApiOperation(value = "适岗能力终评-批量删除", notes = "适岗能力终评-批量删除")
    @RequiresPermissions("nl_employee_ability_total:nl_employee_ability_total_score:deleteBatch")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.nlEmployeeAbilityTotalScoreService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "适岗能力终评-通过id查询")
    @ApiOperation(value = "适岗能力终评-通过id查询", notes = "适岗能力终评-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<NlEmployeeAbilityTotalScore> queryById(@RequestParam(name = "id", required = true) String id) {
        NlEmployeeAbilityTotalScore nlEmployeeAbilityTotalScore = nlEmployeeAbilityTotalScoreService.getById(id);
        if (nlEmployeeAbilityTotalScore == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(nlEmployeeAbilityTotalScore);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param nlEmployeeAbilityTotalScore
     */
    @RequiresPermissions("nl_employee_ability_total:nl_employee_ability_total_score:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, NlEmployeeAbilityTotalScore nlEmployeeAbilityTotalScore) {
        return super.exportXls(request, nlEmployeeAbilityTotalScore, NlEmployeeAbilityTotalScore.class, "适岗能力终评");
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    @RequiresPermissions("nl_employee_ability_total:nl_employee_ability_total_score:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, NlEmployeeAbilityTotalScore.class);
    }

}
