package cn.iocoder.yudao.module.information.controller.admin.jobfair.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 招聘会创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class JobfairCreateReqVO extends JobfairBaseVO {

}
