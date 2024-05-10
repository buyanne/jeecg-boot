package org.jeecg.modules.demo.politics_single_score.controller;

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
import org.jeecg.modules.demo.politics_single_score.entity.NlEmployeePoliticsSingleScore;
import org.jeecg.modules.demo.politics_single_score.service.INlEmployeePoliticsSingleScoreService;

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
 * @Description: 思想状况问卷得分情况
 * @Author: jeecg-boot
 * @Date:   2024-05-10
 * @Version: V1.0
 */
@Api(tags="思想状况问卷得分情况")
@RestController
@RequestMapping("/politics_single_score/nlEmployeePoliticsSingleScore")
@Slf4j
public class NlEmployeePoliticsSingleScoreController extends JeecgController<NlEmployeePoliticsSingleScore, INlEmployeePoliticsSingleScoreService> {
	@Autowired
	private INlEmployeePoliticsSingleScoreService nlEmployeePoliticsSingleScoreService;
	
	/**
	 * 分页列表查询
	 *
	 * @param nlEmployeePoliticsSingleScore
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "思想状况问卷得分情况-分页列表查询")
	@ApiOperation(value="思想状况问卷得分情况-分页列表查询", notes="思想状况问卷得分情况-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<NlEmployeePoliticsSingleScore>> queryPageList(NlEmployeePoliticsSingleScore nlEmployeePoliticsSingleScore,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<NlEmployeePoliticsSingleScore> queryWrapper = QueryGenerator.initQueryWrapper(nlEmployeePoliticsSingleScore, req.getParameterMap());
		Page<NlEmployeePoliticsSingleScore> page = new Page<NlEmployeePoliticsSingleScore>(pageNo, pageSize);
		IPage<NlEmployeePoliticsSingleScore> pageList = nlEmployeePoliticsSingleScoreService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param nlEmployeePoliticsSingleScore
	 * @return
	 */
	@AutoLog(value = "思想状况问卷得分情况-添加")
	@ApiOperation(value="思想状况问卷得分情况-添加", notes="思想状况问卷得分情况-添加")
	@RequiresPermissions("politics_single_score:nl_employee_politics_single_score:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody NlEmployeePoliticsSingleScore nlEmployeePoliticsSingleScore) {
		nlEmployeePoliticsSingleScoreService.save(nlEmployeePoliticsSingleScore);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param nlEmployeePoliticsSingleScore
	 * @return
	 */
	@AutoLog(value = "思想状况问卷得分情况-编辑")
	@ApiOperation(value="思想状况问卷得分情况-编辑", notes="思想状况问卷得分情况-编辑")
	@RequiresPermissions("politics_single_score:nl_employee_politics_single_score:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody NlEmployeePoliticsSingleScore nlEmployeePoliticsSingleScore) {
		nlEmployeePoliticsSingleScoreService.updateById(nlEmployeePoliticsSingleScore);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "思想状况问卷得分情况-通过id删除")
	@ApiOperation(value="思想状况问卷得分情况-通过id删除", notes="思想状况问卷得分情况-通过id删除")
	@RequiresPermissions("politics_single_score:nl_employee_politics_single_score:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		nlEmployeePoliticsSingleScoreService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "思想状况问卷得分情况-批量删除")
	@ApiOperation(value="思想状况问卷得分情况-批量删除", notes="思想状况问卷得分情况-批量删除")
	@RequiresPermissions("politics_single_score:nl_employee_politics_single_score:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.nlEmployeePoliticsSingleScoreService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "思想状况问卷得分情况-通过id查询")
	@ApiOperation(value="思想状况问卷得分情况-通过id查询", notes="思想状况问卷得分情况-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<NlEmployeePoliticsSingleScore> queryById(@RequestParam(name="id",required=true) String id) {
		NlEmployeePoliticsSingleScore nlEmployeePoliticsSingleScore = nlEmployeePoliticsSingleScoreService.getById(id);
		if(nlEmployeePoliticsSingleScore==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(nlEmployeePoliticsSingleScore);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param nlEmployeePoliticsSingleScore
    */
    @RequiresPermissions("politics_single_score:nl_employee_politics_single_score:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, NlEmployeePoliticsSingleScore nlEmployeePoliticsSingleScore) {
        return super.exportXls(request, nlEmployeePoliticsSingleScore, NlEmployeePoliticsSingleScore.class, "思想状况问卷得分情况");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("politics_single_score:nl_employee_politics_single_score:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, NlEmployeePoliticsSingleScore.class);
    }

}
