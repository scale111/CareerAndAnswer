package cn.iocoder.yudao.module.member.controller.admin.student.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 学生信息更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StudentUpdateReqVO extends StudentBaseVO {

    @Schema(description = "学生ID", required = true, example = "31927")
    @NotNull(message = "学生ID不能为空")
    private Long id;

}
