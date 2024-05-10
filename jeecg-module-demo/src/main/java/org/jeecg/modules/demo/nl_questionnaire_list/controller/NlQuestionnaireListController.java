package org.jeecg.modules.demo.nl_questionnaire_list.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.demo.nl_questionnaire_list.entity.NlQuestionnaireList;
import org.jeecg.modules.demo.nl_questionnaire_list.service.INlQuestionnaireListService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.modules.demo.nl_questionnaire_list.vo.NlQuestionnaireListVO;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.modules.demo.nl_questionnaire_list.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;

/**
 * @Description: 测评问卷生成
 * @Author: jeecg-boot
 * @Date: 2024-04-21
 * @Version: V1.0
 */
@Api(tags = "测评问卷生成")
@RestController
@RequestMapping("/nl_questionnaire_list/nlQuestionnaireList")
@Slf4j
public class NlQuestionnaireListController extends JeecgController<NlQuestionnaireList, INlQuestionnaireListService> {
    @Autowired
    private INlQuestionnaireListService questionnaireListService;

    /**
     * 分页列表查询
     *
     * @param nlQuestionnaireList
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "测评问卷生成-分页列表查询")
    @ApiOperation(value = "测评问卷生成-分页列表查询", notes = "测评问卷生成-分页列表查询")
//    @GetMapping(value = "/list")

    public Result<IPage<NlQuestionnaireList>> queryPageList(NlQuestionnaireList nlQuestionnaireList,
                                                            @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                            @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                            HttpServletRequest req) {
        QueryWrapper<NlQuestionnaireList> queryWrapper = QueryGenerator.initQueryWrapper(nlQuestionnaireList, req.getParameterMap());
        Page<NlQuestionnaireList> page = new Page<NlQuestionnaireList>(pageNo, pageSize);
        IPage<NlQuestionnaireList> pageList = questionnaireListService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

    @GetMapping(value = "/list")
    public Result<IPage<NlQuestionnaireListVO>> queryPageList1(NlQuestionnaireListVO nlQuestionnaireListVO,
                                                               @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                               @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                               HttpServletRequest req) {

        HashMap<String, String> params = new HashMap<>();
        params.put("questionnaireType", req.getParameter("questionnaireType"));
        params.put("questionTitle", req.getParameter("questionTitle"));

        Page<NlQuestionnaireListVO> page = new Page<>(pageNo, pageSize);

        IPage<NlQuestionnaireListVO> pageList = this.questionnaireListService.getQuestionnairePage(page, params);
        return Result.OK(pageList);
    }

    /**
     * 添加
     *
     * @param nlQuestionnaireList
     * @return
     */
    @AutoLog(value = "测评问卷生成-添加")
    @ApiOperation(value = "测评问卷生成-添加", notes = "测评问卷生成-添加")
    @RequiresPermissions("nl_questionnaire_list:nl_questionnaire_list:add")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody NlQuestionnaireList nlQuestionnaireList) {
        questionnaireListService.saveWithRandomQuestion(nlQuestionnaireList);
        return Result.OK("添加成功！");
    }

    /**
     * 编辑
     *
     * @param nlQuestionnaireList
     * @return
     */
    @AutoLog(value = "测评问卷生成-编辑")
    @ApiOperation(value = "测评问卷生成-编辑", notes = "测评问卷生成-编辑")
    @RequiresPermissions("nl_questionnaire_list:nl_questionnaire_list:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody NlQuestionnaireList nlQuestionnaireList) {
        questionnaireListService.updateWithQuestion(nlQuestionnaireList);
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "测评问卷生成-通过id删除")
    @ApiOperation(value = "测评问卷生成-通过id删除", notes = "测评问卷生成-通过id删除")
    @RequiresPermissions("nl_questionnaire_list:nl_questionnaire_list:delete")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
        questionnaireListService.removeByIdWithQuestion(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "测评问卷生成-批量删除")
    @ApiOperation(value = "测评问卷生成-批量删除", notes = "测评问卷生成-批量删除")
    @RequiresPermissions("nl_questionnaire_list:nl_questionnaire_list:deleteBatch")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        this.questionnaireListService.removeByIdsWithQuestion(list);
//        this.nlQuestionnaireListService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "测评问卷生成-通过id查询")
    @ApiOperation(value = "测评问卷生成-通过id查询", notes = "测评问卷生成-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<NlQuestionnaireList> queryById(@RequestParam(name = "id", required = true) String id) {
        NlQuestionnaireList nlQuestionnaireList = questionnaireListService.getById(id);
        if (nlQuestionnaireList == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(nlQuestionnaireList);
    }

    @ApiOperation(value = "测评问卷生成-预览题目列表", notes = "测评问卷生成-预览题目列表")
    @GetMapping(value = "queryQuestionListByListId")
    public Result<List<QuestionVO>> queryQuestionListByListId(@RequestParam(name = "id", required = true) String listId) {
        List<QuestionVO> res=this.questionnaireListService.getQuestionByListId(listId);
        return Result.ok(res);
    }



    /**
     * 导出excel
     *
     * @param request
     * @param nlQuestionnaireList
     */
    @RequiresPermissions("nl_questionnaire_list:nl_questionnaire_list:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, NlQuestionnaireList nlQuestionnaireList) {
        return super.exportXls(request, nlQuestionnaireList, NlQuestionnaireList.class, "测评问卷生成");
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    @RequiresPermissions("nl_questionnaire_list:nl_questionnaire_list:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, NlQuestionnaireList.class);
    }

}
