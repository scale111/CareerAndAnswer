package cn.iocoder.yudao.module.member.service.student;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.member.controller.admin.student.vo.*;
import cn.iocoder.yudao.module.member.dal.dataobject.student.StudentDO;
import cn.iocoder.yudao.module.member.dal.mysql.student.StudentMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.buildBetweenTime;
import static cn.iocoder.yudao.module.member.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link StudentServiceImpl} 的单元测试类
*
* @author SZT
*/
@Import(StudentServiceImpl.class)
public class StudentServiceImplTest extends BaseDbUnitTest {

    @Resource
    private StudentServiceImpl studentService;

    @Resource
    private StudentMapper studentMapper;

    @Test
    public void testCreateStudent_success() {
        // 准备参数
        StudentCreateReqVO reqVO = randomPojo(StudentCreateReqVO.class);

        // 调用
        Long studentId = studentService.createStudent(reqVO);
        // 断言
        assertNotNull(studentId);
        // 校验记录的属性是否正确
        StudentDO student = studentMapper.selectById(studentId);
        assertPojoEquals(reqVO, student);
    }

    @Test
    public void testUpdateStudent_success() {
        // mock 数据
        StudentDO dbStudent = randomPojo(StudentDO.class);
        studentMapper.insert(dbStudent);// @Sql: 先插入出一条存在的数据
        // 准备参数
        StudentUpdateReqVO reqVO = randomPojo(StudentUpdateReqVO.class, o -> {
            o.setId(dbStudent.getId()); // 设置更新的 ID
        });

        // 调用
        studentService.updateStudent(reqVO);
        // 校验是否更新正确
        StudentDO student = studentMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, student);
    }

    @Test
    public void testUpdateStudent_notExists() {
        // 准备参数
        StudentUpdateReqVO reqVO = randomPojo(StudentUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> studentService.updateStudent(reqVO), STUDENT_NOT_EXISTS);
    }

    @Test
    public void testDeleteStudent_success() {
        // mock 数据
        StudentDO dbStudent = randomPojo(StudentDO.class);
        studentMapper.insert(dbStudent);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbStudent.getId();

        // 调用
        studentService.deleteStudent(id);
       // 校验数据不存在了
       assertNull(studentMapper.selectById(id));
    }

    @Test
    public void testDeleteStudent_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> studentService.deleteStudent(id), STUDENT_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetStudentPage() {
       // mock 数据
       StudentDO dbStudent = randomPojo(StudentDO.class, o -> { // 等会查询到
           o.setStudentNumber(null);
           o.setMobile(null);
           o.setName(null);
           o.setIdCard(null);
           o.setGender(null);
           o.setSchool(null);
           o.setCollege(null);
           o.setMajor(null);
           o.setEmploymentStatus(null);
           o.setOpenid(null);
           o.setCreateTime(null);
       });
       studentMapper.insert(dbStudent);
       // 测试 studentNumber 不匹配
       studentMapper.insert(cloneIgnoreId(dbStudent, o -> o.setStudentNumber(null)));
       // 测试 mobile 不匹配
       studentMapper.insert(cloneIgnoreId(dbStudent, o -> o.setMobile(null)));
       // 测试 name 不匹配
       studentMapper.insert(cloneIgnoreId(dbStudent, o -> o.setName(null)));
       // 测试 idCard 不匹配
       studentMapper.insert(cloneIgnoreId(dbStudent, o -> o.setIdCard(null)));
       // 测试 gender 不匹配
       studentMapper.insert(cloneIgnoreId(dbStudent, o -> o.setGender(null)));
       // 测试 school 不匹配
       studentMapper.insert(cloneIgnoreId(dbStudent, o -> o.setSchool(null)));
       // 测试 college 不匹配
       studentMapper.insert(cloneIgnoreId(dbStudent, o -> o.setCollege(null)));
       // 测试 major 不匹配
       studentMapper.insert(cloneIgnoreId(dbStudent, o -> o.setMajor(null)));
       // 测试 employmentStatus 不匹配
       studentMapper.insert(cloneIgnoreId(dbStudent, o -> o.setEmploymentStatus(null)));
       // 测试 openid 不匹配
       studentMapper.insert(cloneIgnoreId(dbStudent, o -> o.setOpenid(null)));
       // 测试 createTime 不匹配
       studentMapper.insert(cloneIgnoreId(dbStudent, o -> o.setCreateTime(null)));
       // 准备参数
       StudentPageReqVO reqVO = new StudentPageReqVO();
       reqVO.setStudentNumber(null);
       reqVO.setMobile(null);
       reqVO.setName(null);
       reqVO.setIdCard(null);
       reqVO.setGender(null);
       reqVO.setSchool(null);
       reqVO.setCollege(null);
       reqVO.setMajor(null);
       reqVO.setEmploymentStatus(null);
       reqVO.setOpenid(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<StudentDO> pageResult = studentService.getStudentPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbStudent, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetStudentList() {
       // mock 数据
       StudentDO dbStudent = randomPojo(StudentDO.class, o -> { // 等会查询到
           o.setStudentNumber(null);
           o.setMobile(null);
           o.setName(null);
           o.setIdCard(null);
           o.setGender(null);
           o.setSchool(null);
           o.setCollege(null);
           o.setMajor(null);
           o.setEmploymentStatus(null);
           o.setOpenid(null);
           o.setCreateTime(null);
       });
       studentMapper.insert(dbStudent);
       // 测试 studentNumber 不匹配
       studentMapper.insert(cloneIgnoreId(dbStudent, o -> o.setStudentNumber(null)));
       // 测试 mobile 不匹配
       studentMapper.insert(cloneIgnoreId(dbStudent, o -> o.setMobile(null)));
       // 测试 name 不匹配
       studentMapper.insert(cloneIgnoreId(dbStudent, o -> o.setName(null)));
       // 测试 idCard 不匹配
       studentMapper.insert(cloneIgnoreId(dbStudent, o -> o.setIdCard(null)));
       // 测试 gender 不匹配
       studentMapper.insert(cloneIgnoreId(dbStudent, o -> o.setGender(null)));
       // 测试 school 不匹配
       studentMapper.insert(cloneIgnoreId(dbStudent, o -> o.setSchool(null)));
       // 测试 college 不匹配
       studentMapper.insert(cloneIgnoreId(dbStudent, o -> o.setCollege(null)));
       // 测试 major 不匹配
       studentMapper.insert(cloneIgnoreId(dbStudent, o -> o.setMajor(null)));
       // 测试 employmentStatus 不匹配
       studentMapper.insert(cloneIgnoreId(dbStudent, o -> o.setEmploymentStatus(null)));
       // 测试 openid 不匹配
       studentMapper.insert(cloneIgnoreId(dbStudent, o -> o.setOpenid(null)));
       // 测试 createTime 不匹配
       studentMapper.insert(cloneIgnoreId(dbStudent, o -> o.setCreateTime(null)));
       // 准备参数
       StudentExportReqVO reqVO = new StudentExportReqVO();
       reqVO.setStudentNumber(null);
       reqVO.setMobile(null);
       reqVO.setName(null);
       reqVO.setIdCard(null);
       reqVO.setGender(null);
       reqVO.setSchool(null);
       reqVO.setCollege(null);
       reqVO.setMajor(null);
       reqVO.setEmploymentStatus(null);
       reqVO.setOpenid(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<StudentDO> list = studentService.getStudentList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbStudent, list.get(0));
    }

}
