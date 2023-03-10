package cn.iocoder.yudao.module.member.convert.student;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.member.controller.admin.student.vo.*;
import cn.iocoder.yudao.module.member.dal.dataobject.student.StudentDO;

/**
 * 学生信息 Convert
 *
 * @author SZT
 */
@Mapper
public interface StudentConvert {

    StudentConvert INSTANCE = Mappers.getMapper(StudentConvert.class);

    StudentDO convert(StudentCreateReqVO bean);

    StudentDO convert(StudentUpdateReqVO bean);

    StudentRespVO convert(StudentDO bean);

    List<StudentRespVO> convertList(List<StudentDO> list);

    PageResult<StudentRespVO> convertPage(PageResult<StudentDO> page);

    List<StudentExcelVO> convertList02(List<StudentDO> list);

}
