package cn.iocoder.yudao.module.forum.controller.admin.post.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


/**
 * 帖子 Excel VO
 *
 * @author SZT
 */
@Data
public class ForumPostExcelVO {

    @ExcelProperty("帖子ID")
    private Long id;

    @ExcelProperty("发帖人ID")
    private Long userId;

    @ExcelProperty("发帖人昵称")
    private String userNickname;

    @ExcelProperty("发帖人头像")
    private String avatar;

    @ExcelProperty("标题")
    private String title;

    @ExcelProperty("内容")
    private String text;

    @ExcelProperty("评论数")
    private Integer commentNumber;

    @ExcelProperty("点赞数")
    private Integer likeNumber;

    @ExcelProperty("不喜欢数")
    private Integer unlikeNumber;

    @ExcelProperty(value = "置顶状态", converter = DictConvert.class)
    @DictFormat("sticky_status") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Byte sticky;

    @ExcelProperty(value = "审核状态", converter = DictConvert.class)
    @DictFormat("audit_status") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Byte auditStatus;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
