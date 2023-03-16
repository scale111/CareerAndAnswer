package cn.iocoder.yudao.module.information.controller.app.recruitment.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "用户 APP - 招聘信息 Concerns VO")
@Data
@ToString(callSuper = true)
public class AppRecruitmentConcernsVO {

    @Schema(description = "ID", required = true, example = "30301")
    private Long id;

    @Schema(description = "关注人数")
    private Integer concernsNumber;

}
