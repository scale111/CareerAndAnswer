package cn.iocoder.yudao.module.information.controller.admin.careertalk.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 宣讲会创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CareertalkCreateReqVO extends CareertalkBaseVO {

}
