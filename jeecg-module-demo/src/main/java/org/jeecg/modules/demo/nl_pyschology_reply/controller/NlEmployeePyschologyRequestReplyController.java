package org.jeecg.modules.demo.nl_pyschology_reply.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.modules.demo.nl_politics_reply.dto.ReplyParams;
import org.jeecg.modules.demo.nl_politics_reply.dto.SelectedChoice;
import org.jeecg.modules.demo.nl_pyschology_reply.entity.NlEmployeePyschologyRequestReply;
import org.jeecg.modules.demo.nl_pyschology_reply.service.INlEmployeePyschologyRequestReplyService;
import org.jeecg.modules.demo.nl_pyschology_score.entity.NlEmployeePyschologySingleScore;
import org.jeecg.modules.demo.nl_pyschology_score.service.INlEmployeePyschologySingleScoreService;
import org.jeecg.modules.demo.nl_questionnaire_db_choice_single.entity.NlQuestionnaireDbChoiceSingle;
import org.jeecg.modules.demo.nl_questionnaire_db_choice_single.service.INlQuestionnaireDbChoiceSingleService;
import org.jeecg.modules.demo.nl_questionnaire_db_single.service.INlQuestionnaireDbSingleService;
import org.jeecg.modules.demo.nl_questionnaire_list.entity.NlQuestionnaireList;
import org.jeecg.modules.demo.nl_questionnaire_list.service.INlQuestionnaireListService;
import org.jeecg.modules.demo.nl_questionnaire_list.vo.QuestionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @Description: 心理状况回答表
 * @Author: jeecg-boot
 * @Date: 2024-05-10
 * @Version: V1.0
 */
@Api(tags = "心理状况回答表")
@RestController
@RequestMapping("/nl_pyschology_reply/nlEmployeePyschologyRequestReply")
@Slf4j
public class NlEmployeePyschologyRequestReplyController extends JeecgController<NlEmployeePyschologyRequestReply, INlEmployeePyschologyRequestReplyService> {
    @Autowired
    private INlEmployeePyschologyRequestReplyService nlEmployeePyschologyRequestReplyService;

    @Autowired
    private INlQuestionnaireListService questionnaireListService;


    @Autowired
    private INlQuestionnaireListService listService;

    @Autowired
    private INlQuestionnaireDbSingleService singleService;
    @Autowired
    private INlQuestionnaireDbChoiceSingleService choiceSingleService;
    private static final Integer PYSCHOLOGY_TYPE = 3;
    private List<NlQuestionnaireList> list = null;

    @Autowired
    private INlEmployeePyschologySingleScoreService scoreService;


    @GetMapping(value = "queryQuestionnaire")

    public Result<NlQuestionnaireList> queryQuestionListByListId1(@RequestParam(name = "id", required = true) String listId) {
        if (list == null) {
            list = questionnaireListService.list();
        }
        NlQuestionnaireList res = null;
        for (NlQuestionnaireList questionnaireList : list) {
            if (questionnaireList.getQuestionnaireType().equals(PYSCHOLOGY_TYPE)) {
                res = questionnaireList;
                break;
            }
        }
        if (res == null) {
            return Result.ok(res);
        }
//        res = null;
        //        todo 需要查reply的得分情况，如果有就返回null，否则返回res
        Integer listId1 = res.getId();
        LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        String employeeId = loginUser.getId();
        List<NlEmployeePyschologyRequestReply> byQuestionnaireIdAndEmployeeId = this.nlEmployeePyschologyRequestReplyService.getByQuestionnaireIdAndEmployeeId(listId1, employeeId);
        if (!byQuestionnaireIdAndEmployeeId.isEmpty()) {
            res = null;
        }

        return Result.ok(res);
    }

