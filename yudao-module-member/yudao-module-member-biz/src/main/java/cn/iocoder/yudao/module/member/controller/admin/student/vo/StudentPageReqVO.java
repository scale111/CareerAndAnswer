package cn.iocoder.yudao.module.member.controller.admin.student.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 学生信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class StudentPageReqVO extends PageParam {

    @Schema(description = "学生学号")
    private String studentNumber;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "姓名", example = "赵六")
    private String name;

    @Schema(description = "身份证号")
    private String idCard;

    @Schema(description = "性别")
    private String gender;

    @Schema(description = "学校")
    private String school;

    @Schema(description = "学院")
    private String college;

    @Schema(description = "专业")
    private String major;

    @Schema(description = "就业状态", example = "1")
    private String employmentStatus;

    @Schema(description = "openid", example = "6595")
    private String openid;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
