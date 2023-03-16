package cn.iocoder.yudao.module.information.controller.admin.recruitment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 招聘信息更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RecruitmentUpdateReqVO extends RecruitmentBaseVO {

    @Schema(description = "ID", required = true, example = "30301")
    @NotNull(message = "ID不能为空")
    private Long id;

}
