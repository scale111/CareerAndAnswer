package cn.iocoder.yudao.module.information.controller.admin.jobfair.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 招聘会 Excel 导出 Request VO，参数和 JobfairPageReqVO 是一致的")
@Data
public class JobfairExportReqVO {

    @Schema(description = "标题")
    private String title;

    @Schema(description = "招聘会名称", example = "赵六")
    private String name;

    @Schema(description = "举办城市")
    private String city;

    @Schema(description = "举办地址")
    private String address;

    @Schema(description = "招聘会类型", example = "1")
    private Byte type;

    @Schema(description = "主办单位")
    private String hostUnit;

    @Schema(description = "承办单位")
    private String undertakingUnit;

    @Schema(description = "参展单位数")
    private Integer unitNumber;

    @Schema(description = "关注人次")
    private Integer concernsNumber;

    @Schema(description = "内容")
    private String text;

    @Schema(description = "开始时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] startTime;

    @Schema(description = "结束时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] endTime;

    @Schema(description = "开启状态", example = "1")
    private Byte status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
