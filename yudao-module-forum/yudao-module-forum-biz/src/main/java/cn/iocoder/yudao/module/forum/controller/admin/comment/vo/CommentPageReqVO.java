package cn.iocoder.yudao.module.forum.controller.admin.comment.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 评论分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CommentPageReqVO extends PageParam {

    @Schema(description = "评论人ID", example = "30148")
    private Long commenterId;

    @Schema(description = "评论人昵称", example = "王五")
    private String commenterNickname;

    @Schema(description = "评论人头像")
    private String commenterAvatar;

    @Schema(description = "被评论人ID", example = "24055")
    private Long reviewedId;

    @Schema(description = "被评论人昵称", example = "王五")
    private String reviewedNickname;

    @Schema(description = "被评论人头像")
    private String reviewedAvatar;

    @Schema(description = "帖子ID", example = "14551")
    private Long postId;

    @Schema(description = "评论等级")
    private Byte level;

    @Schema(description = "评论上级ID", example = "27199")
    private Long superiorId;

    @Schema(description = "评论内容")
    private String text;

    @Schema(description = "审核状态", example = "1")
    private Byte auditStatus;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
