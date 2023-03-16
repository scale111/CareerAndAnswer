package cn.iocoder.yudao.module.information.controller.app.jobfair.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Schema(description = "用户 APP - 招聘会 Concerns VO")
@Data
@ToString(callSuper = true)
public class AppJobfairConcernsVO {

    @Schema(description = "ID", required = true, example = "30301")
    private Long id;

    @Schema(description = "关注人数")
    private Integer concernsNumber;

}
