package cn.iocoder.yudao.module.information.dal.dataobject.jobfair;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 招聘会 DO
 *
 * @author SZT
 */
@TableName("information_jobfair")
@KeySequence("information_jobfair_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JobfairDO extends BaseDO {

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
     * 招聘会名称
     */
    private String name;
    /**
     * 举办城市
     */
    private String city;
    /**
     * 举办地址
     */
    private String address;
    /**
     * 招聘会类型
     *
     * 枚举 {@link TODO information_jobfair_type 对应的类}
     */
    private Byte type;
    /**
     * 主办单位
     */
    private String hostUnit;
    /**
     * 承办单位
     */
    private String undertakingUnit;
    /**
     * 参展单位数
     */
    private Integer unitNumber;
    /**
     * 关注人次
     */
    private Integer concernsNumber;
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
     * 开启状态
     *
     * 枚举 {@link TODO common_status 对应的类}
     */
    private Byte status;

}
