package cn.iocoder.yudao.module.forum.dal.dataobject.comment;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 评论 DO
 *
 * @author SZT
 */
@TableName("forum_comment")
@KeySequence("forum_comment_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDO extends BaseDO {

    /**
     * 评论ID
     */
    @TableId
    private Long id;
    /**
     * 评论人ID
     */
    private Long commenterId;
    /**
     * 评论人昵称
     */
    private String commenterNickname;
    /**
     * 评论人头像
     */
    private String commenterAvatar;
    /**
     * 被评论人ID
     */
    private Long reviewedId;
    /**
     * 被评论人昵称
     */
    private String reviewedNickname;
    /**
     * 被评论人头像
     */
    private String reviewedAvatar;
    /**
     * 帖子ID
     */
    private Long postId;
    /**
     * 评论等级
     */
    private Byte level;
    /**
     * 评论上级ID
     */
    private Long superiorId;
    /**
     * 评论内容
     */
    private String text;
    /**
     * 审核状态
     *
     * 枚举 {@link TODO audit_status 对应的类}
     */
    private Byte auditStatus;

}
