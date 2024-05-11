package org.jeecg.modules.demo.nl_skill_reply.controller;

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
import org.jeecg.modules.demo.nl_politics_reply.service.INlEmployeePoliticsRequestReplyService;
import org.jeecg.modules.demo.nl_pyschology_reply.service.INlEmployeePyschologyRequestReplyService;
import org.jeecg.modules.demo.nl_questionnaire_db_choice_single.entity.NlQuestionnaireDbChoiceSingle;
import org.jeecg.modules.demo.nl_questionnaire_db_choice_single.service.INlQuestionnaireDbChoiceSingleService;
import org.jeecg.modules.demo.nl_questionnaire_db_single.service.INlQuestionnaireDbSingleService;
import org.jeecg.modules.demo.nl_questionnaire_list.entity.NlQuestionnaireList;
import org.jeecg.modules.demo.nl_questionnaire_list.service.INlQuestionnaireListService;
import org.jeecg.modules.demo.nl_questionnaire_list.vo.QuestionVO;
import org.jeecg.modules.demo.nl_skill_reply.entity.NlEmployeeSkillRequestReply;
import org.jeecg.modules.demo.nl_skill_reply.service.INlEmployeeSkillRequestReplyService;
import org.jeecg.modules.demo.nl_skill_score.entity.NlEmployeeSkillSingleScore;
import org.jeecg.modules.demo.nl_skill_score.service.INlEmployeeSkillSingleScoreService;
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
 * @Description: 技能测评
 * @Author: jeecg-boot
 * @Date: 2024-05-11
 * @Version: V1.0
 */
@Api(tags = "技能测评")
@RestController
@RequestMapping("/nl_skill_reply/nlEmployeeSkillRequestReply")
@Slf4j
public class NlEmployeeSkillRequestReplyController extends JeecgController<NlEmployeeSkillRequestReply, INlEmployeeSkillRequestReplyService> {
    @Autowired
    private INlEmployeeSkillRequestReplyService nlEmployeeSkillRequestReplyService;
    @Autowired
    private INlEmployeePyschologyRequestReplyService nlEmployeePyschologyRequestReplyService;
    @Autowired
    private INlEmployeePoliticsRequestReplyService nlEmployeePoliticsRequestReplyService;

    @Autowired
    private INlQuestionnaireListService questionnaireListService;


    @Autowired
    private INlQuestionnaireListService listService;

    @Autowired
    private INlQuestionnaireDbSingleService singleService;
    @Autowired
    private INlQuestionnaireDbChoiceSingleService choiceSingleService;
    private static final Integer SKILL_TYPE = 2;
    private List<NlQuestionnaireList> list = null;

    @Autowired
    private INlEmployeeSkillSingleScoreService scoreService;

    @GetMapping(value = "queryQuestionnaire")
    public Result<NlQuestionnaireList> queryQuestionListByListId1(@RequestParam(name = "id", required = true) String listId) {
        if (list == null) {
            list = questionnaireListService.list();

        }

        NlQuestionnaireList res = null;
        for (NlQuestionnaireList questionnaireList : list) {
            if (questionnaireList.getQuestionnaireType().equals(SKILL_TYPE)) {
                res = questionnaireList;
                break;
            }
        }
        if (res == null) {
            return Result.ok(res);
        }
        Integer listId1 = res.getId();
        LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        String employeeId = loginUser.getId();
        List<NlEmployeeSkillRequestReply> byQuestionnaireIdAndEmployeeId = this.nlEmployeeSkillRequestReplyService.getByQuestionnaireIdAndEmployeeId(listId1, employeeId);

        if (!byQuestionnaireIdAndEmployeeId.isEmpty()) {
            res = null;
        }
        return Result.ok(res);
    }

