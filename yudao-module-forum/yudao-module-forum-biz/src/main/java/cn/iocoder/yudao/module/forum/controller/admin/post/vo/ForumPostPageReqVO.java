package cn.iocoder.yudao.module.forum.controller.admin.post.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 帖子分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ForumPostPageReqVO extends PageParam {

    @Schema(description = "发帖人ID", example = "18620")
    private Long userId;

    @Schema(description = "发帖人昵称", example = "王五")
    private String userNickname;

    @Schema(description = "发帖人头像")
    private String avatar;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "内容")
    private String text;

    @Schema(description = "评论数")
    private Integer commentNumber;

    @Schema(description = "点赞数")
    private Integer likeNumber;

    @Schema(description = "不喜欢数")
    private Integer unlikeNumber;

    @Schema(description = "置顶状态", example = "0")
    private Byte sticky;

    @Schema(description = "审核状态", example = "2")
    private Byte auditStatus;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
