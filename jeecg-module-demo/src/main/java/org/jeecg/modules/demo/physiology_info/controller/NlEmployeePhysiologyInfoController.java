package org.jeecg.modules.demo.physiology_info.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.physiology_info.entity.NlEmployeePhysiologyInfo;
import org.jeecg.modules.demo.physiology_info.service.INlEmployeePhysiologyInfoService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

/**
 * @Description: 生理状况测评
 * @Author: jeecg-boot
 * @Date: 2024-05-11
 * @Version: V1.0
 */
@Api(tags = "生理状况测评")
@RestController
@RequestMapping("/physiology_info/nlEmployeePhysiologyInfo")
@Slf4j
public class NlEmployeePhysiologyInfoController extends JeecgController<NlEmployeePhysiologyInfo, INlEmployeePhysiologyInfoService> {
    @Autowired
    private INlEmployeePhysiologyInfoService nlEmployeePhysiologyInfoService;

    /**
     * 分页列表查询
     *
     * @param nlEmployeePhysiologyInfo
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "生理状况测评-分页列表查询")
    @ApiOperation(value = "生理状况测评-分页列表查询", notes = "生理状况测评-分页列表查询")
    @GetMapping(value = "/list")
    public Result<IPage<NlEmployeePhysiologyInfo>> queryPageList(NlEmployeePhysiologyInfo nlEmployeePhysiologyInfo,
                                                                 @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                                 @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                                 HttpServletRequest req) {
        QueryWrapper<NlEmployeePhysiologyInfo> queryWrapper = QueryGenerator.initQueryWrapper(nlEmployeePhysiologyInfo, req.getParameterMap());
        Page<NlEmployeePhysiologyInfo> page = new Page<NlEmployeePhysiologyInfo>(pageNo, pageSize);
        IPage<NlEmployeePhysiologyInfo> pageList = nlEmployeePhysiologyInfoService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

    /**
     * 添加
     *
     * @param nlEmployeePhysiologyInfo
     * @return
     */
    @AutoLog(value = "生理状况测评-添加")
    @ApiOperation(value = "生理状况测评-添加", notes = "生理状况测评-添加")
    @RequiresPermissions("physiology_info:nl_employee_physiology_info:add")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody NlEmployeePhysiologyInfo nlEmployeePhysiologyInfo) {
        nlEmployeePhysiologyInfoService.save(nlEmployeePhysiologyInfo);
        return Result.OK("添加成功！");
    }

    /**
     * 编辑
     *
     * @param nlEmployeePhysiologyInfo
     * @return
     */
    @AutoLog(value = "生理状况测评-编辑")
    @ApiOperation(value = "生理状况测评-编辑", notes = "生理状况测评-编辑")
    @RequiresPermissions("physiology_info:nl_employee_physiology_info:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody NlEmployeePhysiologyInfo nlEmployeePhysiologyInfo) {
        LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        NlEmployeePhysiologyInfo byEmployeeId = nlEmployeePhysiologyInfoService.getByEmployeeId(loginUser.getId());
        if (byEmployeeId == null) {
            nlEmployeePhysiologyInfo.setEmployeeId(loginUser.getId());
            nlEmployeePhysiologyInfoService.save(nlEmployeePhysiologyInfo);
        } else {
            nlEmployeePhysiologyInfo.setId(byEmployeeId.getId());
            nlEmployeePhysiologyInfoService.updateById(nlEmployeePhysiologyInfo);
        }
//        nlEmployeePhysiologyInfoService.updateById(nlEmployeePhysiologyInfo);
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "生理状况测评-通过id删除")
    @ApiOperation(value = "生理状况测评-通过id删除", notes = "生理状况测评-通过id删除")
    @RequiresPermissions("physiology_info:nl_employee_physiology_info:delete")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
        nlEmployeePhysiologyInfoService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "生理状况测评-批量删除")
    @ApiOperation(value = "生理状况测评-批量删除", notes = "生理状况测评-批量删除")
    @RequiresPermissions("physiology_info:nl_employee_physiology_info:deleteBatch")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.nlEmployeePhysiologyInfoService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "生理状况测评-通过id查询")
    @ApiOperation(value = "生理状况测评-通过id查询", notes = "生理状况测评-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<NlEmployeePhysiologyInfo> queryById(@RequestParam(name = "id", required = true) String id) {
        LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        String employeeId = loginUser.getId();
        NlEmployeePhysiologyInfo nlEmployeePhysiologyInfo = nlEmployeePhysiologyInfoService.getByEmployeeId(employeeId);
        if (nlEmployeePhysiologyInfo == null) {
            nlEmployeePhysiologyInfo.setEmployeeId(id);
            nlEmployeePhysiologyInfoService.save(nlEmployeePhysiologyInfo);

//            return Result.error("未找到对应数据");
        }
        return Result.OK(nlEmployeePhysiologyInfo);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param nlEmployeePhysiologyInfo
     */
    @RequiresPermissions("physiology_info:nl_employee_physiology_info:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, NlEmployeePhysiologyInfo nlEmployeePhysiologyInfo) {
        return super.exportXls(request, nlEmployeePhysiologyInfo, NlEmployeePhysiologyInfo.class, "生理状况测评");
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    @RequiresPermissions("physiology_info:nl_employee_physiology_info:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, NlEmployeePhysiologyInfo.class);
    }

}
