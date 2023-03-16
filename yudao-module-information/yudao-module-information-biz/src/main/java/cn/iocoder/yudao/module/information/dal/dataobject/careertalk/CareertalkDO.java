package cn.iocoder.yudao.module.information.dal.dataobject.careertalk;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 宣讲会 DO
 *
 * @author SZT
 */
@TableName("information_careertalk")
@KeySequence("information_careertalk_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CareertalkDO extends BaseDO {

    /**
     * ID
     */
    @TableId
    private Long id;
    /**
     * 标题
     */
    private String title;
    /**
     * 宣讲会名称
     */
    private String name;
    /**
     * 宣讲地址
     */
    private String address;
    /**
     * 主讲人
     */
    private String speaker;
    /**
     * 主题
     */
    private String topic;
    /**
     * 宣讲会主办方
     */
    private String organizer;
    /**
     * 联系邮箱
     */
    private String email;
    /**
     * 内容
     */
    private String text;
    /**
     * 开始时间
     */
    private LocalDateTime startTime;
    /**
     * 结束时间
     */
    private LocalDateTime endTime;
    /**
     * 关注人数
     */
    private Integer concernsNumber;
    /**
     * 开启状态
     *
     * 枚举 {@link TODO common_status 对应的类}
     */
    private Byte status;

}
