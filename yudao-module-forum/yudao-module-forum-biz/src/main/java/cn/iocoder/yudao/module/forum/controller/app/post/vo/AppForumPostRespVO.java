package cn.iocoder.yudao.module.forum.controller.app.post.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "用户 APP - 帖子 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppForumPostRespVO extends AppForumPostBaseVO {

    @Schema(description = "帖子ID", required = true, example = "392")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
