package cn.iocoder.yudao.module.member.service.mentor;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.member.controller.admin.mentor.vo.*;
import cn.iocoder.yudao.module.member.dal.dataobject.mentor.MentorDO;
import cn.iocoder.yudao.module.member.dal.mysql.mentor.MentorMapper;
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
* {@link MentorServiceImpl} 的单元测试类
*
* @author SZT
*/
@Import(MentorServiceImpl.class)
public class MentorServiceImplTest extends BaseDbUnitTest {

    @Resource
    private MentorServiceImpl mentorService;

    @Resource
    private MentorMapper mentorMapper;

    @Test
    public void testCreateMentor_success() {
        // 准备参数
        MentorCreateReqVO reqVO = randomPojo(MentorCreateReqVO.class);

        // 调用
        Long mentorId = mentorService.createMentor(reqVO);
        // 断言
        assertNotNull(mentorId);
        // 校验记录的属性是否正确
        MentorDO mentor = mentorMapper.selectById(mentorId);
        assertPojoEquals(reqVO, mentor);
    }

    @Test
    public void testUpdateMentor_success() {
        // mock 数据
        MentorDO dbMentor = randomPojo(MentorDO.class);
        mentorMapper.insert(dbMentor);// @Sql: 先插入出一条存在的数据
        // 准备参数
        MentorUpdateReqVO reqVO = randomPojo(MentorUpdateReqVO.class, o -> {
            o.setId(dbMentor.getId()); // 设置更新的 ID
        });

        // 调用
        mentorService.updateMentor(reqVO);
        // 校验是否更新正确
        MentorDO mentor = mentorMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, mentor);
    }

    @Test
    public void testUpdateMentor_notExists() {
        // 准备参数
        MentorUpdateReqVO reqVO = randomPojo(MentorUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> mentorService.updateMentor(reqVO), MENTOR_NOT_EXISTS);
    }

    @Test
    public void testDeleteMentor_success() {
        // mock 数据
        MentorDO dbMentor = randomPojo(MentorDO.class);
        mentorMapper.insert(dbMentor);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbMentor.getId();

        // 调用
        mentorService.deleteMentor(id);
       // 校验数据不存在了
       assertNull(mentorMapper.selectById(id));
    }

    @Test
    public void testDeleteMentor_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> mentorService.deleteMentor(id), MENTOR_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMentorPage() {
       // mock 数据
       MentorDO dbMentor = randomPojo(MentorDO.class, o -> { // 等会查询到
           o.setJobNumber(null);
           o.setMobile(null);
           o.setName(null);
           o.setPhoto(null);
           o.setGender(null);
           o.setSchool(null);
           o.setCollege(null);
           o.setMajor(null);
           o.setBio(null);
           o.setDio(null);
           o.setOpenid(null);
           o.setCreateTime(null);
       });
       mentorMapper.insert(dbMentor);
       // 测试 jobNumber 不匹配
       mentorMapper.insert(cloneIgnoreId(dbMentor, o -> o.setJobNumber(null)));
       // 测试 mobile 不匹配
       mentorMapper.insert(cloneIgnoreId(dbMentor, o -> o.setMobile(null)));
       // 测试 name 不匹配
       mentorMapper.insert(cloneIgnoreId(dbMentor, o -> o.setName(null)));
       // 测试 photo 不匹配
       mentorMapper.insert(cloneIgnoreId(dbMentor, o -> o.setPhoto(null)));
       // 测试 gender 不匹配
       mentorMapper.insert(cloneIgnoreId(dbMentor, o -> o.setGender(null)));
       // 测试 school 不匹配
       mentorMapper.insert(cloneIgnoreId(dbMentor, o -> o.setSchool(null)));
       // 测试 college 不匹配
       mentorMapper.insert(cloneIgnoreId(dbMentor, o -> o.setCollege(null)));
       // 测试 major 不匹配
       mentorMapper.insert(cloneIgnoreId(dbMentor, o -> o.setMajor(null)));
       // 测试 bio 不匹配
       mentorMapper.insert(cloneIgnoreId(dbMentor, o -> o.setBio(null)));
       // 测试 dio 不匹配
       mentorMapper.insert(cloneIgnoreId(dbMentor, o -> o.setDio(null)));
       // 测试 openid 不匹配
       mentorMapper.insert(cloneIgnoreId(dbMentor, o -> o.setOpenid(null)));
       // 测试 createTime 不匹配
       mentorMapper.insert(cloneIgnoreId(dbMentor, o -> o.setCreateTime(null)));
       // 准备参数
       MentorPageReqVO reqVO = new MentorPageReqVO();
       reqVO.setJobNumber(null);
       reqVO.setMobile(null);
       reqVO.setName(null);
       reqVO.setPhoto(null);
       reqVO.setGender(null);
       reqVO.setSchool(null);
       reqVO.setCollege(null);
       reqVO.setMajor(null);
       reqVO.setBio(null);
       reqVO.setDio(null);
       reqVO.setOpenid(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<MentorDO> pageResult = mentorService.getMentorPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbMentor, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetMentorList() {
       // mock 数据
       MentorDO dbMentor = randomPojo(MentorDO.class, o -> { // 等会查询到
           o.setJobNumber(null);
           o.setMobile(null);
           o.setName(null);
           o.setPhoto(null);
           o.setGender(null);
           o.setSchool(null);
           o.setCollege(null);
           o.setMajor(null);
           o.setBio(null);
           o.setDio(null);
           o.setOpenid(null);
           o.setCreateTime(null);
       });
       mentorMapper.insert(dbMentor);
       // 测试 jobNumber 不匹配
       mentorMapper.insert(cloneIgnoreId(dbMentor, o -> o.setJobNumber(null)));
       // 测试 mobile 不匹配
       mentorMapper.insert(cloneIgnoreId(dbMentor, o -> o.setMobile(null)));
       // 测试 name 不匹配
       mentorMapper.insert(cloneIgnoreId(dbMentor, o -> o.setName(null)));
       // 测试 photo 不匹配
       mentorMapper.insert(cloneIgnoreId(dbMentor, o -> o.setPhoto(null)));
       // 测试 gender 不匹配
       mentorMapper.insert(cloneIgnoreId(dbMentor, o -> o.setGender(null)));
       // 测试 school 不匹配
       mentorMapper.insert(cloneIgnoreId(dbMentor, o -> o.setSchool(null)));
       // 测试 college 不匹配
       mentorMapper.insert(cloneIgnoreId(dbMentor, o -> o.setCollege(null)));
       // 测试 major 不匹配
       mentorMapper.insert(cloneIgnoreId(dbMentor, o -> o.setMajor(null)));
       // 测试 bio 不匹配
       mentorMapper.insert(cloneIgnoreId(dbMentor, o -> o.setBio(null)));
       // 测试 dio 不匹配
       mentorMapper.insert(cloneIgnoreId(dbMentor, o -> o.setDio(null)));
       // 测试 openid 不匹配
       mentorMapper.insert(cloneIgnoreId(dbMentor, o -> o.setOpenid(null)));
       // 测试 createTime 不匹配
       mentorMapper.insert(cloneIgnoreId(dbMentor, o -> o.setCreateTime(null)));
       // 准备参数
       MentorExportReqVO reqVO = new MentorExportReqVO();
       reqVO.setJobNumber(null);
       reqVO.setMobile(null);
       reqVO.setName(null);
       reqVO.setPhoto(null);
       reqVO.setGender(null);
       reqVO.setSchool(null);
       reqVO.setCollege(null);
       reqVO.setMajor(null);
       reqVO.setBio(null);
       reqVO.setDio(null);
       reqVO.setOpenid(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<MentorDO> list = mentorService.getMentorList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbMentor, list.get(0));
    }

}
