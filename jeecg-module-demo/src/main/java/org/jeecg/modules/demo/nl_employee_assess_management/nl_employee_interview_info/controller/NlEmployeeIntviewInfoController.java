package org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_interview_info.controller;

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
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_interview_info.entity.NlEmployeeIntviewInfo;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_interview_info.service.INlEmployeeIntviewInfoService;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_interview_info.vo.SpecialistInterviewVO;
import org.jeecg.modules.demo.nl_employee_management_assessment.entity.NlEmployeeManagementAssessment;
import org.jeecg.modules.demo.nl_employee_management_assessment.service.INlEmployeeManagementAssessmentService;
import org.jeecg.modules.demo.specialist.entity.NlSpecialistInfo;
import org.jeecg.modules.demo.specialist.service.INlSpecialistInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 专家面试预约
 * @Author: jeecg-boot
 * @Date: 2024-03-27
 * @Version: V1.0
 */
@Api(tags = "专家面试预约")
@RestController
@RequestMapping("/nl_employee_assess_management/nl_employee_interview_info/nlEmployeeIntviewInfo")
@Slf4j
public class NlEmployeeIntviewInfoController extends JeecgController<NlEmployeeIntviewInfo, INlEmployeeIntviewInfoService> {
    @Autowired
    private INlEmployeeIntviewInfoService nlEmployeeIntviewInfoService;


    @Autowired
    private INlEmployeeManagementAssessmentService employeeManagementAssessmentService;


    @Autowired
    private INlSpecialistInfoService specialistInfoService;

    /**
     * 分页列表查询
     *
     * @param nlEmployeeIntviewInfo
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "专家面试预约-分页列表查询")
    @ApiOperation(value = "专家面试预约-分页列表查询", notes = "专家面试预约-分页列表查询")
    @GetMapping(value = "/list")
    public Result<IPage<NlEmployeeIntviewInfo>> queryPageList(NlEmployeeIntviewInfo nlEmployeeIntviewInfo,
                                                              @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                              @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                              HttpServletRequest req) {
        QueryWrapper<NlEmployeeIntviewInfo> queryWrapper = QueryGenerator.initQueryWrapper(nlEmployeeIntviewInfo, req.getParameterMap());
        Page<NlEmployeeIntviewInfo> page = new Page<NlEmployeeIntviewInfo>(pageNo, pageSize);
        IPage<NlEmployeeIntviewInfo> pageList = nlEmployeeIntviewInfoService.page(page, queryWrapper);
        queryPageListWithName(nlEmployeeIntviewInfo, pageNo, pageSize, req);
        return Result.OK(pageList);
    }

    @GetMapping(value = "/listWithName")
    public Result<IPage<SpecialistInterviewVO>> queryPageListWithName(NlEmployeeIntviewInfo nlEmployeeIntviewInfo,
                                                                      @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                                      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                                      HttpServletRequest req) {
        Page<SpecialistInterviewVO> page = new Page<>(pageNo, pageSize);
        IPage<SpecialistInterviewVO> pageList = nlEmployeeIntviewInfoService.listWithName(page);

        List<SpecialistInterviewVO> records = pageList.getRecords();
        List<NlSpecialistInfo> specialistInfoList = specialistInfoService.list();
        for (SpecialistInterviewVO record : records) {
            if (record.getSpecialistId() != null) {
                for (NlSpecialistInfo nlSpecialistInfo : specialistInfoList) {
                    if (record.getSpecialistId().equals(nlSpecialistInfo.getId())) {
                        record.setSpecialistName(nlSpecialistInfo.getName());
                        break;
                    }
                }
            }
        }
        pageList.setRecords(records);

        return Result.ok(pageList);
    }

    /**
     * 添加
     *
     * @param nlEmployeeIntviewInfo
     * @return
     */
    @AutoLog(value = "专家面试预约-添加")
    @ApiOperation(value = "专家面试预约-添加", notes = "专家面试预约-添加")
    @RequiresPermissions("nl_employee_assess_management/nl_employee_interview_info:nl_employee_intview_info:add")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody NlEmployeeIntviewInfo nlEmployeeIntviewInfo) {
        nlEmployeeIntviewInfoService.save(nlEmployeeIntviewInfo);
        return Result.OK("添加成功！");
    }

    /**
     * 编辑
     *
     * @param nlEmployeeIntviewInfo
     * @return
     */
    @AutoLog(value = "专家面试预约-编辑")
    @ApiOperation(value = "专家面试预约-编辑", notes = "专家面试预约-编辑")
    @RequiresPermissions("nl_employee_assess_management/nl_employee_interview_info:nl_employee_intview_info:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody NlEmployeeIntviewInfo nlEmployeeIntviewInfo) {
        nlEmployeeIntviewInfoService.updateById(nlEmployeeIntviewInfo);
        String employeeId = nlEmployeeIntviewInfo.getEmployeeId();
        Integer specialistId = nlEmployeeIntviewInfo.getSpecialistId();
        NlEmployeeManagementAssessment byEmployeeId = employeeManagementAssessmentService.getByEmployeeId(employeeId);
        if (byEmployeeId == null) {
            NlEmployeeManagementAssessment nlEmployeeManagementAssessment = new NlEmployeeManagementAssessment();
            nlEmployeeManagementAssessment.setEmployeeId(employeeId);
            nlEmployeeManagementAssessment.setSpecialistId(String.valueOf(specialistId));
            employeeManagementAssessmentService.save(nlEmployeeManagementAssessment);

        } else {
            byEmployeeId.setSpecialistId(String.valueOf(specialistId));
            employeeManagementAssessmentService.updateById(byEmployeeId);
        }
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "专家面试预约-通过id删除")
    @ApiOperation(value = "专家面试预约-通过id删除", notes = "专家面试预约-通过id删除")
    @RequiresPermissions("nl_employee_assess_management/nl_employee_interview_info:nl_employee_intview_info:delete")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
        nlEmployeeIntviewInfoService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "专家面试预约-批量删除")
    @ApiOperation(value = "专家面试预约-批量删除", notes = "专家面试预约-批量删除")
    @RequiresPermissions("nl_employee_assess_management/nl_employee_interview_info:nl_employee_intview_info:deleteBatch")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.nlEmployeeIntviewInfoService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "专家面试预约-通过id查询")
    @ApiOperation(value = "专家面试预约-通过id查询", notes = "专家面试预约-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<NlEmployeeIntviewInfo> queryById(@RequestParam(name = "id", required = true) String id) {
        NlEmployeeIntviewInfo nlEmployeeIntviewInfo = nlEmployeeIntviewInfoService.getById(id);
        if (nlEmployeeIntviewInfo == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(nlEmployeeIntviewInfo);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param nlEmployeeIntviewInfo
     */
    @RequiresPermissions("nl_employee_assess_management/nl_employee_interview_info:nl_employee_intview_info:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, NlEmployeeIntviewInfo nlEmployeeIntviewInfo) {
        return super.exportXls(request, nlEmployeeIntviewInfo, NlEmployeeIntviewInfo.class, "专家面试预约");
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    @RequiresPermissions("nl_employee_assess_management/nl_employee_interview_info:nl_employee_intview_info:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, NlEmployeeIntviewInfo.class);
    }

}
