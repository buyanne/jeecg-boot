package org.jeecg.modules.demo.specialist.controller;

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
import org.jeecg.modules.demo.specialist.entity.NlSpecialistInfo;
import org.jeecg.modules.demo.specialist.service.INlSpecialistInfoService;

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
 * @Description: nl_specialist_info
 * @Author: jeecg-boot
 * @Date:   2024-01-29
 * @Version: V1.0
 */
@Api(tags="nl_specialist_info")
@RestController
@RequestMapping("/specialist/nlSpecialistInfo")
@Slf4j
public class NlSpecialistInfoController extends JeecgController<NlSpecialistInfo, INlSpecialistInfoService> {
	@Autowired
	private INlSpecialistInfoService nlSpecialistInfoService;
	
	/**
	 * 分页列表查询
	 *
	 * @param nlSpecialistInfo
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "nl_specialist_info-分页列表查询")
	@ApiOperation(value="nl_specialist_info-分页列表查询", notes="nl_specialist_info-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<NlSpecialistInfo>> queryPageList(NlSpecialistInfo nlSpecialistInfo,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<NlSpecialistInfo> queryWrapper = QueryGenerator.initQueryWrapper(nlSpecialistInfo, req.getParameterMap());
		Page<NlSpecialistInfo> page = new Page<NlSpecialistInfo>(pageNo, pageSize);
		IPage<NlSpecialistInfo> pageList = nlSpecialistInfoService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param nlSpecialistInfo
	 * @return
	 */
	@AutoLog(value = "nl_specialist_info-添加")
	@ApiOperation(value="nl_specialist_info-添加", notes="nl_specialist_info-添加")
	@RequiresPermissions("specialist:nl_specialist_info:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody NlSpecialistInfo nlSpecialistInfo) {
		nlSpecialistInfoService.save(nlSpecialistInfo);
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param nlSpecialistInfo
	 * @return
	 */
	@AutoLog(value = "nl_specialist_info-编辑")
	@ApiOperation(value="nl_specialist_info-编辑", notes="nl_specialist_info-编辑")
	@RequiresPermissions("specialist:nl_specialist_info:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody NlSpecialistInfo nlSpecialistInfo) {
		nlSpecialistInfoService.updateById(nlSpecialistInfo);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "nl_specialist_info-通过id删除")
	@ApiOperation(value="nl_specialist_info-通过id删除", notes="nl_specialist_info-通过id删除")
	@RequiresPermissions("specialist:nl_specialist_info:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		nlSpecialistInfoService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "nl_specialist_info-批量删除")
	@ApiOperation(value="nl_specialist_info-批量删除", notes="nl_specialist_info-批量删除")
	@RequiresPermissions("specialist:nl_specialist_info:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.nlSpecialistInfoService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "nl_specialist_info-通过id查询")
	@ApiOperation(value="nl_specialist_info-通过id查询", notes="nl_specialist_info-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<NlSpecialistInfo> queryById(@RequestParam(name="id",required=true) String id) {
		NlSpecialistInfo nlSpecialistInfo = nlSpecialistInfoService.getById(id);
		if(nlSpecialistInfo==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(nlSpecialistInfo);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param nlSpecialistInfo
    */
    @RequiresPermissions("specialist:nl_specialist_info:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, NlSpecialistInfo nlSpecialistInfo) {
        return super.exportXls(request, nlSpecialistInfo, NlSpecialistInfo.class, "nl_specialist_info");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("specialist:nl_specialist_info:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, NlSpecialistInfo.class);
    }

}
