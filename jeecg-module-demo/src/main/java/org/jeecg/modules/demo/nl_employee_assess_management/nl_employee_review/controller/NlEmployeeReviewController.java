package org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.controller;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_info.service.INlEmployeeInfoService;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_info.vo.EmployeeInfoVO;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_interview_info.entity.NlEmployeeIntviewInfo;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_interview_info.service.INlEmployeeIntviewInfoService;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.entity.NlEmployeeReview;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.mapper.NlEmployeeReviewMapper;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.service.INlEmployeeReviewService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_review.vo.NlReviewVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

/**
 * @Description: 适岗能力初评
 * @Author: jeecg-boot
 * @Date: 2024-02-04
 * @Version: V1.0
 */
@Api(tags = "适岗能力初评")
@RestController
@RequestMapping("/nl_employee_review/nlEmployeeReview")
@Slf4j
public class NlEmployeeReviewController extends JeecgController<NlEmployeeReview, INlEmployeeReviewService> {
    @Autowired
    private INlEmployeeReviewService nlEmployeeReviewService;

    @Autowired
    private INlEmployeeInfoService infoService;
    @Autowired
    private INlEmployeeIntviewInfoService intviewInfoService;

    /**
     * 分页列表查询
     *
     * @param nlEmployeeReview
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "适岗能力初评-分页列表查询")
    @ApiOperation(value = "适岗能力初评-分页列表查询", notes = "适岗能力初评-分页列表查询")
    @GetMapping(value = "/list")
    public Result<IPage<NlReviewVO>> queryPageList(NlEmployeeReview nlEmployeeReview,
                                                   @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                   @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                   HttpServletRequest req) {
        Map<String, Object> params = new HashMap<>();
        params.put("reviewResult", req.getParameter("reviewResult"));
        params.put("realname", req.getParameter("realname"));

        Page<NlReviewVO> pageList = nlEmployeeReviewService.listWithName(pageNo, pageSize, params);
        return Result.ok(pageList);
    }

    /**
     * 添加
     *
     * @param nlEmployeeReview
     * @return
     */
    @AutoLog(value = "适岗能力初评-添加")
    @ApiOperation(value = "适岗能力初评-添加", notes = "适岗能力初评-添加")
    @RequiresPermissions("nl_employee_review:nl_employee_review:add")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody NlEmployeeReview nlEmployeeReview) {
        nlEmployeeReviewService.save(nlEmployeeReview);
        return Result.OK("添加成功！");
    }

    /**
     * 编辑
     *
     * @param employeeInfoVO
     * @return
     */
    @AutoLog(value = "适岗能力初评-编辑")
    @ApiOperation(value = "适岗能力初评-编辑", notes = "适岗能力初评-编辑")
    @RequiresPermissions("nl_employee_review:nl_employee_review:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody EmployeeInfoVO employeeInfoVO) {
//        System.out.println("nihao");
        String employeeId = employeeInfoVO.getEmployeeId();
        EmployeeInfoVO infoByEmployeeId = infoService.getInfoByEmployeeIdWithName(employeeId);
        NlEmployeeReview review = new NlEmployeeReview();
        review.setInfoId(infoByEmployeeId.getId());
        review.setReviewMsg(employeeInfoVO.getHandleOpinions());
        review.setReviewResult(1);
        nlEmployeeReviewService.updateByInfoId(review);
//        review.setInfoId(employeeInfoVO.getEmployeeId())
//        审核通过添加面试信息
        NlEmployeeIntviewInfo intviewInfo = new NlEmployeeIntviewInfo();
        intviewInfo.setEmployeeId(employeeId);
        LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        intviewInfo.setCreateBy(loginUser.getId());
        intviewInfo.setCreateTime(new Date());
        intviewInfoService.save(intviewInfo);
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "适岗能力初评-通过id删除")
    @ApiOperation(value = "适岗能力初评-通过id删除", notes = "适岗能力初评-通过id删除")
    @RequiresPermissions("nl_employee_review:nl_employee_review:delete")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
        nlEmployeeReviewService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "适岗能力初评-批量删除")
    @ApiOperation(value = "适岗能力初评-批量删除", notes = "适岗能力初评-批量删除")
    @RequiresPermissions("nl_employee_review:nl_employee_review:deleteBatch")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.nlEmployeeReviewService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "适岗能力初评-通过id查询")
    @ApiOperation(value = "适岗能力初评-通过id查询", notes = "适岗能力初评-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<NlEmployeeReview> queryById(@RequestParam(name = "id", required = true) String id) {
        NlEmployeeReview nlEmployeeReview = nlEmployeeReviewService.getById(id);
        if (nlEmployeeReview == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(nlEmployeeReview);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param nlEmployeeReview
     */
    @RequiresPermissions("nl_employee_review:nl_employee_review:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, NlEmployeeReview nlEmployeeReview) {
        return super.exportXls(request, nlEmployeeReview, NlEmployeeReview.class, "适岗能力初评");
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    @RequiresPermissions("nl_employee_review:nl_employee_review:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, NlEmployeeReview.class);
    }


}
