package cn.iocoder.yudao.module.forum.controller.app.comment;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

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

import cn.iocoder.yudao.module.forum.controller.app.comment.vo.*;
import cn.iocoder.yudao.module.forum.dal.dataobject.comment.CommentDO;
import cn.iocoder.yudao.module.forum.convert.comment.CommentConvert;
import cn.iocoder.yudao.module.forum.service.comment.CommentService;

@Tag(name = "用户 APP - 评论")
@RestController
@RequestMapping("/forum/comment")
@Validated
public class AppCommentController {

    @Resource
    private CommentService commentService;

    @PostMapping("/create")
    @Operation(summary = "创建评论")

    public CommonResult<Long> createComment(@Valid @RequestBody AppCommentCreateReqVO createReqVO) {
        return success(commentService.appCreateComment(createReqVO));
    }


    @DeleteMapping("/delete")
    @Operation(summary = "删除评论")
    @Parameter(name = "id", description = "编号", required = true)

    public CommonResult<Boolean> deleteComment(@RequestParam("id") Long id) {
        commentService.deleteComment(id);
        return success(true);
    }


    @GetMapping("/list")
    @Operation(summary = "获得评论列表")
    @Parameter(name = "postId", description = "帖子id", required = true, example = "6")

    public CommonResult<List<AppCommentRespVO>> getCommentListByPostId(@RequestParam("postId") Long postId) {
        List<CommentDO> list = commentService.getCommentListByPostId(postId);
        return success(CommentConvert.INSTANCE.appConvertList(list));
    }


//    @GetMapping("/get")
//    @Operation(summary = "获得评论")
//    @Parameter(name = "id", description = "编号", required = true, example = "1024")
//
//    public CommonResult<AppCommentRespVO> getComment(@RequestParam("id") Long id) {
//        CommentDO comment = commentService.getComment(id);
//        return success(CommentConvert.INSTANCE.appConvert(comment));
//    }

//    @GetMapping("/list")
//    @Operation(summary = "获得评论列表")
//    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
//
//    public CommonResult<List<AppCommentRespVO>> getCommentList(@RequestParam("ids") Collection<Long> ids) {
//        List<CommentDO> list = commentService.getCommentList(ids);
//        return success(CommentConvert.INSTANCE.appConvertList(list));
//    }


}
