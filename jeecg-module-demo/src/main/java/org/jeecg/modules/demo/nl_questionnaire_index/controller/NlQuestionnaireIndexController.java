package org.jeecg.modules.demo.nl_questionnaire_index.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.jeecg.common.system.base.controller.JeecgController;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.modules.demo.nl_questionnaire_db_choice_single.service.INlQuestionnaireDbChoiceSingleService;
import org.jeecg.modules.demo.nl_questionnaire_index.entity.NlQuestionnaireIndex;
import org.jeecg.modules.demo.nl_questionnaire_index.service.INlQuestionnaireIndexService;
import org.jeecg.modules.demo.nl_questionnaire_index.vo.IndexTreeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Description: nl_questionnaire_index
 * @Author: jeecg-boot
 * @Date: 2024-04-19
 * @Version: V1.0
 */
@Api(tags = "nl_questionnaire_index")
@RestController
@RequestMapping("/nl_questionnaire_index/nlQuestionnaireIndex")
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
    //@AutoLog(value = "nl_questionnaire_index-分页列表查询")
//    @ApiOperation(value = "nl_questionnaire_index-分页列表查询", notes = "nl_questionnaire_index-分页列表查询")
//    @GetMapping(value = "/list")
    public Result<IPage<NlQuestionnaireIndex>> queryPageList(NlQuestionnaireIndex nlQuestionnaireIndex,
                                                             @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                             @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                             HttpServletRequest req) {
        QueryWrapper<NlQuestionnaireIndex> queryWrapper = QueryGenerator.initQueryWrapper(nlQuestionnaireIndex, req.getParameterMap());
        Page<NlQuestionnaireIndex> page = new Page<NlQuestionnaireIndex>(pageNo, pageSize);
        IPage<NlQuestionnaireIndex> pageList = nlQuestionnaireIndexService.page(page, queryWrapper);
        return Result.OK(pageList);
    }

    @GetMapping(value = "/getIndexTree")
    public Result<List<IndexTreeVO>> queryIndexTree() {
        List<NlQuestionnaireIndex> metaList = nlQuestionnaireIndexService.list();
        List<IndexTreeVO> treeList = new ArrayList<>();
        getTreeList(treeList, metaList);
        return Result.ok(treeList);

    }


    @GetMapping(value = "/list")
    public Result<List<IndexTreeVO>> queryPageList1(NlQuestionnaireIndex nlQuestionnaireIndex,
                                                    @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                    @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize,
                                                    HttpServletRequest req) {
        List<NlQuestionnaireIndex> metaList = nlQuestionnaireIndexService.list();
        List<IndexTreeVO> treeList = new ArrayList<>();

//        List<NlQuestionnaireIndex> metaList = pageList.getRecords();
        getTreeList(treeList, metaList);

        return Result.OK(treeList);
    }

    private void getTreeList(List<IndexTreeVO> treeList, List<NlQuestionnaireIndex> metaList) {
        for (NlQuestionnaireIndex index : metaList) {
            IndexTreeVO tree = new IndexTreeVO(index);
            if (tree.getParentId() == 0) {
                treeList.add(tree);
                addChildren(tree, metaList);
            }
        }
        treeList.sort(new Comparator<IndexTreeVO>() {
            @Override
            public int compare(IndexTreeVO o1, IndexTreeVO o2) {
                return o1.getOrderNum().compareTo(o2.getOrderNum());
            }
        });
    }

    private void addChildren(IndexTreeVO parent, List<NlQuestionnaireIndex> metaList) {
        List<IndexTreeVO> children = new ArrayList<>();
        for (NlQuestionnaireIndex index : metaList) {
            if (index.getParentId().equals(parent.getId()) || index.getParentId().intValue() == parent.getId().intValue()) {
                IndexTreeVO childTree = new IndexTreeVO(index);
                children.add(childTree);
                addChildren(childTree, metaList);
            }
        }
        children.sort(new Comparator<IndexTreeVO>() {
            @Override
            public int compare(IndexTreeVO o1, IndexTreeVO o2) {
                return o1.getOrderNum().compareTo(o2.getOrderNum());
            }
        });
        parent.setChildren(children);
    }


    /**
     * 添加
     *
     * @param nlQuestionnaireIndex
     * @return
     */
    @AutoLog(value = "nl_questionnaire_index-添加")
    @ApiOperation(value = "nl_questionnaire_index-添加", notes = "nl_questionnaire_index-添加")
    @RequiresPermissions("nl_questionnaire_index:nl_questionnaire_index:add")
    @PostMapping(value = "/add")
    public Result<String> add(@RequestBody NlQuestionnaireIndex nlQuestionnaireIndex) {
        nlQuestionnaireIndexService.save(nlQuestionnaireIndex);
        return Result.OK("添加成功！");
    }

    /**
     * 编辑
     *
     * @param nlQuestionnaireIndex
     * @return
     */
    @AutoLog(value = "nl_questionnaire_index-编辑")
    @ApiOperation(value = "nl_questionnaire_index-编辑", notes = "nl_questionnaire_index-编辑")
    @RequiresPermissions("nl_questionnaire_index:nl_questionnaire_index:edit")
    @RequestMapping(value = "/edit", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<String> edit(@RequestBody NlQuestionnaireIndex nlQuestionnaireIndex) {
        nlQuestionnaireIndexService.updateById(nlQuestionnaireIndex);
        return Result.OK("编辑成功!");
    }

    /**
     * 通过id删除
     *
     * @param id
     * @return
     */
    @AutoLog(value = "nl_questionnaire_index-通过id删除")
    @ApiOperation(value = "nl_questionnaire_index-通过id删除", notes = "nl_questionnaire_index-通过id删除")
    @RequiresPermissions("nl_questionnaire_index:nl_questionnaire_index:delete")
    @DeleteMapping(value = "/delete")
    public Result<String> delete(@RequestParam(name = "id", required = true) String id) {
//        nlQuestionnaireIndexService.removeById(id);
        nlQuestionnaireIndexService.removeByIdWithSubTree(id);
        return Result.OK("删除成功!");
    }

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    @AutoLog(value = "nl_questionnaire_index-批量删除")
    @ApiOperation(value = "nl_questionnaire_index-批量删除", notes = "nl_questionnaire_index-批量删除")
    @RequiresPermissions("nl_questionnaire_index:nl_questionnaire_index:deleteBatch")
    @DeleteMapping(value = "/deleteBatch")
    public Result<String> deleteBatch(@RequestParam(name = "ids", required = true) String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        this.nlQuestionnaireIndexService.removeByIdsWithSubTree(list);
//        this.nlQuestionnaireIndexService.removeByIds(Arrays.asList(ids.split(",")));
        return Result.OK("批量删除成功!");
    }

    /**
     * 通过id查询
     *
     * @param id
     * @return
     */
    //@AutoLog(value = "nl_questionnaire_index-通过id查询")
    @ApiOperation(value = "nl_questionnaire_index-通过id查询", notes = "nl_questionnaire_index-通过id查询")
    @GetMapping(value = "/queryById")
    public Result<NlQuestionnaireIndex> queryById(@RequestParam(name = "id", required = true) String id) {
        NlQuestionnaireIndex nlQuestionnaireIndex = nlQuestionnaireIndexService.getById(id);
        if (nlQuestionnaireIndex == null) {
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
    @RequiresPermissions("nl_questionnaire_index:nl_questionnaire_index:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, NlQuestionnaireIndex nlQuestionnaireIndex) {
        return super.exportXls(request, nlQuestionnaireIndex, NlQuestionnaireIndex.class, "nl_questionnaire_index");
    }

    /**
     * 通过excel导入数据
     *
     * @param request
     * @param response
     * @return
     */
    @RequiresPermissions("nl_questionnaire_index:nl_questionnaire_index:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, NlQuestionnaireIndex.class);
    }

}
