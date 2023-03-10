package cn.iocoder.yudao.module.member.dal.dataobject.mentor;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 导师信息 DO
 *
 * @author SZT
 */
@TableName("member_mentor")
@KeySequence("member_mentor_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MentorDO extends BaseDO {

    /**
     * 导师ID
     */
    @TableId
    private Long id;
    /**
     * 导师工号
     */
    private String jobNumber;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 姓名
     */
    private String name;
    /**
     * 照片
     */
    private String photo;
    /**
     * 性别
     */
    private String gender;
    /**
     * 学校
     */
    private String school;
    /**
     * 学院
     */
    private String college;
    /**
     * 专业
     */
    private String major;
    /**
     * 导师简介
     */
    private String bio;
    /**
     * 详细信息
     */
    private String dio;
    /**
     * openid
     */
    private String openid;

}
