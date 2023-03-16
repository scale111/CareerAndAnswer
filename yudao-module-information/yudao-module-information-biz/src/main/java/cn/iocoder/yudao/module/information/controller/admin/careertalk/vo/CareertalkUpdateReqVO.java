package cn.iocoder.yudao.module.information.controller.admin.careertalk.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 宣讲会更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CareertalkUpdateReqVO extends CareertalkBaseVO {

    @Schema(description = "ID", required = true, example = "5198")
    @NotNull(message = "ID不能为空")
    private Long id;

}
