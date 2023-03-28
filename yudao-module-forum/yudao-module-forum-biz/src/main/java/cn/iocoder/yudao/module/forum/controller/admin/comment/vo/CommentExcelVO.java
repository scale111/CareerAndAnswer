package cn.iocoder.yudao.module.forum.controller.admin.comment.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;
import cn.iocoder.yudao.framework.excel.core.annotations.DictFormat;
import cn.iocoder.yudao.framework.excel.core.convert.DictConvert;


/**
 * 评论 Excel VO
 *
 * @author SZT
 */
@Data
public class CommentExcelVO {

    @ExcelProperty("评论ID")
    private Long id;

    @ExcelProperty("评论人ID")
    private Long commenterId;

    @ExcelProperty("评论人昵称")
    private String commenterNickname;

    @ExcelProperty("评论人头像")
    private String commenterAvatar;

    @ExcelProperty("被评论人ID")
    private Long reviewedId;

    @ExcelProperty("被评论人昵称")
    private String reviewedNickname;

    @ExcelProperty("被评论人头像")
    private String reviewedAvatar;

    @ExcelProperty("帖子ID")
    private Long postId;

    @ExcelProperty("评论等级")
    private Byte level;

    @ExcelProperty("评论上级ID")
    private Long superiorId;

    @ExcelProperty("评论内容")
    private String text;

    @ExcelProperty(value = "审核状态", converter = DictConvert.class)
    @DictFormat("audit_status") // TODO 代码优化：建议设置到对应的 XXXDictTypeConstants 枚举类中
    private Byte auditStatus;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
