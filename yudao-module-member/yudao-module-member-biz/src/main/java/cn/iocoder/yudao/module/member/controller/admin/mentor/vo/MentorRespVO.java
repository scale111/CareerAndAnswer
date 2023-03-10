package cn.iocoder.yudao.module.member.controller.admin.mentor.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 导师信息 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MentorRespVO extends MentorBaseVO {

    @Schema(description = "导师ID", required = true, example = "16663")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
