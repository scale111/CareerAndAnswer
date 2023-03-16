package cn.iocoder.yudao.module.information.controller.admin.recruitment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


/**
 * 招聘信息 Excel VO
 *
 * @author SZT
 */
@Data
public class RecruitmentExcelVO {

    @ExcelProperty("ID")
    private Long id;

    @ExcelProperty("标题")
    private String title;

    @ExcelProperty("职位")
    private String position;

    @ExcelProperty(value = "招聘类型", converter = DictConvert.class)
    @DictFormat("information_recruitment_type") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Byte type;

    @ExcelProperty("公司名")
    private String company;

    @ExcelProperty("工作地点")
    private String address;

    @ExcelProperty("招聘人数")
    private Integer recruitsNumber;

    @ExcelProperty("薪资")
    private String salary;

    @ExcelProperty(value = "学历要求", converter = DictConvert.class)
    @DictFormat("information_recruitment_education") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Byte education;

    @ExcelProperty("内容")
    private String text;

    @ExcelProperty("发布时间")
    private LocalDateTime releaseTime;

    @ExcelProperty("过期时间")
    private LocalDateTime expirationTime;

    @ExcelProperty("关注人数")
    private Integer concernsNumber;

    @ExcelProperty(value = "开启状态", converter = DictConvert.class)
    @DictFormat("common_status") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Byte status;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
