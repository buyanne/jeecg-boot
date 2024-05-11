package org.jeecg.modules.demo.nl_employee_management_assessment.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.nl_employee_management_assessment.entity.NlEmployeeManagementAssessment;
import org.jeecg.modules.demo.nl_employee_management_assessment.service.INlEmployeeManagementAssessmentService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.modules.demo.nl_employee_management_assessment.vo.OrgManagementVO;
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
 * @Description: 管理沟通能力
 * @Author: jeecg-boot
 * @Date: 2024-05-11
 * @Version: V1.0
 */
@Api(tags = "管理沟通能力")
@RestController
@RequestMapping("/nl_employee_management_assessment/nlEmployeeManagementAssessment")
@Slf4j
public class NlEmployeeManagementAssessmentController extends JeecgController<NlEmployeeManagementAssessment, INlEmployeeManagementAssessmentService> {
    @Autowired
    private INlEmployeeManagementAssessmentService nlEmployeeManagementAssessmentService;

    /**
     * 分页列表查询
     *
     * @param nlEmployeeManagementAssessment
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "管理沟通能力-分页列表查询")
    public Result<IPage<NlEmployeeManagementAssessment>> queryPageList(NlEmployeeManagementAssessment nlEmployeeManagementAssessment,
                                                                       @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                                       @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                                       HttpServletRequest req) {
        QueryWrapper<NlEmployeeManagementAssessment> queryWrapper = QueryGenerator.initQueryWrapper(nlEmployeeManagementAssessment, req.getParameterMap());
        Page<NlEmployeeManagementAssessment> page = new Page<NlEmployeeManagementAssessment>(pageNo, pageSize);
        IPage<NlEmployeeManagementAssessment> pageList = nlEmployeeManagementAssessmentService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

    @ApiOperation(value = "管理沟通能力-分页列表查询", notes = "管理沟通能力-分页列表查询")
    @GetMapping(value = "/list")
    public Result<IPage<OrgManagementVO>> queryPageList1(NlEmployeeManagementAssessment nlEmployeeManagementAssessment,
                                                         @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                         @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                         HttpServletRequest req) {

        String employeeName = req.getParameter("employeeName");
        Map<String, String> params = new HashMap<>();

        params.put("employeeName", employeeName);


        IPage<OrgManagementVO> list = this.nlEmployeeManagementAssessmentService.listWithName(pageNo, pageSize, params);

        return Result.ok(list);
    }


    /**
     * 添加
     *
     * @param orgManagementVO
     * @return
     */
    @AutoLog(value = "管理沟通能力-添加")
    @ApiOperation(value = "管理沟通能力-添加", notes = "管理沟通能力-添加")
    @RequiresPermissions("nl_employee_management_assessment:nl_employee_management_assessment:add")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody OrgManagementVO orgManagementVO) {
        NlEmployeeManagementAssessment nlEmployeeManagementAssessment = new NlEmployeeManagementAssessment();
        nlEmployeeManagementAssessment.setEmployeeId(orgManagementVO.getEmployeeId());
        nlEmployeeManagementAssessment.setLeadershipScore(orgManagementVO.getLeadershipScore());
        nlEmployeeManagementAssessment.setCommunicationScore(orgManagementVO.getCommunicationScore());
        nlEmployeeManagementAssessment.setOrgCoordinationScore(orgManagementVO.getOrgCoordinationScore());
        nlEmployeeManagementAssessment.setSpecialistId(orgManagementVO.getSpecialistId());

        nlEmployeeManagementAssessmentService.save(nlEmployeeManagementAssessment);
        return Result.OK("添加成功！");
    }

    /**
     * 编辑
     *
     * @param orgManagementVO
     * @return
     */
    @AutoLog(value = "管理沟通能力-编辑")
    @ApiOperation(value = "管理沟通能力-编辑", notes = "管理沟通能力-编辑")
    @RequiresPermissions("nl_employee_management_assessment:nl_employee_management_assessment:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody OrgManagementVO orgManagementVO) {
        NlEmployeeManagementAssessment nlEmployeeManagementAssessment = new NlEmployeeManagementAssessment();
        nlEmployeeManagementAssessment.setId(orgManagementVO.getId());
        nlEmployeeManagementAssessment.setCommunicationScore(orgManagementVO.getCommunicationScore());
        nlEmployeeManagementAssessment.setLeadershipScore(orgManagementVO.getLeadershipScore());
        nlEmployeeManagementAssessment.setOrgCoordinationScore(orgManagementVO.getOrgCoordinationScore());
        nlEmployeeManagementAssessment.setSpecialistId(orgManagementVO.getSpecialistId());
        nlEmployeeManagementAssessment.setEmployeeId(orgManagementVO.getEmployeeId());
        nlEmployeeManagementAssessmentService.updateById(nlEmployeeManagementAssessment);
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "管理沟通能力-通过id删除")
    @ApiOperation(value = "管理沟通能力-通过id删除", notes = "管理沟通能力-通过id删除")
    @RequiresPermissions("nl_employee_management_assessment:nl_employee_management_assessment:delete")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
        nlEmployeeManagementAssessmentService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "管理沟通能力-批量删除")
    @ApiOperation(value = "管理沟通能力-批量删除", notes = "管理沟通能力-批量删除")
    @RequiresPermissions("nl_employee_management_assessment:nl_employee_management_assessment:deleteBatch")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.nlEmployeeManagementAssessmentService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "管理沟通能力-通过id查询")
    @ApiOperation(value = "管理沟通能力-通过id查询", notes = "管理沟通能力-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<NlEmployeeManagementAssessment> queryById(@RequestParam(name = "id", required = true) String id) {
        NlEmployeeManagementAssessment nlEmployeeManagementAssessment = nlEmployeeManagementAssessmentService.getById(id);
        if (nlEmployeeManagementAssessment == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(nlEmployeeManagementAssessment);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param nlEmployeeManagementAssessment
     */
    @RequiresPermissions("nl_employee_management_assessment:nl_employee_management_assessment:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, NlEmployeeManagementAssessment nlEmployeeManagementAssessment) {
        return super.exportXls(request, nlEmployeeManagementAssessment, NlEmployeeManagementAssessment.class, "管理沟通能力");
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    @RequiresPermissions("nl_employee_management_assessment:nl_employee_management_assessment:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, NlEmployeeManagementAssessment.class);
    }

}
