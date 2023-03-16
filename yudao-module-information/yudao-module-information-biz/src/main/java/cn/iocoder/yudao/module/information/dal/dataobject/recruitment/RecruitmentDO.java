package cn.iocoder.yudao.module.information.dal.dataobject.recruitment;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 招聘信息 DO
 *
 * @author SZT
 */
@TableName("information_recruitment")
@KeySequence("information_recruitment_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RecruitmentDO extends BaseDO {

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
     * 职位
     */
    private String position;
    /**
     * 招聘类型
     *
     * 枚举 {@link TODO information_recruitment_type 对应的类}
     */
    private Byte type;
    /**
     * 公司名
     */
    private String company;
    /**
     * 工作地点
     */
    private String address;
    /**
     * 招聘人数
     */
    private Integer recruitsNumber;
    /**
     * 薪资
     */
    private String salary;
    /**
     * 学历要求
     *
     * 枚举 {@link TODO information_recruitment_education 对应的类}
     */
    private Byte education;
    /**
     * 内容
     */
    private String text;
    /**
     * 发布时间
     */
    private LocalDateTime releaseTime;
    /**
     * 过期时间
     */
    private LocalDateTime expirationTime;
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
