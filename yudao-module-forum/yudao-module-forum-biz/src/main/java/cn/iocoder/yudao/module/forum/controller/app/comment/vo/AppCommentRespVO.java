package cn.iocoder.yudao.module.forum.controller.app.comment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "用户 APP - 评论 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppCommentRespVO extends AppCommentBaseVO {

    @Schema(description = "评论ID", required = true, example = "8951")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
