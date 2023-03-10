package cn.iocoder.yudao.module.member.controller.admin.student.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 学生信息 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StudentRespVO extends StudentBaseVO {

    @Schema(description = "学生ID", required = true, example = "31927")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
