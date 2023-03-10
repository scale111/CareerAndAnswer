package cn.iocoder.yudao.module.member.controller.admin.user.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


/**
 * 用户登录表 Excel VO
 *
 * @author SZT
 */
@Data
public class MemberUserExcelVO {

    @ExcelProperty("编号")
    private Long id;

    @ExcelProperty("用户昵称")
    private String nickname;

    @ExcelProperty("头像")
    private String avatar;

    @ExcelProperty(value = "状态", converter = DictConvert.class)
    @DictFormat("common_status") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Byte status;

    @ExcelProperty("手机号")
    private String mobile;

    @ExcelProperty("用户角色：0-游客 1-学生 2-导师 ")
    private Integer role;

    @ExcelProperty("微信openid")
    private String openid;

    @ExcelProperty("密码")
    private String password;

    @ExcelProperty("注册 IP")
    private String registerIp;

    @ExcelProperty("最后登录IP")
    private String loginIp;

    @ExcelProperty("最后登录时间")
    private LocalDateTime loginDate;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
