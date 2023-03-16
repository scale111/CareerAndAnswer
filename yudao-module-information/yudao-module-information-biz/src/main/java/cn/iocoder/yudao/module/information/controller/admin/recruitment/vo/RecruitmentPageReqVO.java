package cn.iocoder.yudao.module.information.controller.admin.recruitment.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 招聘信息分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class RecruitmentPageReqVO extends PageParam {

    @Schema(description = "标题")
    private String title;

    @Schema(description = "职位")
    private String position;

    @Schema(description = "招聘类型", example = "0")
    private Byte type;

    @Schema(description = "公司名")
    private String company;

    @Schema(description = "工作地点")
    private String address;

    @Schema(description = "招聘人数")
    private Integer recruitsNumber;

    @Schema(description = "薪资")
    private String salary;

    @Schema(description = "学历要求", example = "2")
    private Byte education;

    @Schema(description = "内容")
    private String text;

    @Schema(description = "发布时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] releaseTime;

    @Schema(description = "过期时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] expirationTime;

    @Schema(description = "关注人数")
    private Integer concernsNumber;

    @Schema(description = "开启状态")
    private Byte status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
