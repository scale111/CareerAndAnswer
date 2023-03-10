package cn.iocoder.yudao.module.member.controller.admin.student.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 学生信息 Excel VO
 *
 * @author SZT
 */
@Data
public class StudentExcelVO {

    @ExcelProperty("学生ID")
    private Long id;

    @ExcelProperty("学生学号")
    private String studentNumber;

    @ExcelProperty("手机号")
    private String mobile;

    @ExcelProperty("姓名")
    private String name;

    @ExcelProperty("身份证号")
    private String idCard;

    @ExcelProperty("性别")
    private String gender;

    @ExcelProperty("学校")
    private String school;

    @ExcelProperty("学院")
    private String college;

    @ExcelProperty("专业")
    private String major;

    @ExcelProperty("就业状态")
    private String employmentStatus;

    @ExcelProperty("openid")
    private String openid;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
