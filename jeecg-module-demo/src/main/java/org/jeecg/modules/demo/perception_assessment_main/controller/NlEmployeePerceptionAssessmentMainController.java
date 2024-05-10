package org.jeecg.modules.demo.perception_assessment_main.controller;

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
import org.jeecg.modules.demo.perception_assessment_main.entity.NlEmployeePerceptionAssessmentMain;
import org.jeecg.modules.demo.perception_assessment_main.service.INlEmployeePerceptionAssessmentMainService;

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
 * @Description: 综合感知测评主表
 * @Author: jeecg-boot
 * @Date:   2024-05-10
 * @Version: V1.0
 */
@Api(tags="综合感知测评主表")
@RestController
@RequestMapping("/perception_assessment_main/nlEmployeePerceptionAssessmentMain")
@Slf4j
public class NlEmployeePerceptionAssessmentMainController extends JeecgController<NlEmployeePerceptionAssessmentMain, INlEmployeePerceptionAssessmentMainService> {
	@Autowired
	private INlEmployeePerceptionAssessmentMainService nlEmployeePerceptionAssessmentMainService;
	
	/**
	 * 分页列表查询
	 *
	 * @param nlEmployeePerceptionAssessmentMain
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "综合感知测评主表-分页列表查询")
	@ApiOperation(value="综合感知测评主表-分页列表查询", notes="综合感知测评主表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<NlEmployeePerceptionAssessmentMain>> queryPageList(NlEmployeePerceptionAssessmentMain nlEmployeePerceptionAssessmentMain,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<NlEmployeePerceptionAssessmentMain> queryWrapper = QueryGenerator.initQueryWrapper(nlEmployeePerceptionAssessmentMain, req.getParameterMap());
		Page<NlEmployeePerceptionAssessmentMain> page = new Page<NlEmployeePerceptionAssessmentMain>(pageNo, pageSize);
		IPage<NlEmployeePerceptionAssessmentMain> pageList = nlEmployeePerceptionAssessmentMainService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param nlEmployeePerceptionAssessmentMain
	 * @return
	 */
	@AutoLog(value = "综合感知测评主表-添加")
	@ApiOperation(value="综合感知测评主表-添加", notes="综合感知测评主表-添加")
	@RequiresPermissions("perception_assessment_main:nl_employee_perception_assessment_main:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody NlEmployeePerceptionAssessmentMain nlEmployeePerceptionAssessmentMain) {
		nlEmployeePerceptionAssessmentMainService.save(nlEmployeePerceptionAssessmentMain);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param nlEmployeePerceptionAssessmentMain
	 * @return
	 */
	@AutoLog(value = "综合感知测评主表-编辑")
	@ApiOperation(value="综合感知测评主表-编辑", notes="综合感知测评主表-编辑")
	@RequiresPermissions("perception_assessment_main:nl_employee_perception_assessment_main:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody NlEmployeePerceptionAssessmentMain nlEmployeePerceptionAssessmentMain) {
		nlEmployeePerceptionAssessmentMainService.updateById(nlEmployeePerceptionAssessmentMain);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "综合感知测评主表-通过id删除")
	@ApiOperation(value="综合感知测评主表-通过id删除", notes="综合感知测评主表-通过id删除")
	@RequiresPermissions("perception_assessment_main:nl_employee_perception_assessment_main:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		nlEmployeePerceptionAssessmentMainService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "综合感知测评主表-批量删除")
	@ApiOperation(value="综合感知测评主表-批量删除", notes="综合感知测评主表-批量删除")
	@RequiresPermissions("perception_assessment_main:nl_employee_perception_assessment_main:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.nlEmployeePerceptionAssessmentMainService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "综合感知测评主表-通过id查询")
	@ApiOperation(value="综合感知测评主表-通过id查询", notes="综合感知测评主表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<NlEmployeePerceptionAssessmentMain> queryById(@RequestParam(name="id",required=true) String id) {
		NlEmployeePerceptionAssessmentMain nlEmployeePerceptionAssessmentMain = nlEmployeePerceptionAssessmentMainService.getById(id);
		if(nlEmployeePerceptionAssessmentMain==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(nlEmployeePerceptionAssessmentMain);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param nlEmployeePerceptionAssessmentMain
    */
    @RequiresPermissions("perception_assessment_main:nl_employee_perception_assessment_main:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, NlEmployeePerceptionAssessmentMain nlEmployeePerceptionAssessmentMain) {
        return super.exportXls(request, nlEmployeePerceptionAssessmentMain, NlEmployeePerceptionAssessmentMain.class, "综合感知测评主表");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("perception_assessment_main:nl_employee_perception_assessment_main:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, NlEmployeePerceptionAssessmentMain.class);
    }

}
