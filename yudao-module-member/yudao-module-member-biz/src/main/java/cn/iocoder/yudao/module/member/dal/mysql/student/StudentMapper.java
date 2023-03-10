package cn.iocoder.yudao.module.member.dal.mysql.student;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.member.dal.dataobject.student.StudentDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.member.controller.admin.student.vo.*;

/**
 * 学生信息 Mapper
 *
 * @author SZT
 */
@Mapper
public interface StudentMapper extends BaseMapperX<StudentDO> {

    default PageResult<StudentDO> selectPage(StudentPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<StudentDO>()
                .eqIfPresent(StudentDO::getStudentNumber, reqVO.getStudentNumber())
                .eqIfPresent(StudentDO::getMobile, reqVO.getMobile())
                .likeIfPresent(StudentDO::getName, reqVO.getName())
                .eqIfPresent(StudentDO::getIdCard, reqVO.getIdCard())
                .eqIfPresent(StudentDO::getGender, reqVO.getGender())
                .eqIfPresent(StudentDO::getSchool, reqVO.getSchool())
                .eqIfPresent(StudentDO::getCollege, reqVO.getCollege())
                .eqIfPresent(StudentDO::getMajor, reqVO.getMajor())
                .eqIfPresent(StudentDO::getEmploymentStatus, reqVO.getEmploymentStatus())
                .eqIfPresent(StudentDO::getOpenid, reqVO.getOpenid())
                .betweenIfPresent(StudentDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(StudentDO::getId));
    }

    default List<StudentDO> selectList(StudentExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<StudentDO>()
                .eqIfPresent(StudentDO::getStudentNumber, reqVO.getStudentNumber())
                .eqIfPresent(StudentDO::getMobile, reqVO.getMobile())
                .likeIfPresent(StudentDO::getName, reqVO.getName())
                .eqIfPresent(StudentDO::getIdCard, reqVO.getIdCard())
                .eqIfPresent(StudentDO::getGender, reqVO.getGender())
                .eqIfPresent(StudentDO::getSchool, reqVO.getSchool())
                .eqIfPresent(StudentDO::getCollege, reqVO.getCollege())
                .eqIfPresent(StudentDO::getMajor, reqVO.getMajor())
                .eqIfPresent(StudentDO::getEmploymentStatus, reqVO.getEmploymentStatus())
                .eqIfPresent(StudentDO::getOpenid, reqVO.getOpenid())
                .betweenIfPresent(StudentDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(StudentDO::getId));
    }

}
