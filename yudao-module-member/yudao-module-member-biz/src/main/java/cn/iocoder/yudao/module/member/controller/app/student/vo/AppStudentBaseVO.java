package cn.iocoder.yudao.module.member.controller.app.student.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
* 学生信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class AppStudentBaseVO {

    @Schema(description = "学生学号", required = true)
    @NotNull(message = "学生学号不能为空")
    private String studentNumber;

    @Schema(description = "手机号", required = true)
    @NotNull(message = "手机号不能为空")
    private String mobile;

    @Schema(description = "姓名", required = true, example = "王五")
    @NotNull(message = "姓名不能为空")
    private String name;

    @Schema(description = "身份证号", required = true)
    @NotNull(message = "身份证号不能为空")
    private String idCard;

    @Schema(description = "性别", required = true)
    @NotNull(message = "性别不能为空")
    private String gender;

    @Schema(description = "学校", required = true)
    @NotNull(message = "学校不能为空")
    private String school;

    @Schema(description = "学院", required = true)
    @NotNull(message = "学院不能为空")
    private String college;

    @Schema(description = "专业", required = true)
    @NotNull(message = "专业不能为空")
    private String major;

    @Schema(description = "就业状态", required = true, example = "2")
    @NotNull(message = "就业状态不能为空")
    private String employmentStatus;

    @Schema(description = "openid", example = "26638")
    private String openid;

}
