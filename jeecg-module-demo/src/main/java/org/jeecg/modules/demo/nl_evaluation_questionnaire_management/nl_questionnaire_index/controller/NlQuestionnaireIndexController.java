package org.jeecg.modules.demo.nl_evaluation_questionnaire_management.nl_questionnaire_index.controller;

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
import org.jeecg.modules.demo.nl_evaluation_questionnaire_management.nl_questionnaire_index.entity.NlQuestionnaireIndex;
import org.jeecg.modules.demo.nl_evaluation_questionnaire_management.nl_questionnaire_index.service.INlQuestionnaireIndexService;

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
 * @Description: 问卷指标管理
 * @Author: jeecg-boot
 * @Date:   2024-03-27
 * @Version: V1.0
 */
@Api(tags="问卷指标管理")
@RestController
@RequestMapping("/nl_evaluation_questionnaire_management.nl_questionnaire_index/nlQuestionnaireIndex")
@Slf4j
public class NlQuestionnaireIndexController extends JeecgController<NlQuestionnaireIndex, INlQuestionnaireIndexService> {
	@Autowired
	private INlQuestionnaireIndexService nlQuestionnaireIndexService;
	
	/**
	 * 分页列表查询
	 *
	 * @param nlQuestionnaireIndex
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "问卷指标管理-分页列表查询")
	@ApiOperation(value="问卷指标管理-分页列表查询", notes="问卷指标管理-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<NlQuestionnaireIndex>> queryPageList(NlQuestionnaireIndex nlQuestionnaireIndex,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<NlQuestionnaireIndex> queryWrapper = QueryGenerator.initQueryWrapper(nlQuestionnaireIndex, req.getParameterMap());
		Page<NlQuestionnaireIndex> page = new Page<NlQuestionnaireIndex>(pageNo, pageSize);
		IPage<NlQuestionnaireIndex> pageList = nlQuestionnaireIndexService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param nlQuestionnaireIndex
	 * @return
	 */
	@AutoLog(value = "问卷指标管理-添加")
	@ApiOperation(value="问卷指标管理-添加", notes="问卷指标管理-添加")
	@RequiresPermissions("nl_evaluation_questionnaire_management.nl_questionnaire_index:nl_questionnaire_index:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody NlQuestionnaireIndex nlQuestionnaireIndex) {
		nlQuestionnaireIndexService.save(nlQuestionnaireIndex);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param nlQuestionnaireIndex
	 * @return
	 */
	@AutoLog(value = "问卷指标管理-编辑")
	@ApiOperation(value="问卷指标管理-编辑", notes="问卷指标管理-编辑")
	@RequiresPermissions("nl_evaluation_questionnaire_management.nl_questionnaire_index:nl_questionnaire_index:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody NlQuestionnaireIndex nlQuestionnaireIndex) {
		nlQuestionnaireIndexService.updateById(nlQuestionnaireIndex);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "问卷指标管理-通过id删除")
	@ApiOperation(value="问卷指标管理-通过id删除", notes="问卷指标管理-通过id删除")
	@RequiresPermissions("nl_evaluation_questionnaire_management.nl_questionnaire_index:nl_questionnaire_index:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		nlQuestionnaireIndexService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "问卷指标管理-批量删除")
	@ApiOperation(value="问卷指标管理-批量删除", notes="问卷指标管理-批量删除")
	@RequiresPermissions("nl_evaluation_questionnaire_management.nl_questionnaire_index:nl_questionnaire_index:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.nlQuestionnaireIndexService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "问卷指标管理-通过id查询")
	@ApiOperation(value="问卷指标管理-通过id查询", notes="问卷指标管理-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<NlQuestionnaireIndex> queryById(@RequestParam(name="id",required=true) String id) {
		NlQuestionnaireIndex nlQuestionnaireIndex = nlQuestionnaireIndexService.getById(id);
		if(nlQuestionnaireIndex==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(nlQuestionnaireIndex);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param nlQuestionnaireIndex
    */
    @RequiresPermissions("nl_evaluation_questionnaire_management.nl_questionnaire_index:nl_questionnaire_index:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, NlQuestionnaireIndex nlQuestionnaireIndex) {
        return super.exportXls(request, nlQuestionnaireIndex, NlQuestionnaireIndex.class, "问卷指标管理");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("nl_evaluation_questionnaire_management.nl_questionnaire_index:nl_questionnaire_index:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, NlQuestionnaireIndex.class);
    }

}
