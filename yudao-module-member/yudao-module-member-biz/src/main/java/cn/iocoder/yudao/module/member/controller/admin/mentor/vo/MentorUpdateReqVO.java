package cn.iocoder.yudao.module.member.controller.admin.mentor.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 导师信息更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MentorUpdateReqVO extends MentorBaseVO {

    @Schema(description = "导师ID", required = true, example = "16663")
    @NotNull(message = "导师ID不能为空")
    private Long id;

}
