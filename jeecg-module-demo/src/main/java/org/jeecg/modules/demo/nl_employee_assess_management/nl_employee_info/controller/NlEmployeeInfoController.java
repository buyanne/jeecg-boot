package org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_info.controller;

import java.lang.reflect.Field;
import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mchange.v2.lang.SystemUtils;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.api.vo.SysUserEmployeeInfo;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_info.service.INlEmployeeInfoService;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_info.entity.NlEmployeeInfo;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.common.system.base.controller.JeecgController;
import org.jetbrains.annotations.TestOnly;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

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
    private INlEmployeeInfoService nlEmployeeInfoService;

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
    public Result<IPage<NlEmployeeInfo>> queryPageList(NlEmployeeInfo nlEmployeeInfo,
                                                       @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                       @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                       HttpServletRequest req) {
        QueryWrapper<NlEmployeeInfo> queryWrapper = QueryGenerator.initQueryWrapper(nlEmployeeInfo, req.getParameterMap());
        Page<NlEmployeeInfo> page = new Page<NlEmployeeInfo>(pageNo, pageSize);
        IPage<NlEmployeeInfo> pageList = nlEmployeeInfoService.page(page, queryWrapper);
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
        nlEmployeeInfoService.save(nlEmployeeInfo);
        return Result.OK("添加成功！");
    }

    /**
     * 编辑
     *
     * @param nlEmployeeInfo
     * @return
     */
    @AutoLog(value = "个体特征确认-编辑")
    @ApiOperation(value = "个体特征确认-编辑", notes = "个体特征确认-编辑")
    @RequiresPermissions("nl_employee_info:nl_employee_info:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody NlEmployeeInfo nlEmployeeInfo) {

        NlEmployeeInfo temp=nlEmployeeInfoService.getOne(new QueryWrapper<>(nlEmployeeInfo));
        if(temp!=null){
            nlEmployeeInfoService.updateById(nlEmployeeInfo);
            return Result.ok("编辑成功");
        }else{
            LoginUser loginUser= (LoginUser) SecurityUtils.getSubject().getPrincipal();
            nlEmployeeInfo.setEmployeeId(loginUser.getId());
            nlEmployeeInfoService.save(nlEmployeeInfo);
            return Result.ok("添加成功");
        }

        //        LoginUser loginUser= (LoginUser) SecurityUtils.getSubject().getPrincipal();
//        NlEmployeeInfo temp=new NlEmployeeInfo();
//        temp.setEmployeeId(loginUser.getId());
//        if(nlEmployeeInfoService.getOne(new QueryWrapper<>(temp))!=null){
//            nlEmployeeInfoService.updateById(nlEmployeeInfo);
//            return Result.ok("修改成功");
//        }else{
//            nlEmployeeInfo.setEmployeeId(loginUser.getId());
//            nlEmployeeInfoService.save(nlEmployeeInfo);
//            return Result.ok("添加成功");
//        }

//        nlEmployeeInfoService.updateById(nlEmployeeInfo);
//        return Result.OK("编辑成功!");
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
        nlEmployeeInfoService.removeById(id);
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
        this.nlEmployeeInfoService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
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
    public Result<NlEmployeeInfo> queryById(@RequestParam(name = "id", required = true) String id) {
        NlEmployeeInfo nlEmployeeInfo = nlEmployeeInfoService.getById(id);
        if (nlEmployeeInfo == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(nlEmployeeInfo);
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
    @GetMapping(value = "/querySysUserInfo")
    public Result<NlEmployeeInfo> getSysUserEmployeeInfo(NlEmployeeInfo nlEmployeeInfo) {
        LoginUser loginUser= (LoginUser) SecurityUtils.getSubject().getPrincipal();
        nlEmployeeInfo=nlEmployeeInfoService.getOne(new QueryWrapper<>(new NlEmployeeInfo().setEmployeeId(loginUser.getId())));
        return Result.ok(nlEmployeeInfo);
    }
}
