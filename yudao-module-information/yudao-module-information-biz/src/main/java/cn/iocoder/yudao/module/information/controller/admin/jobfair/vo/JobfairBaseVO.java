package cn.iocoder.yudao.module.information.controller.admin.jobfair.vo;

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
* 招聘会 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class JobfairBaseVO {

    @Schema(description = "标题", required = true)
    @NotNull(message = "标题不能为空")
    private String title;

    @Schema(description = "招聘会名称", required = true, example = "赵六")
    @NotNull(message = "招聘会名称不能为空")
    private String name;

    @Schema(description = "举办城市", required = true)
    @NotNull(message = "举办城市不能为空")
    private String city;

    @Schema(description = "举办地址", required = true)
    @NotNull(message = "举办地址不能为空")
    private String address;

    @Schema(description = "招聘会类型", required = true, example = "1")
    @NotNull(message = "招聘会类型不能为空")
    private Byte type;

    @Schema(description = "主办单位")
    private String hostUnit;

    @Schema(description = "承办单位")
    private String undertakingUnit;

    @Schema(description = "参展单位数")
    private Integer unitNumber;

    @Schema(description = "关注人次")
    private Integer concernsNumber;

    @Schema(description = "内容", required = true)
    @NotNull(message = "内容不能为空")
    private String text;

    @Schema(description = "开始时间", required = true)
    @NotNull(message = "开始时间不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime startTime;

    @Schema(description = "结束时间", required = true)
    @NotNull(message = "结束时间不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime endTime;

    @Schema(description = "开启状态", example = "1")
    private Byte status;

}
