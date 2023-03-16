package cn.iocoder.yudao.module.information.controller.app.recruitment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "用户 APP - 招聘信息 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppRecruitmentRespVO extends AppRecruitmentBaseVO {

    @Schema(description = "ID", required = true, example = "30301")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
