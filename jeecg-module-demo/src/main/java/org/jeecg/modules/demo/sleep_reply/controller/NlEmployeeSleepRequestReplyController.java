package org.jeecg.modules.demo.sleep_reply.controller;

import java.util.*;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.nl_politics_reply.dto.ReplyParams;
import org.jeecg.modules.demo.nl_politics_reply.dto.SelectedChoice;
import org.jeecg.modules.demo.nl_politics_reply.service.INlEmployeePoliticsRequestReplyService;
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
import org.jeecg.modules.demo.sleep_reply.entity.NlEmployeeSleepRequestReply;
import org.jeecg.modules.demo.sleep_reply.service.INlEmployeeSleepRequestReplyService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.modules.demo.sleep_score.entity.NlEmployeeSleepSingleScore;
import org.jeecg.modules.demo.sleep_score.service.INlEmployeeSleepSingleScoreService;
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
 * @Description: 睡眠质量测评
 * @Author: jeecg-boot
 * @Date: 2024-05-11
 * @Version: V1.0
 */
@Api(tags = "睡眠质量测评")
@RestController
@RequestMapping("/sleep_reply/nlEmployeeSleepRequestReply")
@Slf4j
public class NlEmployeeSleepRequestReplyController extends JeecgController<NlEmployeeSleepRequestReply, INlEmployeeSleepRequestReplyService> {
    @Autowired
    private INlEmployeeSleepRequestReplyService nlEmployeeSleepRequestReplyService;
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
    private static final Integer SLEEP_TYPE = 1;
    private List<NlQuestionnaireList> list = null;

    @Autowired
    private INlEmployeeSleepSingleScoreService scoreService;

    @GetMapping(value = "queryQuestionnaire")
    public Result<NlQuestionnaireList> queryQuestionListByListId1(@RequestParam(name = "id", required = true) String listId) {
        if (list == null) {
            list = questionnaireListService.list();
        }
        NlQuestionnaireList res = null;
        for (NlQuestionnaireList questionnaireList : list) {
            if (questionnaireList.getQuestionnaireType().equals(SLEEP_TYPE)) {
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
        List<NlEmployeeSleepRequestReply> byQuestionnaireIdAndEmployeeId = this.nlEmployeeSleepRequestReplyService.getByQuestionnaireIdAndEmployeeId(listId1, employeeId);
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
            if (questionnaireList.getQuestionnaireType().equals(SLEEP_TYPE)) {
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
        List<NlEmployeeSleepRequestReply> saveList = new ArrayList<>();
        LoginUser loginUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();
        for (SelectedChoice selectedChoice : questionList) {
            NlEmployeeSleepRequestReply reply = new NlEmployeeSleepRequestReply();
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
        nlEmployeeSleepRequestReplyService.saveBatch(saveList);
        double sumOfScore = 0.0f;
        for (NlEmployeeSleepRequestReply reply : saveList) {
            sumOfScore += reply.getScore();
        }
        NlEmployeeSleepSingleScore score = new NlEmployeeSleepSingleScore();
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
     * @param nlEmployeeSleepRequestReply
     * @param pageNo
     * @param pageSize
     * @param req
     * @return
     */
    //@AutoLog(value = "睡眠质量测评-分页列表查询")
    @ApiOperation(value = "睡眠质量测评-分页列表查询", notes = "睡眠质量测评-分页列表查询")
    @GetMapping(value = "/list")
    public Result<IPage<NlEmployeeSleepRequestReply>> queryPageList(NlEmployeeSleepRequestReply nlEmployeeSleepRequestReply,
                                                                    @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                                    @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                                    HttpServletRequest req) {
        QueryWrapper<NlEmployeeSleepRequestReply> queryWrapper = QueryGenerator.initQueryWrapper(nlEmployeeSleepRequestReply, req.getParameterMap());
        Page<NlEmployeeSleepRequestReply> page = new Page<NlEmployeeSleepRequestReply>(pageNo, pageSize);
        IPage<NlEmployeeSleepRequestReply> pageList = nlEmployeeSleepRequestReplyService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

    /**
     * 添加
     *
     * @param nlEmployeeSleepRequestReply
     * @return
     */
    @AutoLog(value = "睡眠质量测评-添加")
    @ApiOperation(value = "睡眠质量测评-添加", notes = "睡眠质量测评-添加")
    @RequiresPermissions("sleep_reply:nl_employee_sleep_request_reply:add")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody NlEmployeeSleepRequestReply nlEmployeeSleepRequestReply) {
        nlEmployeeSleepRequestReplyService.save(nlEmployeeSleepRequestReply);
        return Result.OK("添加成功！");
    }

    /**
     * 编辑
     *
     * @param nlEmployeeSleepRequestReply
     * @return
     */
    @AutoLog(value = "睡眠质量测评-编辑")
    @ApiOperation(value = "睡眠质量测评-编辑", notes = "睡眠质量测评-编辑")
    @RequiresPermissions("sleep_reply:nl_employee_sleep_request_reply:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody NlEmployeeSleepRequestReply nlEmployeeSleepRequestReply) {
        nlEmployeeSleepRequestReplyService.updateById(nlEmployeeSleepRequestReply);
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "睡眠质量测评-通过id删除")
    @ApiOperation(value = "睡眠质量测评-通过id删除", notes = "睡眠质量测评-通过id删除")
    @RequiresPermissions("sleep_reply:nl_employee_sleep_request_reply:delete")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
        nlEmployeeSleepRequestReplyService.removeById(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "睡眠质量测评-批量删除")
    @ApiOperation(value = "睡眠质量测评-批量删除", notes = "睡眠质量测评-批量删除")
    @RequiresPermissions("sleep_reply:nl_employee_sleep_request_reply:deleteBatch")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        this.nlEmployeeSleepRequestReplyService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "睡眠质量测评-通过id查询")
    @ApiOperation(value = "睡眠质量测评-通过id查询", notes = "睡眠质量测评-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<NlEmployeeSleepRequestReply> queryById(@RequestParam(name = "id", required = true) String id) {
        NlEmployeeSleepRequestReply nlEmployeeSleepRequestReply = nlEmployeeSleepRequestReplyService.getById(id);
        if (nlEmployeeSleepRequestReply == null) {
            return Result.error("未找到对应数据");
        }
        return Result.OK(nlEmployeeSleepRequestReply);
    }

    /**
     * 导出excel
     *
     * @param request
     * @param nlEmployeeSleepRequestReply
     */
    @RequiresPermissions("sleep_reply:nl_employee_sleep_request_reply:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, NlEmployeeSleepRequestReply nlEmployeeSleepRequestReply) {
        return super.exportXls(request, nlEmployeeSleepRequestReply, NlEmployeeSleepRequestReply.class, "睡眠质量测评");
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    @RequiresPermissions("sleep_reply:nl_employee_sleep_request_reply:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, NlEmployeeSleepRequestReply.class);
    }

}
