package org.jeecg.modules.demo.nl_employee_assess_management.nl_assess_plan.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_assess_plan.entity.NlEmployeeAssessPlan;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_assess_plan.service.INlEmployeeAssessPlanService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

/**
 * @Description: 测评计划管理
 * @Author: jeecg-boot
 * @Date: 2024-01-31
 * @Version: V1.0
 */
@Api(tags = "测评计划管理")
@RestController
@RequestMapping("/nl_assess_plan/nlEmployeeAssessPlan")
@Slf4j
public class NlEmployeeAssessPlanController extends JeecgController<NlEmployeeAssessPlan, INlEmployeeAssessPlanService> {
    @Autowired
    private INlEmployeeAssessPlanService nlEmployeeAssessPlanService;

    /**
     * 分页列表查询
     *
     * @param nlEmployeeAssessPlan
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "测评计划管理-分页列表查询")
    @ApiOperation(value = "测评计划管理-分页列表查询", notes = "测评计划管理-分页列表查询")
    @GetMapping(value = "/list")
    public Result<IPage<NlEmployeeAssessPlan>> queryPageList(NlEmployeeAssessPlan nlEmployeeAssessPlan,
                                                             @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                             @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                             HttpServletRequest req) {
        QueryWrapper<NlEmployeeAssessPlan> queryWrapper = QueryGenerator.initQueryWrapper(nlEmployeeAssessPlan, req.getParameterMap());
        Page<NlEmployeeAssessPlan> page = new Page<NlEmployeeAssessPlan>(pageNo, pageSize);
        IPage<NlEmployeeAssessPlan> pageList = nlEmployeeAssessPlanService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

    /**
     * 添加
     *
     * @param nlEmployeeAssessPlan
     * @return
     */
    @AutoLog(value = "测评计划管理-添加")
    @ApiOperation(value = "测评计划管理-添加", notes = "测评计划管理-添加")
    @RequiresPermissions("nl_assess_plan:nl_employee_assess_plan:add")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody NlEmployeeAssessPlan nlEmployeeAssessPlan) {
        nlEmployeeAssessPlan.setPlanRelease(0);
        nlEmployeeAssessPlanService.save(nlEmployeeAssessPlan);
        return Result.OK("添加成功！");
    }

    /**
     * 编辑
     *
     * @param nlEmployeeAssessPlan
     * @return
     */
    @AutoLog(value = "测评计划管理-编辑")
    @ApiOperation(value = "测评计划管理-编辑", notes = "测评计划管理-编辑")
    @RequiresPermissions("nl_assess_plan:nl_employee_assess_plan:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody NlEmployeeAssessPlan nlEmployeeAssessPlan) {
        nlEmployeeAssessPlanService.updateById(nlEmployeeAssessPlan);
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "测评计划管理-通过id删除")
    @ApiOperation(value = "测评计划管理-通过id删除", notes = "测评计划管理-通过id删除")
    @RequiresPermissions("nl_assess_plan:nl_employee_assess_plan:delete")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
        nlEmployeeAssessPlanService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "测评计划管理-批量删除")
    @ApiOperation(value = "测评计划管理-批量删除", notes = "测评计划管理-批量删除")
    @RequiresPermissions("nl_assess_plan:nl_employee_assess_plan:deleteBatch")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.nlEmployeeAssessPlanService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "测评计划管理-通过id查询")
    @ApiOperation(value = "测评计划管理-通过id查询", notes = "测评计划管理-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<NlEmployeeAssessPlan> queryById(@RequestParam(name = "id", required = true) String id) {
        NlEmployeeAssessPlan nlEmployeeAssessPlan = nlEmployeeAssessPlanService.getById(id);
        if (nlEmployeeAssessPlan == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(nlEmployeeAssessPlan);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param nlEmployeeAssessPlan
     */
    @RequiresPermissions("nl_assess_plan:nl_employee_assess_plan:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, NlEmployeeAssessPlan nlEmployeeAssessPlan) {
        return super.exportXls(request, nlEmployeeAssessPlan, NlEmployeeAssessPlan.class, "测评计划管理");
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    @RequiresPermissions("nl_assess_plan:nl_employee_assess_plan:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, NlEmployeeAssessPlan.class);
    }
    @AutoLog(value = "测评计划管理-通过id发布")
    @ApiOperation(value = "测评计划管理-通过id发布", notes = "测评计划管理-通过id发布")
    @RequestMapping(value = "/doReleaseData", method = RequestMethod.GET)
    public Result<NlEmployeeAssessPlan> doReleaseData(@RequestParam(name = "id", required = true) String id, HttpServletRequest request) {
        Result<NlEmployeeAssessPlan> result = new Result<>();
        NlEmployeeAssessPlan nlEmployeeAssessPlan = nlEmployeeAssessPlanService.getById(id);
        if (nlEmployeeAssessPlan == null) {
            result.error500("未找到对应实体");
        } else {
            nlEmployeeAssessPlan.setPlanRelease(1);
            boolean ok = nlEmployeeAssessPlanService.updateById(nlEmployeeAssessPlan);
            if (ok) {
                result.success("发布成功");
            }
        }

        return result;
    }

    @AutoLog(value = "测评计划管理-通过id撤销")
    @ApiOperation(value = "测评计划管理-通过id撤销", notes = "测评计划管理-通过id撤销")
    @RequestMapping(value = "/doRevokeData", method = RequestMethod.GET)
    public Result<NlEmployeeAssessPlan> doRevokeData(@RequestParam(name = "id", required = true) String id, HttpServletRequest request) {
        Result<NlEmployeeAssessPlan> result = new Result<>();
        NlEmployeeAssessPlan nlEmployeeAssessPlan = nlEmployeeAssessPlanService.getById(id);
        if (nlEmployeeAssessPlan == null) {
            result.error500("未找到对应实体");
        } else {
            nlEmployeeAssessPlan.setPlanRelease(0);
            boolean ok = nlEmployeeAssessPlanService.updateById(nlEmployeeAssessPlan);
            if (ok) {
                result.success("撤销成功");
            }
        }
        return result;
    }
}


