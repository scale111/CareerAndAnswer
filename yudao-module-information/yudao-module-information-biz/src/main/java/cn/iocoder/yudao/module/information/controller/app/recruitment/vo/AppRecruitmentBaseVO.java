package cn.iocoder.yudao.module.information.controller.app.recruitment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 招聘信息 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class AppRecruitmentBaseVO {

    @Schema(description = "标题", required = true)
    @NotNull(message = "标题不能为空")
    private String title;

    @Schema(description = "职位", required = true)
    @NotNull(message = "职位不能为空")
    private String position;

    @Schema(description = "招聘类型", required = true, example = "0")
    @NotNull(message = "招聘类型不能为空")
    private Byte type;

    @Schema(description = "公司名", required = true)
    @NotNull(message = "公司名不能为空")
    private String company;

    @Schema(description = "工作地点", required = true)
    @NotNull(message = "工作地点不能为空")
    private String address;

    @Schema(description = "招聘人数")
    private Integer recruitsNumber;

    @Schema(description = "薪资", required = true)
    @NotNull(message = "薪资不能为空")
    private String salary;

    @Schema(description = "学历要求", required = true, example = "2")
    @NotNull(message = "学历要求不能为空")
    private Byte education;

    @Schema(description = "内容", required = true)
    @NotNull(message = "内容不能为空")
    private String text;

    @Schema(description = "发布时间", required = true)
    @NotNull(message = "发布时间不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime releaseTime;

    @Schema(description = "过期时间", required = true)
    @NotNull(message = "过期时间不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime expirationTime;

    @Schema(description = "关注人数")
    @NotNull(message = "关注人数不能为空")
    private Integer concernsNumber;

    @Schema(description = "开启状态")
    private Byte status;

}
