package cn.iocoder.yudao.module.forum.dal.dataobject.post;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 帖子 DO
 *
 * @author SZT
 */
@TableName("forum_post")
@KeySequence("forum_post_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ForumPostDO extends BaseDO {

    /**
     * 帖子ID
     */
    @TableId
    private Long id;
    /**
     * 发帖人ID
     */
    private Long userId;
    /**
     * 发帖人昵称
     */
    private String userNickname;
    /**
     * 发帖人头像
     */
    private String avatar;
    /**
     * 标题
     */
    private String title;
    /**
     * 内容
     */
    private String text;
    /**
     * 评论数
     */
    private Integer commentNumber;
    /**
     * 点赞数
     */
    private Integer likeNumber;
    /**
     * 不喜欢数
     */
    private Integer unlikeNumber;
    /**
     * 置顶状态
     *
     * 枚举 {@link TODO sticky_status 对应的类}
     */
    private Byte sticky;
    /**
     * 审核状态
     *
     * 枚举 {@link TODO audit_status 对应的类}
     */
    private Byte auditStatus;

}