    @ApiOperation(value = "测评问卷生成-预览题目列表", notes = "测评问卷生成-预览题目列表")
    @GetMapping(value = "queryQuestionList")
    public Result<List<QuestionVO>> queryQuestionListByListId(@RequestParam(name = "id", required = true) String listId) {
        if (list == null) {
            list = questionnaireListService.list();
        }
        NlQuestionnaireList nlQuestionnaireList = null;
        for (NlQuestionnaireList questionnaireList : list) {
            if (questionnaireList.getQuestionnaireType().equals(PYSCHOLOGY_TYPE)) {
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

    @PostMapping(value = "saveReply")
    public Result<String> saveReply(@RequestBody ReplyParams replyParams) {
        List<SelectedChoice> questionList = replyParams.getQuestionList();

        Integer listId = replyParams.getListId();
//        System.out.println(listId);
        NlQuestionnaireList questionnaireList = listService.getById(listId);
        Double singleScore = questionnaireList.getSingleScore();

//        保存提交记录
        List<NlEmployeePyschologyRequestReply> saveList = new ArrayList<>();
        LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        for (SelectedChoice selectedChoice : questionList) {
            NlEmployeePyschologyRequestReply reply = new NlEmployeePyschologyRequestReply();
            reply.setEmployeeId(loginUser.getId());
            reply.setQuestionnaireId(replyParams.getListId());
            Integer questionId = selectedChoice.getQuestionId();
            reply.setQuestionId(questionId);
            Integer selectedChoiceId = selectedChoice.getSelectedChoice();
            reply.setAnswerId(selectedChoiceId);
            NlQuestionnaireDbChoiceSingle choiceById = choiceSingleService.getById(selectedChoiceId);
            Double choiceScoreWeight = choiceById.getChoiceScoreWeight();
            reply.setScore(singleScore * choiceScoreWeight);
            saveList.add(reply);
        }
        nlEmployeePyschologyRequestReplyService.saveBatch(saveList);
//        for (NlEmployeePoliticsRequestReply reply : saveList) {
//            System.out.println(reply);
//        }
//        保存得分情况
        double sumOfScore = 0.0f;
        for (NlEmployeePyschologyRequestReply reply : saveList) {
            sumOfScore += reply.getScore();
        }
        NlEmployeePyschologySingleScore score = new NlEmployeePyschologySingleScore();
        score.setEmployeeId(loginUser.getId());
        score.setQuestionScore(sumOfScore);
        score.setSubmitTime(new Date());
        score.setQuestionnaireId(listId);
        scoreService.save(score);

        return Result.ok();
    }

    /**
     * 分页列表查询
     *
     * @param nlEmployeePyschologyRequestReply
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "心理状况回答表-分页列表查询")
    @ApiOperation(value = "心理状况回答表-分页列表查询", notes = "心理状况回答表-分页列表查询")
    @GetMapping(value = "/list")
    public Result<IPage<NlEmployeePyschologyRequestReply>> queryPageList(NlEmployeePyschologyRequestReply nlEmployeePyschologyRequestReply,
                                                                         @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                                         @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                                         HttpServletRequest req) {
        QueryWrapper<NlEmployeePyschologyRequestReply> queryWrapper = QueryGenerator.initQueryWrapper(nlEmployeePyschologyRequestReply, req.getParameterMap());
        Page<NlEmployeePyschologyRequestReply> page = new Page<NlEmployeePyschologyRequestReply>(pageNo, pageSize);
        IPage<NlEmployeePyschologyRequestReply> pageList = nlEmployeePyschologyRequestReplyService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

    /**
     * 添加
     *
     * @param nlEmployeePyschologyRequestReply
     * @return
     */
    @AutoLog(value = "心理状况回答表-添加")
    @ApiOperation(value = "心理状况回答表-添加", notes = "心理状况回答表-添加")
    @RequiresPermissions("nl_pyschology_reply:nl_employee_pyschology_request_reply:add")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody NlEmployeePyschologyRequestReply nlEmployeePyschologyRequestReply) {
        nlEmployeePyschologyRequestReplyService.save(nlEmployeePyschologyRequestReply);
        return Result.OK("添加成功！");
    }

    /**
     * 编辑
     *
     * @param nlEmployeePyschologyRequestReply
     * @return
     */
    @AutoLog(value = "心理状况回答表-编辑")
    @ApiOperation(value = "心理状况回答表-编辑", notes = "心理状况回答表-编辑")
    @RequiresPermissions("nl_pyschology_reply:nl_employee_pyschology_request_reply:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody NlEmployeePyschologyRequestReply nlEmployeePyschologyRequestReply) {
        nlEmployeePyschologyRequestReplyService.updateById(nlEmployeePyschologyRequestReply);
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "心理状况回答表-通过id删除")
    @ApiOperation(value = "心理状况回答表-通过id删除", notes = "心理状况回答表-通过id删除")
    @RequiresPermissions("nl_pyschology_reply:nl_employee_pyschology_request_reply:delete")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
        nlEmployeePyschologyRequestReplyService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "心理状况回答表-批量删除")
    @ApiOperation(value = "心理状况回答表-批量删除", notes = "心理状况回答表-批量删除")
    @RequiresPermissions("nl_pyschology_reply:nl_employee_pyschology_request_reply:deleteBatch")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.nlEmployeePyschologyRequestReplyService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "心理状况回答表-通过id查询")
    @ApiOperation(value = "心理状况回答表-通过id查询", notes = "心理状况回答表-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<NlEmployeePyschologyRequestReply> queryById(@RequestParam(name = "id", required = true) String id) {
        NlEmployeePyschologyRequestReply nlEmployeePyschologyRequestReply = nlEmployeePyschologyRequestReplyService.getById(id);
        if (nlEmployeePyschologyRequestReply == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(nlEmployeePyschologyRequestReply);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param nlEmployeePyschologyRequestReply
     */
    @RequiresPermissions("nl_pyschology_reply:nl_employee_pyschology_request_reply:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, NlEmployeePyschologyRequestReply nlEmployeePyschologyRequestReply) {
        return super.exportXls(request, nlEmployeePyschologyRequestReply, NlEmployeePyschologyRequestReply.class, "心理状况回答表");
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    @RequiresPermissions("nl_pyschology_reply:nl_employee_pyschology_request_reply:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, NlEmployeePyschologyRequestReply.class);
    }

}
