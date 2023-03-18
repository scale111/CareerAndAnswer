package cn.iocoder.yudao.module.member.controller.app.student.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "用户 APP - 学生信息更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AppStudentUpdateReqVO extends AppStudentBaseVO {

    @Schema(description = "学生ID", required = true, example = "5296")
    @NotNull(message = "学生ID不能为空")
    private Long id;

}
