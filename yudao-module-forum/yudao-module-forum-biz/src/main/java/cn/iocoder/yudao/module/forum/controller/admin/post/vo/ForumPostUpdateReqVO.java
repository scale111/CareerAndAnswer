package cn.iocoder.yudao.module.forum.controller.admin.post.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 帖子更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ForumPostUpdateReqVO extends ForumPostBaseVO {

    @Schema(description = "帖子ID", required = true, example = "392")
    @NotNull(message = "帖子ID不能为空")
    private Long id;

}
