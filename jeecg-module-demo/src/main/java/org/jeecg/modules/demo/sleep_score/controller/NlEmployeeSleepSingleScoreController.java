package org.jeecg.modules.demo.sleep_score.controller;

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
import org.jeecg.modules.demo.sleep_score.entity.NlEmployeeSleepSingleScore;
import org.jeecg.modules.demo.sleep_score.service.INlEmployeeSleepSingleScoreService;

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
 * @Description: 睡眠测评得分
 * @Author: jeecg-boot
 * @Date:   2024-05-11
 * @Version: V1.0
 */
@Api(tags="睡眠测评得分")
@RestController
@RequestMapping("/sleep_score/nlEmployeeSleepSingleScore")
@Slf4j
public class NlEmployeeSleepSingleScoreController extends JeecgController<NlEmployeeSleepSingleScore, INlEmployeeSleepSingleScoreService> {
	@Autowired
	private INlEmployeeSleepSingleScoreService nlEmployeeSleepSingleScoreService;
	
	/**
	 * 分页列表查询
	 *
	 * @param nlEmployeeSleepSingleScore
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "睡眠测评得分-分页列表查询")
	@ApiOperation(value="睡眠测评得分-分页列表查询", notes="睡眠测评得分-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<NlEmployeeSleepSingleScore>> queryPageList(NlEmployeeSleepSingleScore nlEmployeeSleepSingleScore,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<NlEmployeeSleepSingleScore> queryWrapper = QueryGenerator.initQueryWrapper(nlEmployeeSleepSingleScore, req.getParameterMap());
		Page<NlEmployeeSleepSingleScore> page = new Page<NlEmployeeSleepSingleScore>(pageNo, pageSize);
		IPage<NlEmployeeSleepSingleScore> pageList = nlEmployeeSleepSingleScoreService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param nlEmployeeSleepSingleScore
	 * @return
	 */
	@AutoLog(value = "睡眠测评得分-添加")
	@ApiOperation(value="睡眠测评得分-添加", notes="睡眠测评得分-添加")
	@RequiresPermissions("sleep_score:nl_employee_sleep_single_score:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody NlEmployeeSleepSingleScore nlEmployeeSleepSingleScore) {
		nlEmployeeSleepSingleScoreService.save(nlEmployeeSleepSingleScore);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param nlEmployeeSleepSingleScore
	 * @return
	 */
	@AutoLog(value = "睡眠测评得分-编辑")
	@ApiOperation(value="睡眠测评得分-编辑", notes="睡眠测评得分-编辑")
	@RequiresPermissions("sleep_score:nl_employee_sleep_single_score:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody NlEmployeeSleepSingleScore nlEmployeeSleepSingleScore) {
		nlEmployeeSleepSingleScoreService.updateById(nlEmployeeSleepSingleScore);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "睡眠测评得分-通过id删除")
	@ApiOperation(value="睡眠测评得分-通过id删除", notes="睡眠测评得分-通过id删除")
	@RequiresPermissions("sleep_score:nl_employee_sleep_single_score:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		nlEmployeeSleepSingleScoreService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "睡眠测评得分-批量删除")
	@ApiOperation(value="睡眠测评得分-批量删除", notes="睡眠测评得分-批量删除")
	@RequiresPermissions("sleep_score:nl_employee_sleep_single_score:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.nlEmployeeSleepSingleScoreService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "睡眠测评得分-通过id查询")
	@ApiOperation(value="睡眠测评得分-通过id查询", notes="睡眠测评得分-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<NlEmployeeSleepSingleScore> queryById(@RequestParam(name="id",required=true) String id) {
		NlEmployeeSleepSingleScore nlEmployeeSleepSingleScore = nlEmployeeSleepSingleScoreService.getById(id);
		if(nlEmployeeSleepSingleScore==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(nlEmployeeSleepSingleScore);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param nlEmployeeSleepSingleScore
    */
    @RequiresPermissions("sleep_score:nl_employee_sleep_single_score:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, NlEmployeeSleepSingleScore nlEmployeeSleepSingleScore) {
        return super.exportXls(request, nlEmployeeSleepSingleScore, NlEmployeeSleepSingleScore.class, "睡眠测评得分");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("sleep_score:nl_employee_sleep_single_score:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, NlEmployeeSleepSingleScore.class);
    }

}
