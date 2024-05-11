package org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_info.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_info.entity.NlEmployeeInfo;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_info.service.INlEmployeeInfoService;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_info.vo.EmployeeInfoVO;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.entity.NlEmployeeReview;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.service.INlEmployeeReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Date;

/**
 * @Description: 个体特征确认
 * @Author: jeecg-boot
 * @Date: 2024-01-31
 * @Version: V1.0
 */
@Api(tags = "个体特征确认")
@RestController
@RequestMapping("/nl_employee_info/nlEmployeeInfo")
@Slf4j
public class NlEmployeeInfoController extends JeecgController<NlEmployeeInfo, INlEmployeeInfoService> {
    @Autowired
    private INlEmployeeInfoService employeeInfoService;

    @Autowired
    private INlEmployeeReviewService reviewService;

    /**
     * 分页列表查询
     *
     * @param nlEmployeeInfo
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "个体特征确认-分页列表查询")
    @ApiOperation(value = "个体特征确认-分页列表查询", notes = "个体特征确认-分页列表查询")
    @GetMapping(value = "/list")
    public Result<IPage<NlEmployeeInfo>> queryPageList(NlEmployeeInfo nlEmployeeInfo, @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize, HttpServletRequest req) {
        QueryWrapper<NlEmployeeInfo> queryWrapper = QueryGenerator.initQueryWrapper(nlEmployeeInfo, req.getParameterMap());
        Page<NlEmployeeInfo> page = new Page<NlEmployeeInfo>(pageNo, pageSize);
        IPage<NlEmployeeInfo> pageList = employeeInfoService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

    /**
     * 添加
     *
     * @param nlEmployeeInfo
     * @return
     */
    @AutoLog(value = "个体特征确认-添加")
    @ApiOperation(value = "个体特征确认-添加", notes = "个体特征确认-添加")
    @RequiresPermissions("nl_employee_info:nl_employee_info:add")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody NlEmployeeInfo nlEmployeeInfo) {
        employeeInfoService.save(nlEmployeeInfo);
        return Result.OK("添加成功！");
    }

    /**
     * 编辑
     *
     * @param info
     * @return
     */
    @AutoLog(value = "个体特征确认-编辑")
    @ApiOperation(value = "个体特征确认-编辑", notes = "个体特征确认-编辑")
    @RequiresPermissions("nl_employee_info:nl_employee_info:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody NlEmployeeInfo info) {

//        NlEmployeeInfo temp = nlEmployeeInfoService.getById(nlEmployeeInfo);
//        if (temp != null) {
//            nlEmployeeInfoService.updateById(nlEmployeeInfo);
//            return Result.ok("编辑成功");
//        } else {
//            LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
//            nlEmployeeInfo.setEmployeeId(loginUser.getId());
//            nlEmployeeInfoService.save(nlEmployeeInfo);
//            return Result.ok("添加成功");
//        }

//        由于前置逻辑，info不会为空
        Integer handleState = info.getHandleState();
//        handleState为0则是正在编辑中，表示暂存
        if (handleState.equals(0)) {
            this.employeeInfoService.updateById(info);
            return Result.ok("暂存成功");
//            为1待审核 表示已经提交
        } else if (handleState.equals(1)) {
            this.employeeInfoService.updateById(info);
            // todo 增加或修改审核信息
            NlEmployeeReview review = new NlEmployeeReview();
            Integer infoId = info.getId();
            review.setInfoId(infoId);
            review.setReviewTime(new Date());
            LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
            review.setReviewBy(loginUser.getId());
            review.setReviewResult(2);
            NlEmployeeInfo byInfoId = this.reviewService.getByInfoId(infoId);
            if (byInfoId == null) {
                this.reviewService.save(review);
            } else {
                this.reviewService.updateByInfoId(review);
            }
            return Result.ok("提交成功");
        }

        return Result.ok();
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "个体特征确认-通过id删除")
    @ApiOperation(value = "个体特征确认-通过id删除", notes = "个体特征确认-通过id删除")
    @RequiresPermissions("nl_employee_info:nl_employee_info:delete")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
        employeeInfoService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "个体特征确认-批量删除")
    @ApiOperation(value = "个体特征确认-批量删除", notes = "个体特征确认-批量删除")
    @RequiresPermissions("nl_employee_info:nl_employee_info:deleteBatch")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.employeeInfoService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }


    /**
     * 导出excel
     *
     * @param request
     * @param nlEmployeeInfo
     */
    @RequiresPermissions("nl_employee_info:nl_employee_info:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, NlEmployeeInfo nlEmployeeInfo) {
        return super.exportXls(request, nlEmployeeInfo, NlEmployeeInfo.class, "个体特征确认");
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    @RequiresPermissions("nl_employee_info:nl_employee_info:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, NlEmployeeInfo.class);
    }

    @AutoLog(value = "个体特征确认-查找当前用户")
    @ApiOperation(value = "个体特征确认-查找当前用户", notes = "个体特征确认-查找当前用户")
    @GetMapping(value = "/queryInfoWithName")
    @Transactional
    public Result<EmployeeInfoVO> queryInfoWithName(NlEmployeeInfo nlEmployeeInfo) {
        LoginUser employee = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        String employeeId = employee.getId();
        EmployeeInfoVO res = this.employeeInfoService.getInfoByEmployeeIdWithName(employeeId);
        if (res == null) {
            NlEmployeeInfo info = new NlEmployeeInfo();
            info.setEmployeeId(employeeId);
            this.employeeInfoService.save(info);
            res = this.employeeInfoService.getInfoByEmployeeIdWithName(employeeId);
        }
        return Result.ok(res);
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    @AutoLog(value = "个体特征确认-通过id查询")
    @ApiOperation(value = "个体特征确认-通过id查询", notes = "个体特征确认-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<EmployeeInfoVO> queryById(@RequestParam(name = "id", required = true) String id) {
        EmployeeInfoVO res = this.employeeInfoService.getInfoByEmployeeIdWithName(id);
        return Result.ok(res);
    }
}
