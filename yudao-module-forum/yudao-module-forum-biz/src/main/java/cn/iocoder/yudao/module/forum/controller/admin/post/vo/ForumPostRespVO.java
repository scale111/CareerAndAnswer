package cn.iocoder.yudao.module.forum.controller.admin.post.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 帖子 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ForumPostRespVO extends ForumPostBaseVO {

    @Schema(description = "帖子ID", required = true, example = "392")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
