package cn.iocoder.yudao.module.member.controller.admin.user.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 用户登录表 Excel 导出 Request VO，参数和 MemberUserPageReqVO 是一致的")
@Data
public class MemberUserExportReqVO {

    @Schema(description = "用户昵称", example = "王五")
    private String nickname;

    @Schema(description = "头像")
    private String avatar;

    @Schema(description = "状态", example = "1")
    private Byte status;

    @Schema(description = "手机号")
    private String mobile;

    @Schema(description = "用户角色：0-游客 1-学生 2-导师 ")
    private Integer role;

    @Schema(description = "微信openid", example = "24967")
    private String openid;

    @Schema(description = "密码")
    private String password;

    @Schema(description = "注册 IP")
    private String registerIp;

    @Schema(description = "最后登录IP")
    private String loginIp;

    @Schema(description = "最后登录时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] loginDate;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
