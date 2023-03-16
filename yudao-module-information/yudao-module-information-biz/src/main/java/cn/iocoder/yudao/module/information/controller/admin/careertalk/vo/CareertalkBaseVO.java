package cn.iocoder.yudao.module.information.controller.admin.careertalk.vo;

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
* 宣讲会 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class CareertalkBaseVO {

    @Schema(description = "标题", required = true)
    @NotNull(message = "标题不能为空")
    private String title;

    @Schema(description = "宣讲会名称", required = true, example = "芋艿")
    @NotNull(message = "宣讲会名称不能为空")
    private String name;

    @Schema(description = "宣讲地址", required = true)
    @NotNull(message = "宣讲地址不能为空")
    private String address;

    @Schema(description = "主讲人", required = true)
    @NotNull(message = "主讲人不能为空")
    private String speaker;

    @Schema(description = "主题", required = true)
    @NotNull(message = "主题不能为空")
    private String topic;

    @Schema(description = "宣讲会主办方")
    private String organizer;

    @Schema(description = "联系邮箱")
    private String email;

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

    @Schema(description = "关注人数")
    private Integer concernsNumber;

    @Schema(description = "开启状态", example = "1")
    private Byte status;

}
