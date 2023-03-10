package cn.iocoder.yudao.module.member.controller.admin.mentor.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 导师信息 Excel 导出 Request VO，参数和 MentorPageReqVO 是一致的")
@Data
public class MentorExportReqVO {

    @Schema(description = "导师工号")
    private String jobNumber;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "姓名", example = "张三")
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

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
