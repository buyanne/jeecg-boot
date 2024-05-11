package org.jeecg.modules.demo.nl_skill_score.controller;

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
import org.jeecg.modules.demo.nl_skill_score.entity.NlEmployeeSkillSingleScore;
import org.jeecg.modules.demo.nl_skill_score.service.INlEmployeeSkillSingleScoreService;

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
 * @Description: 技能得分
 * @Author: jeecg-boot
 * @Date:   2024-05-11
 * @Version: V1.0
 */
@Api(tags="技能得分")
@RestController
@RequestMapping("/nl_skill_score/nlEmployeeSkillSingleScore")
@Slf4j
public class NlEmployeeSkillSingleScoreController extends JeecgController<NlEmployeeSkillSingleScore, INlEmployeeSkillSingleScoreService> {
	@Autowired
	private INlEmployeeSkillSingleScoreService nlEmployeeSkillSingleScoreService;
	
	/**
	 * 分页列表查询
	 *
	 * @param nlEmployeeSkillSingleScore
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "技能得分-分页列表查询")
	@ApiOperation(value="技能得分-分页列表查询", notes="技能得分-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<NlEmployeeSkillSingleScore>> queryPageList(NlEmployeeSkillSingleScore nlEmployeeSkillSingleScore,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<NlEmployeeSkillSingleScore> queryWrapper = QueryGenerator.initQueryWrapper(nlEmployeeSkillSingleScore, req.getParameterMap());
		Page<NlEmployeeSkillSingleScore> page = new Page<NlEmployeeSkillSingleScore>(pageNo, pageSize);
		IPage<NlEmployeeSkillSingleScore> pageList = nlEmployeeSkillSingleScoreService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param nlEmployeeSkillSingleScore
	 * @return
	 */
	@AutoLog(value = "技能得分-添加")
	@ApiOperation(value="技能得分-添加", notes="技能得分-添加")
	@RequiresPermissions("nl_skill_score:nl_employee_skill_single_score:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody NlEmployeeSkillSingleScore nlEmployeeSkillSingleScore) {
		nlEmployeeSkillSingleScoreService.save(nlEmployeeSkillSingleScore);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param nlEmployeeSkillSingleScore
	 * @return
	 */
	@AutoLog(value = "技能得分-编辑")
	@ApiOperation(value="技能得分-编辑", notes="技能得分-编辑")
	@RequiresPermissions("nl_skill_score:nl_employee_skill_single_score:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody NlEmployeeSkillSingleScore nlEmployeeSkillSingleScore) {
		nlEmployeeSkillSingleScoreService.updateById(nlEmployeeSkillSingleScore);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "技能得分-通过id删除")
	@ApiOperation(value="技能得分-通过id删除", notes="技能得分-通过id删除")
	@RequiresPermissions("nl_skill_score:nl_employee_skill_single_score:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		nlEmployeeSkillSingleScoreService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "技能得分-批量删除")
	@ApiOperation(value="技能得分-批量删除", notes="技能得分-批量删除")
	@RequiresPermissions("nl_skill_score:nl_employee_skill_single_score:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.nlEmployeeSkillSingleScoreService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "技能得分-通过id查询")
	@ApiOperation(value="技能得分-通过id查询", notes="技能得分-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<NlEmployeeSkillSingleScore> queryById(@RequestParam(name="id",required=true) String id) {
		NlEmployeeSkillSingleScore nlEmployeeSkillSingleScore = nlEmployeeSkillSingleScoreService.getById(id);
		if(nlEmployeeSkillSingleScore==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(nlEmployeeSkillSingleScore);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param nlEmployeeSkillSingleScore
    */
    @RequiresPermissions("nl_skill_score:nl_employee_skill_single_score:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, NlEmployeeSkillSingleScore nlEmployeeSkillSingleScore) {
        return super.exportXls(request, nlEmployeeSkillSingleScore, NlEmployeeSkillSingleScore.class, "技能得分");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("nl_skill_score:nl_employee_skill_single_score:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, NlEmployeeSkillSingleScore.class);
    }

}
