package cn.iocoder.yudao.module.information.controller.app.careertalk.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "用户 APP - 宣讲会 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppCareertalkRespVO extends AppCareertalkBaseVO {

    @Schema(description = "ID", required = true, example = "5198")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}