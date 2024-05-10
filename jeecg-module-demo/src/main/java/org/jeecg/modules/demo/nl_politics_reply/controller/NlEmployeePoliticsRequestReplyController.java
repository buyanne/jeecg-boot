package org.jeecg.modules.demo.nl_politics_reply.controller;

import java.util.*;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.nl_politics_reply.entity.NlEmployeePoliticsRequestReply;
import org.jeecg.modules.demo.nl_politics_reply.service.INlEmployeePoliticsRequestReplyService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.modules.demo.nl_questionnaire_list.entity.NlQuestionnaireList;
import org.jeecg.modules.demo.nl_questionnaire_list.service.INlQuestionnaireListService;
import org.jeecg.modules.demo.nl_questionnaire_list.vo.QuestionVO;
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
 * @Description: 思想状态回答表
 * @Author: jeecg-boot
 * @Date: 2024-05-08
 * @Version: V1.0
 */
@Api(tags = "思想状态回答表")
@RestController
@RequestMapping("/nl_politics_reply/nlEmployeePoliticsRequestReply")
@Slf4j
public class NlEmployeePoliticsRequestReplyController extends JeecgController<NlEmployeePoliticsRequestReply, INlEmployeePoliticsRequestReplyService> {
    @Autowired
    private INlEmployeePoliticsRequestReplyService nlEmployeePoliticsRequestReplyService;

    @Autowired
    private INlQuestionnaireListService questionnaireListService;

    private static final Integer POLITICS_TYPE = 4;
    private List<NlQuestionnaireList> list = null;

    @ApiOperation(value = "测评问卷生成-预览题目列表", notes = "测评问卷生成-预览题目列表")
    @GetMapping(value = "queryPoliticsQuestionnaire")
    public Result<NlQuestionnaireList> queryQuestionListByListId1(@RequestParam(name = "id", required = true) String listId) {
        if (list == null) {
            list = questionnaireListService.list();
        }
        NlQuestionnaireList res = null;
        for (NlQuestionnaireList questionnaireList : list) {
            if (questionnaireList.getQuestionnaireType().equals(POLITICS_TYPE)) {
                res = questionnaireList;
                break;
            }
        }
        if (res == null) {
            return Result.error("没有对应数据");
        } else {
            return Result.ok(res);
        }
    }


    @ApiOperation(value = "测评问卷生成-预览题目列表", notes = "测评问卷生成-预览题目列表")
    @GetMapping(value = "queryQuestionList")
    public Result<List<QuestionVO>> queryQuestionListByListId(@RequestParam(name = "id", required = true) String listId) {
        if (list == null) {
            list = questionnaireListService.list();
        }
        NlQuestionnaireList nlQuestionnaireList = null;
        for (NlQuestionnaireList questionnaireList : list) {
            if (questionnaireList.getQuestionnaireType().equals(POLITICS_TYPE)) {
                nlQuestionnaireList = questionnaireList;
                break;
            }
        }
        if (nlQuestionnaireList == null) {
            List<QuestionVO> ans = new ArrayList<>();
            return Result.ok(ans);
        } else {
            List<QuestionVO> res = this.questionnaireListService.getQuestionByListId(String.valueOf(nlQuestionnaireList.getId()));
            return Result.ok(res);
        }


    }


    /**
     * 分页列表查询
     *
     * @param nlEmployeePoliticsRequestReply
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "思想状态回答表-分页列表查询")
    @ApiOperation(value = "思想状态回答表-分页列表查询", notes = "思想状态回答表-分页列表查询")
    @GetMapping(value = "/list")
    public Result<IPage<NlEmployeePoliticsRequestReply>> queryPageList(NlEmployeePoliticsRequestReply nlEmployeePoliticsRequestReply,
                                                                       @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                                       @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                                       HttpServletRequest req) {
        QueryWrapper<NlEmployeePoliticsRequestReply> queryWrapper = QueryGenerator.initQueryWrapper(nlEmployeePoliticsRequestReply, req.getParameterMap());
        Page<NlEmployeePoliticsRequestReply> page = new Page<NlEmployeePoliticsRequestReply>(pageNo, pageSize);
        IPage<NlEmployeePoliticsRequestReply> pageList = nlEmployeePoliticsRequestReplyService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

    /**
     * 添加
     *
     * @param nlEmployeePoliticsRequestReply
     * @return
     */
    @AutoLog(value = "思想状态回答表-添加")
    @ApiOperation(value = "思想状态回答表-添加", notes = "思想状态回答表-添加")
    @RequiresPermissions("nl_politics_reply:nl_employee_politics_request_reply:add")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody NlEmployeePoliticsRequestReply nlEmployeePoliticsRequestReply) {
        nlEmployeePoliticsRequestReplyService.save(nlEmployeePoliticsRequestReply);
        return Result.OK("添加成功！");
    }

    /**
     * 编辑
     *
     * @param nlEmployeePoliticsRequestReply
     * @return
     */
    @AutoLog(value = "思想状态回答表-编辑")
    @ApiOperation(value = "思想状态回答表-编辑", notes = "思想状态回答表-编辑")
    @RequiresPermissions("nl_politics_reply:nl_employee_politics_request_reply:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody NlEmployeePoliticsRequestReply nlEmployeePoliticsRequestReply) {
        nlEmployeePoliticsRequestReplyService.updateById(nlEmployeePoliticsRequestReply);
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "思想状态回答表-通过id删除")
    @ApiOperation(value = "思想状态回答表-通过id删除", notes = "思想状态回答表-通过id删除")
    @RequiresPermissions("nl_politics_reply:nl_employee_politics_request_reply:delete")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
        nlEmployeePoliticsRequestReplyService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "思想状态回答表-批量删除")
    @ApiOperation(value = "思想状态回答表-批量删除", notes = "思想状态回答表-批量删除")
    @RequiresPermissions("nl_politics_reply:nl_employee_politics_request_reply:deleteBatch")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.nlEmployeePoliticsRequestReplyService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "思想状态回答表-通过id查询")
    @ApiOperation(value = "思想状态回答表-通过id查询", notes = "思想状态回答表-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<NlEmployeePoliticsRequestReply> queryById(@RequestParam(name = "id", required = true) String id) {
        NlEmployeePoliticsRequestReply nlEmployeePoliticsRequestReply = nlEmployeePoliticsRequestReplyService.getById(id);
        if (nlEmployeePoliticsRequestReply == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(nlEmployeePoliticsRequestReply);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param nlEmployeePoliticsRequestReply
     */
    @RequiresPermissions("nl_politics_reply:nl_employee_politics_request_reply:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, NlEmployeePoliticsRequestReply nlEmployeePoliticsRequestReply) {
        return super.exportXls(request, nlEmployeePoliticsRequestReply, NlEmployeePoliticsRequestReply.class, "思想状态回答表");
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    @RequiresPermissions("nl_politics_reply:nl_employee_politics_request_reply:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, NlEmployeePoliticsRequestReply.class);
    }

}
