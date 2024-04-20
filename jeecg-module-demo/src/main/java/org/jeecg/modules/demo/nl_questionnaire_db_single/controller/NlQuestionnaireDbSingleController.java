package org.jeecg.modules.demo.nl_questionnaire_db_single.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.demo.nl_questionnaire_db_choice_single.service.INlQuestionnaireDbChoiceSingleService;
import org.jeecg.modules.demo.nl_questionnaire_db_single.entity.NlQuestionnaireDbSingle;
import org.jeecg.modules.demo.nl_questionnaire_db_single.service.INlQuestionnaireDbSingleService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.modules.demo.nl_questionnaire_db_single.vo.NlQuestionnaireSingleVO;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

/**
 * @Description: 问卷题库管理
 * @Author: jeecg-boot
 * @Date: 2024-04-20
 * @Version: V1.0
 */
@Api(tags = "问卷题库管理")
@RestController
@RequestMapping("/nl_questionnaire_db_single/nlQuestionnaireDbSingle")
@Slf4j
public class NlQuestionnaireDbSingleController extends JeecgController<NlQuestionnaireDbSingle, INlQuestionnaireDbSingleService> {
    @Autowired
    private INlQuestionnaireDbSingleService questionService;

    @Autowired
    private INlQuestionnaireDbChoiceSingleService choiceService;

    /**
     * 分页列表查询
     *
     * @param nlQuestionnaireDbSingle
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "问卷题库管理-分页列表查询")
    public Result<IPage<NlQuestionnaireDbSingle>> queryPageList(NlQuestionnaireDbSingle nlQuestionnaireDbSingle,
                                                                @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                                @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                                HttpServletRequest req) {
        QueryWrapper<NlQuestionnaireDbSingle> queryWrapper = QueryGenerator.initQueryWrapper(nlQuestionnaireDbSingle, req.getParameterMap());
        Page<NlQuestionnaireDbSingle> page = new Page<NlQuestionnaireDbSingle>(pageNo, pageSize);
        IPage<NlQuestionnaireDbSingle> pageList = questionService.page(page, queryWrapper);
//        List<NlQuestionnaireDbSingle> list = questionService.list();
//        queryPageList1(nlQuestionnaireDbSingle,pageNo,pageSize,req);
        return Result.OK(pageList);
    }

    @ApiOperation(value = "问卷题库管理-分页列表查询", notes = "问卷题库管理-分页列表查询")
    @GetMapping(value = "/list")
    public Result<IPage<NlQuestionnaireSingleVO>> queryPageList1(NlQuestionnaireDbSingle nlQuestionnaireDbSingle,
                                                                 @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                                 @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                                 HttpServletRequest req) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("questionnaireType", req.getParameter("questionnaireType"));
        params.put("questionName", req.getParameter("questionName"));
        params.put("delFlag", req.getParameter("delFlag"));
        Page<NlQuestionnaireSingleVO> page = new Page<>(pageNo, pageSize);
        IPage<NlQuestionnaireSingleVO> pageList = questionService.getQuestionPage(page, params);


        return Result.OK(pageList);
    }

    /**
     * 添加
     *
     * @param questionVO
     * @return
     */
    @AutoLog(value = "问卷题库管理-添加")
    @ApiOperation(value = "问卷题库管理-添加", notes = "问卷题库管理-添加")
    @RequiresPermissions("nl_questionnaire_db_single:nl_questionnaire_db_single:add")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody NlQuestionnaireSingleVO questionVO) {
//        singleService.save(questionVO);
        questionService.saveQuestionWithChoice(questionVO);

        return Result.OK("添加成功！");
    }

    /**
     * 编辑
     *
     * @param questionVO
     * @return
     */
    @AutoLog(value = "问卷题库管理-编辑")
    //TODO 需要修改为和添加一样的逻辑
    @ApiOperation(value = "问卷题库管理-编辑", notes = "问卷题库管理-编辑")
    @RequiresPermissions("nl_questionnaire_db_single:nl_questionnaire_db_single:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody NlQuestionnaireSingleVO questionVO) {
//        questionService.updateById(nlQuestionnaireDbSingle);
        questionService.updateQuestion(questionVO);
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "问卷题库管理-通过id删除")
    @ApiOperation(value = "问卷题库管理-通过id删除", notes = "问卷题库管理-通过id删除")
    @RequiresPermissions("nl_questionnaire_db_single:nl_questionnaire_db_single:delete")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
//        singleService.removeById(id);
        questionService.removeQuestionByIdWithChoice(id);

        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "问卷题库管理-批量删除")
    @ApiOperation(value = "问卷题库管理-批量删除", notes = "问卷题库管理-批量删除")
    @RequiresPermissions("nl_questionnaire_db_single:nl_questionnaire_db_single:deleteBatch")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        this.questionService.removeQuestionByIdsWithChoice(list);
        this.questionService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "问卷题库管理-通过id查询")
    @ApiOperation(value = "问卷题库管理-通过id查询", notes = "问卷题库管理-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<NlQuestionnaireDbSingle> queryById(@RequestParam(name = "id", required = true) String id) {
        NlQuestionnaireDbSingle nlQuestionnaireDbSingle = questionService.getById(id);
        if (nlQuestionnaireDbSingle == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(nlQuestionnaireDbSingle);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param nlQuestionnaireDbSingle
     */
    @RequiresPermissions("nl_questionnaire_db_single:nl_questionnaire_db_single:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, NlQuestionnaireDbSingle nlQuestionnaireDbSingle) {
        return super.exportXls(request, nlQuestionnaireDbSingle, NlQuestionnaireDbSingle.class, "问卷题库管理");
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    @RequiresPermissions("nl_questionnaire_db_single:nl_questionnaire_db_single:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, NlQuestionnaireDbSingle.class);
    }

}
