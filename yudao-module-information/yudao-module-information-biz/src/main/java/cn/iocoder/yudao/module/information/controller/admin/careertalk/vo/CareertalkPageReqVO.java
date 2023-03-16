package cn.iocoder.yudao.module.information.controller.admin.careertalk.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 宣讲会分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CareertalkPageReqVO extends PageParam {

    @Schema(description = "标题")
    private String title;

    @Schema(description = "宣讲会名称", example = "芋艿")
    private String name;

    @Schema(description = "宣讲地址")
    private String address;

    @Schema(description = "主讲人")
    private String speaker;

    @Schema(description = "主题")
    private String topic;

    @Schema(description = "宣讲会主办方")
    private String organizer;

    @Schema(description = "联系邮箱")
    private String email;

    @Schema(description = "内容")
    private String text;

    @Schema(description = "开始时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] startTime;

    @Schema(description = "结束时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] endTime;

    @Schema(description = "关注人数")
    private Integer concernsNumber;

    @Schema(description = "开启状态", example = "1")
    private Byte status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
