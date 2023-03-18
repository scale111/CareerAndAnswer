package cn.iocoder.yudao.module.member.controller.app.student.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "用户 APP - 学生信息 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppStudentRespVO extends AppStudentBaseVO {

    @Schema(description = "学生ID", required = true, example = "5296")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
