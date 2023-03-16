package cn.iocoder.yudao.module.information.controller.app.careertalk.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Schema(description = "用户 APP - 宣讲会 Concerns VO")
@Data
@ToString(callSuper = true)
public class AppCareertalkConcernsVO {

    @Schema(description = "ID", required = true, example = "30301")
    private Long id;

    @Schema(description = "关注人数")
    private Integer concernsNumber;

}
