package cn.iocoder.yudao.module.forum.controller.app.post.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
* 帖子 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class AppForumPostBaseVO {

    @Schema(description = "发帖人ID", required = true, example = "18620")
    @NotNull(message = "发帖人ID不能为空")
    private Long userId;

    @Schema(description = "发帖人昵称", required = true, example = "王五")
    @NotNull(message = "发帖人昵称不能为空")
    private String userNickname;

    @Schema(description = "发帖人头像")
    private String avatar;

    @Schema(description = "标题")
    private String title;

    @Schema(description = "内容", required = true)
    @NotNull(message = "内容不能为空")
    private String text;

    @Schema(description = "评论数", required = true)
    private Integer commentNumber;

    @Schema(description = "点赞数", required = true)
    private Integer likeNumber;

    @Schema(description = "不喜欢数", required = true)
    private Integer unlikeNumber;

    @Schema(description = "置顶状态", required = true, example = "0")
    private Byte sticky;

    @Schema(description = "审核状态", required = true, example = "2")
    private Byte auditStatus;

}
