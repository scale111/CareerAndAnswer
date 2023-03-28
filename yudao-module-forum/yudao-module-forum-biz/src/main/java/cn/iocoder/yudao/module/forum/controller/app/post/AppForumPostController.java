package cn.iocoder.yudao.module.forum.controller.app.post;

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
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.module.forum.controller.app.post.vo.*;
import cn.iocoder.yudao.module.forum.dal.dataobject.post.ForumPostDO;
import cn.iocoder.yudao.module.forum.convert.post.ForumPostConvert;
import cn.iocoder.yudao.module.forum.service.post.ForumPostService;

@Tag(name = "用户 APP - 帖子")
@RestController
@RequestMapping("/forum/post")
@Validated
public class AppForumPostController {

    @Resource
    private ForumPostService postService;

    @PostMapping("/create")
    @Operation(summary = "创建帖子")

    public CommonResult<Long> createPost(@Valid @RequestBody AppForumPostCreateReqVO createReqVO) {
        return success(postService.appCreatePost(createReqVO));
    }

//    @PutMapping("/update")
//    @Operation(summary = "更新帖子")
//
//    public CommonResult<Boolean> updatePost(@Valid @RequestBody AppForumPostUpdateReqVO updateReqVO) {
//        postService.updatePost(updateReqVO);
//        return success(true);
//    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除帖子")
    @Parameter(name = "id", description = "编号", required = true)

    public CommonResult<Boolean> deletePost(@RequestParam("id") Long id) {
        postService.deletePost(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得帖子")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")

    public CommonResult<AppForumPostRespVO> getPost(@RequestParam("id") Long id) {
        ForumPostDO post = postService.getPost(id);
        return success(ForumPostConvert.INSTANCE.appConvert(post));
    }

    @GetMapping("/getall")
    @Operation(summary = "获得所有帖子")

    public CommonResult<List<AppForumPostRespVO>> getAllPostList() {
        List<ForumPostDO> list = postService.getAllPostList();
        return success(ForumPostConvert.INSTANCE.appConvertList(list));
    }



}
