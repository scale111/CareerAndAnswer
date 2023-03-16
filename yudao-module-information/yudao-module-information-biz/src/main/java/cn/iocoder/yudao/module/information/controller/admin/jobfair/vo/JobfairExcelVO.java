package cn.iocoder.yudao.module.information.controller.admin.jobfair.vo;

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
 * 招聘会 Excel VO
 *
 * @author SZT
 */
@Data
public class JobfairExcelVO {

    @ExcelProperty("ID")
    private Long id;

    @ExcelProperty("标题")
    private String title;

    @ExcelProperty("招聘会名称")
    private String name;

    @ExcelProperty("举办城市")
    private String city;

    @ExcelProperty("举办地址")
    private String address;

    @ExcelProperty(value = "招聘会类型", converter = DictConvert.class)
    @DictFormat("information_jobfair_type") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Byte type;

    @ExcelProperty("主办单位")
    private String hostUnit;

    @ExcelProperty("承办单位")
    private String undertakingUnit;

    @ExcelProperty("参展单位数")
    private Integer unitNumber;

    @ExcelProperty("关注人次")
    private Integer concernsNumber;

    @ExcelProperty("内容")
    private String text;

    @ExcelProperty("开始时间")
    private LocalDateTime startTime;

    @ExcelProperty("结束时间")
    private LocalDateTime endTime;

    @ExcelProperty(value = "开启状态", converter = DictConvert.class)
    @DictFormat("common_status") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Byte status;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
