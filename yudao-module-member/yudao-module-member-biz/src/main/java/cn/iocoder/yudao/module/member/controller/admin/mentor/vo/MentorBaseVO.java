package cn.iocoder.yudao.module.member.controller.admin.mentor.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
* 导师信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class MentorBaseVO {

    @Schema(description = "导师工号", required = true)
    @NotNull(message = "导师工号不能为空")
    private String jobNumber;

    @Schema(description = "手机号", required = true)
    @NotNull(message = "手机号不能为空")
    private String mobile;

    @Schema(description = "姓名", required = true, example = "张三")
    @NotNull(message = "姓名不能为空")
    private String name;

    @Schema(description = "照片")
    private String photo;

    @Schema(description = "性别")
    private String gender;

    @Schema(description = "学校")
    private String school;

    @Schema(description = "学院")
    private String college;

    @Schema(description = "专业")
    private String major;

    @Schema(description = "导师简介")
    private String bio;

    @Schema(description = "详细信息")
    private String dio;

    @Schema(description = "openid", example = "32707")
    private String openid;

}
