package org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_interview_info.controller;

import java.util.Arrays;
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
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_interview_info.entity.NlEmployeeIntviewInfo;
import org.jeecg.modules.demo.nl_employee_assess_management.nl_employee_interview_info.service.INlEmployeeIntviewInfoService;

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
 * @Description: 专家面试预约
 * @Author: jeecg-boot
 * @Date:   2024-03-27
 * @Version: V1.0
 */
@Api(tags="专家面试预约")
@RestController
@RequestMapping("/nl_employee_assess_management/nl_employee_interview_info/nlEmployeeIntviewInfo")
@Slf4j
public class NlEmployeeIntviewInfoController extends JeecgController<NlEmployeeIntviewInfo, INlEmployeeIntviewInfoService> {
	@Autowired
	private INlEmployeeIntviewInfoService nlEmployeeIntviewInfoService;
	
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
	@ApiOperation(value="专家面试预约-分页列表查询", notes="专家面试预约-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<NlEmployeeIntviewInfo>> queryPageList(NlEmployeeIntviewInfo nlEmployeeIntviewInfo,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<NlEmployeeIntviewInfo> queryWrapper = QueryGenerator.initQueryWrapper(nlEmployeeIntviewInfo, req.getParameterMap());
		Page<NlEmployeeIntviewInfo> page = new Page<NlEmployeeIntviewInfo>(pageNo, pageSize);
		IPage<NlEmployeeIntviewInfo> pageList = nlEmployeeIntviewInfoService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param nlEmployeeIntviewInfo
	 * @return
	 */
	@AutoLog(value = "专家面试预约-添加")
	@ApiOperation(value="专家面试预约-添加", notes="专家面试预约-添加")
	@RequiresPermissions("nl_employee_assess_management/nl_employee_interview_info:nl_employee_intview_info:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody NlEmployeeIntviewInfo nlEmployeeIntviewInfo) {
		nlEmployeeIntviewInfoService.save(nlEmployeeIntviewInfo);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param nlEmployeeIntviewInfo
	 * @return
	 */
	@AutoLog(value = "专家面试预约-编辑")
	@ApiOperation(value="专家面试预约-编辑", notes="专家面试预约-编辑")
	@RequiresPermissions("nl_employee_assess_management/nl_employee_interview_info:nl_employee_intview_info:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody NlEmployeeIntviewInfo nlEmployeeIntviewInfo) {
		nlEmployeeIntviewInfoService.updateById(nlEmployeeIntviewInfo);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "专家面试预约-通过id删除")
	@ApiOperation(value="专家面试预约-通过id删除", notes="专家面试预约-通过id删除")
	@RequiresPermissions("nl_employee_assess_management/nl_employee_interview_info:nl_employee_intview_info:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		nlEmployeeIntviewInfoService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "专家面试预约-批量删除")
	@ApiOperation(value="专家面试预约-批量删除", notes="专家面试预约-批量删除")
	@RequiresPermissions("nl_employee_assess_management/nl_employee_interview_info:nl_employee_intview_info:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
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
	@ApiOperation(value="专家面试预约-通过id查询", notes="专家面试预约-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<NlEmployeeIntviewInfo> queryById(@RequestParam(name="id",required=true) String id) {
		NlEmployeeIntviewInfo nlEmployeeIntviewInfo = nlEmployeeIntviewInfoService.getById(id);
		if(nlEmployeeIntviewInfo==null) {
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
