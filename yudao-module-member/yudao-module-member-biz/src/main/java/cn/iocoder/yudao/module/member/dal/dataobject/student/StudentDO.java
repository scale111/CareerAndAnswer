package cn.iocoder.yudao.module.member.dal.dataobject.student;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 学生信息 DO
 *
 * @author SZT
 */
@TableName("member_student")
@KeySequence("member_student_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDO extends BaseDO {

    /**
     * 学生ID
     */
    @TableId
    private Long id;
    /**
     * 学生学号
     */
    private String studentNumber;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 姓名
     */
    private String name;
    /**
     * 身份证号
     */
    private String idCard;
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
     * 就业状态
     */
    private String employmentStatus;
    /**
     * openid
     */
    private String openid;

}
