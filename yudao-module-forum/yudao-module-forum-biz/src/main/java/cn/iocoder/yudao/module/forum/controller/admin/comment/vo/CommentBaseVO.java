package cn.iocoder.yudao.module.forum.controller.admin.comment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
* 评论 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class CommentBaseVO {

    @Schema(description = "评论人ID", required = true, example = "30148")
    @NotNull(message = "评论人ID不能为空")
    private Long commenterId;

    @Schema(description = "评论人昵称", required = true, example = "王五")
    @NotNull(message = "评论人昵称不能为空")
    private String commenterNickname;

    @Schema(description = "评论人头像")
    private String commenterAvatar;

    @Schema(description = "被评论人ID", required = true, example = "24055")
    @NotNull(message = "被评论人ID不能为空")
    private Long reviewedId;

    @Schema(description = "被评论人昵称", required = true, example = "王五")
    @NotNull(message = "被评论人昵称不能为空")
    private String reviewedNickname;

    @Schema(description = "被评论人头像")
    private String reviewedAvatar;

    @Schema(description = "帖子ID", required = true, example = "14551")
    @NotNull(message = "帖子ID不能为空")
    private Long postId;

    @Schema(description = "评论等级", required = true)
    @NotNull(message = "评论等级不能为空")
    private Byte level;

    @Schema(description = "评论上级ID", required = true, example = "27199")
    @NotNull(message = "评论上级ID不能为空")
    private Long superiorId;

    @Schema(description = "评论内容")
    private String text;

    @Schema(description = "审核状态", required = true, example = "1")
    @NotNull(message = "审核状态不能为空")
    private Byte auditStatus;

}
