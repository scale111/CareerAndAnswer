package cn.iocoder.yudao.module.member.controller.admin.mentor.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 导师信息 Excel VO
 *
 * @author SZT
 */
@Data
public class MentorExcelVO {

    @ExcelProperty("导师ID")
    private Long id;

    @ExcelProperty("导师工号")
    private String jobNumber;

    @ExcelProperty("手机号")
    private String mobile;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("照片")
    private String photo;

    @ExcelProperty("性别")
    private String gender;

    @ExcelProperty("学校")
    private String school;

    @ExcelProperty("学院")
    private String college;

    @ExcelProperty("专业")
    private String major;

    @ExcelProperty("导师简介")
    private String bio;

    @ExcelProperty("详细信息")
    private String dio;

    @ExcelProperty("openid")
    private String openid;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
