package cn.iocoder.yudao.module.forum.controller.admin.post;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.forum.controller.admin.post.vo.*;
import cn.iocoder.yudao.module.forum.dal.dataobject.post.ForumPostDO;
import cn.iocoder.yudao.module.forum.convert.post.ForumPostConvert;
import cn.iocoder.yudao.module.forum.service.post.ForumPostService;

@Tag(name = "管理后台 - 帖子")
@RestController
@RequestMapping("/forum/post")
@Validated
public class ForumPostController {

    @Resource
    private ForumPostService postService;

    @PostMapping("/create")
    @Operation(summary = "创建帖子")
    @PreAuthorize("@ss.hasPermission('forum:post:create')")
    public CommonResult<Long> createPost(@Valid @RequestBody ForumPostCreateReqVO createReqVO) {
        return success(postService.createPost(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新帖子")
    @PreAuthorize("@ss.hasPermission('forum:post:update')")
    public CommonResult<Boolean> updatePost(@Valid @RequestBody ForumPostUpdateReqVO updateReqVO) {
        postService.updatePost(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除帖子")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('forum:post:delete')")
    public CommonResult<Boolean> deletePost(@RequestParam("id") Long id) {
        postService.deletePost(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得帖子")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('forum:post:query')")
    public CommonResult<ForumPostRespVO> getPost(@RequestParam("id") Long id) {
        ForumPostDO post = postService.getPost(id);
        return success(ForumPostConvert.INSTANCE.convert(post));
    }

    @GetMapping("/list")
    @Operation(summary = "获得帖子列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('forum:post:query')")
    public CommonResult<List<ForumPostRespVO>> getPostList(@RequestParam("ids") Collection<Long> ids) {
        List<ForumPostDO> list = postService.getPostList(ids);
        return success(ForumPostConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得帖子分页")
    @PreAuthorize("@ss.hasPermission('forum:post:query')")
    public CommonResult<PageResult<ForumPostRespVO>> getPostPage(@Valid ForumPostPageReqVO pageVO) {
        PageResult<ForumPostDO> pageResult = postService.getPostPage(pageVO);
        return success(ForumPostConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出帖子 Excel")
    @PreAuthorize("@ss.hasPermission('forum:post:export')")
    @OperateLog(type = EXPORT)
    public void exportPostExcel(@Valid ForumPostExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<ForumPostDO> list = postService.getPostList(exportReqVO);
        // 导出 Excel
        List<ForumPostExcelVO> datas = ForumPostConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "帖子.xls", "数据", ForumPostExcelVO.class, datas);
    }

}