    @GetMapping(value = "queryQuestionList")
    public Result<List<QuestionVO>> queryQuestionListByListId(@RequestParam(name = "id", required = true) String listId) {
        if (list == null) {
            list = questionnaireListService.list();
        }
        NlQuestionnaireList nlQuestionnaireList = null;
        for (NlQuestionnaireList questionnaireList : list) {
            if (questionnaireList.getQuestionnaireType().equals(SKILL_TYPE)) {
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
        NlQuestionnaireList questionnaireList = listService.getById(listId);
        Double singleScore = questionnaireList.getSingleScore();
        List<NlEmployeeSkillRequestReply> saveList = new ArrayList<>();
        LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        for (SelectedChoice selectedChoice : questionList) {
            NlEmployeeSkillRequestReply reply = new NlEmployeeSkillRequestReply();
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
        this.nlEmployeeSkillRequestReplyService.saveBatch(saveList);

        double sumOfScore = 0.0f;
        for (NlEmployeeSkillRequestReply reply : saveList) {
            sumOfScore += reply.getScore();
        }
        NlEmployeeSkillSingleScore score = new NlEmployeeSkillSingleScore();
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
     * @param nlEmployeeSkillRequestReply
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "技能测评-分页列表查询")
    @ApiOperation(value = "技能测评-分页列表查询", notes = "技能测评-分页列表查询")
    @GetMapping(value = "/list")
    public Result<IPage<NlEmployeeSkillRequestReply>> queryPageList(NlEmployeeSkillRequestReply nlEmployeeSkillRequestReply,
                                                                    @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                                    @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                                    HttpServletRequest req) {
        QueryWrapper<NlEmployeeSkillRequestReply> queryWrapper = QueryGenerator.initQueryWrapper(nlEmployeeSkillRequestReply, req.getParameterMap());
        Page<NlEmployeeSkillRequestReply> page = new Page<NlEmployeeSkillRequestReply>(pageNo, pageSize);
        IPage<NlEmployeeSkillRequestReply> pageList = nlEmployeeSkillRequestReplyService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

    /**
     * 添加
     *
     * @param nlEmployeeSkillRequestReply
     * @return
     */
    @AutoLog(value = "技能测评-添加")
    @ApiOperation(value = "技能测评-添加", notes = "技能测评-添加")
    @RequiresPermissions("nl_skill_reply:nl_employee_skill_request_reply:add")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody NlEmployeeSkillRequestReply nlEmployeeSkillRequestReply) {
        nlEmployeeSkillRequestReplyService.save(nlEmployeeSkillRequestReply);
        return Result.OK("添加成功！");
    }

    /**
     * 编辑
     *
     * @param nlEmployeeSkillRequestReply
     * @return
     */
    @AutoLog(value = "技能测评-编辑")
    @ApiOperation(value = "技能测评-编辑", notes = "技能测评-编辑")
    @RequiresPermissions("nl_skill_reply:nl_employee_skill_request_reply:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody NlEmployeeSkillRequestReply nlEmployeeSkillRequestReply) {
        nlEmployeeSkillRequestReplyService.updateById(nlEmployeeSkillRequestReply);
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "技能测评-通过id删除")
    @ApiOperation(value = "技能测评-通过id删除", notes = "技能测评-通过id删除")
    @RequiresPermissions("nl_skill_reply:nl_employee_skill_request_reply:delete")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
        nlEmployeeSkillRequestReplyService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "技能测评-批量删除")
    @ApiOperation(value = "技能测评-批量删除", notes = "技能测评-批量删除")
    @RequiresPermissions("nl_skill_reply:nl_employee_skill_request_reply:deleteBatch")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.nlEmployeeSkillRequestReplyService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "技能测评-通过id查询")
    @ApiOperation(value = "技能测评-通过id查询", notes = "技能测评-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<NlEmployeeSkillRequestReply> queryById(@RequestParam(name = "id", required = true) String id) {
        NlEmployeeSkillRequestReply nlEmployeeSkillRequestReply = nlEmployeeSkillRequestReplyService.getById(id);
        if (nlEmployeeSkillRequestReply == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(nlEmployeeSkillRequestReply);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param nlEmployeeSkillRequestReply
     */
    @RequiresPermissions("nl_skill_reply:nl_employee_skill_request_reply:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, NlEmployeeSkillRequestReply nlEmployeeSkillRequestReply) {
        return super.exportXls(request, nlEmployeeSkillRequestReply, NlEmployeeSkillRequestReply.class, "技能测评");
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    @RequiresPermissions("nl_skill_reply:nl_employee_skill_request_reply:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, NlEmployeeSkillRequestReply.class);
    }

}
