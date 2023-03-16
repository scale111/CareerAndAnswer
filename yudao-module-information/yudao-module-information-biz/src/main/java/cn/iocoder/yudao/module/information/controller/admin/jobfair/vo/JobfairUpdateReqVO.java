package cn.iocoder.yudao.module.information.controller.admin.jobfair.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 招聘会更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class JobfairUpdateReqVO extends JobfairBaseVO {

    @Schema(description = "ID", required = true, example = "10873")
    @NotNull(message = "ID不能为空")
    private Long id;

}
