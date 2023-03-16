package cn.iocoder.yudao.module.information.controller.admin.careertalk.vo;

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
 * 宣讲会 Excel VO
 *
 * @author SZT
 */
@Data
public class CareertalkExcelVO {

    @ExcelProperty("ID")
    private Long id;

    @ExcelProperty("标题")
    private String title;

    @ExcelProperty("宣讲会名称")
    private String name;

    @ExcelProperty("宣讲地址")
    private String address;

    @ExcelProperty("主讲人")
    private String speaker;

    @ExcelProperty("主题")
    private String topic;

    @ExcelProperty("宣讲会主办方")
    private String organizer;

    @ExcelProperty("联系邮箱")
    private String email;

    @ExcelProperty("内容")
    private String text;

    @ExcelProperty("开始时间")
    private LocalDateTime startTime;

    @ExcelProperty("结束时间")
    private LocalDateTime endTime;

    @ExcelProperty("关注人数")
    private Integer concernsNumber;

    @ExcelProperty(value = "开启状态", converter = DictConvert.class)
    @DictFormat("common_status") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Byte status;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
