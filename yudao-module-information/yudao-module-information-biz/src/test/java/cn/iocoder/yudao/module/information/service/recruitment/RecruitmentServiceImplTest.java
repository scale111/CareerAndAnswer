//package cn.iocoder.yudao.module.information.service.recruitment;
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import javax.annotation.Resource;
//
//import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
//
//import cn.iocoder.yudao.module.information.controller.admin.recruitment.vo.*;
//import cn.iocoder.yudao.module.information.dal.dataobject.recruitment.RecruitmentDO;
//import cn.iocoder.yudao.module.information.dal.mysql.recruitment.RecruitmentMapper;
//import cn.iocoder.yudao.framework.common.pojo.PageResult;
//
//import javax.annotation.Resource;
//import org.springframework.context.annotation.Import;
//import java.util.*;
//import java.time.LocalDateTime;
//
//import static cn.hutool.core.util.RandomUtil.*;
//import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.buildBetweenTime;
//import static cn.iocoder.yudao.module.information.enums.ErrorCodeConstants.*;
//import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
//import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
//import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
//import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
///**
//* {@link RecruitmentServiceImpl} 的单元测试类
//*
//* @author SZT
//*/
//@Import(RecruitmentServiceImpl.class)
//public class RecruitmentServiceImplTest extends BaseDbUnitTest {
//
//    @Resource
//    private RecruitmentServiceImpl recruitmentService;
//
//    @Resource
//    private RecruitmentMapper recruitmentMapper;
//
//    @Test
//    public void testCreateRecruitment_success() {
//        // 准备参数
//        RecruitmentCreateReqVO reqVO = randomPojo(RecruitmentCreateReqVO.class);
//
//        // 调用
//        Long recruitmentId = recruitmentService.createRecruitment(reqVO);
//        // 断言
//        assertNotNull(recruitmentId);
//        // 校验记录的属性是否正确
//        RecruitmentDO recruitment = recruitmentMapper.selectById(recruitmentId);
//        assertPojoEquals(reqVO, recruitment);
//    }
//
//    @Test
//    public void testUpdateRecruitment_success() {
//        // mock 数据
//        RecruitmentDO dbRecruitment = randomPojo(RecruitmentDO.class);
//        recruitmentMapper.insert(dbRecruitment);// @Sql: 先插入出一条存在的数据
//        // 准备参数
//        RecruitmentUpdateReqVO reqVO = randomPojo(RecruitmentUpdateReqVO.class, o -> {
//            o.setId(dbRecruitment.getId()); // 设置更新的 ID
//        });
//
//        // 调用
//        recruitmentService.updateRecruitment(reqVO);
//        // 校验是否更新正确
//        RecruitmentDO recruitment = recruitmentMapper.selectById(reqVO.getId()); // 获取最新的
//        assertPojoEquals(reqVO, recruitment);
//    }
//
//    @Test
//    public void testUpdateRecruitment_notExists() {
//        // 准备参数
//        RecruitmentUpdateReqVO reqVO = randomPojo(RecruitmentUpdateReqVO.class);
//
//        // 调用, 并断言异常
//        assertServiceException(() -> recruitmentService.updateRecruitment(reqVO), RECRUITMENT_NOT_EXISTS);
//    }
//
//    @Test
//    public void testDeleteRecruitment_success() {
//        // mock 数据
//        RecruitmentDO dbRecruitment = randomPojo(RecruitmentDO.class);
//        recruitmentMapper.insert(dbRecruitment);// @Sql: 先插入出一条存在的数据
//        // 准备参数
//        Long id = dbRecruitment.getId();
//
//        // 调用
//        recruitmentService.deleteRecruitment(id);
//       // 校验数据不存在了
//       assertNull(recruitmentMapper.selectById(id));
//    }
//
//    @Test
//    public void testDeleteRecruitment_notExists() {
//        // 准备参数
//        Long id = randomLongId();
//
//        // 调用, 并断言异常
//        assertServiceException(() -> recruitmentService.deleteRecruitment(id), RECRUITMENT_NOT_EXISTS);
//    }
//
//    @Test
//    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
//    public void testGetRecruitmentPage() {
//       // mock 数据
//       RecruitmentDO dbRecruitment = randomPojo(RecruitmentDO.class, o -> { // 等会查询到
//           o.setTitle(null);
//           o.setPosition(null);
//           o.setType(null);
//           o.setCompany(null);
//           o.setAddress(null);
//           o.setRecruitsNumber(null);
//           o.setSalary(null);
//           o.setEducation(null);
//           o.setText(null);
//           o.setReleaseTime(null);
//           o.setExpirationTime(null);
//           o.setConcernsNumber(null);
//           o.setStatus(null);
//           o.setCreateTime(null);
//       });
//       recruitmentMapper.insert(dbRecruitment);
//       // 测试 title 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setTitle(null)));
//       // 测试 position 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setPosition(null)));
//       // 测试 type 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setType(null)));
//       // 测试 company 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setCompany(null)));
//       // 测试 address 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setAddress(null)));
//       // 测试 recruitsNumber 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setRecruitsNumber(null)));
//       // 测试 salary 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setSalary(null)));
//       // 测试 education 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setEducation(null)));
//       // 测试 text 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setText(null)));
//       // 测试 releaseTime 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setReleaseTime(null)));
//       // 测试 expirationTime 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setExpirationTime(null)));
//       // 测试 concernsNumber 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setConcernsNumber(null)));
//       // 测试 status 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setStatus(null)));
//       // 测试 createTime 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setCreateTime(null)));
//       // 准备参数
//       RecruitmentPageReqVO reqVO = new RecruitmentPageReqVO();
//       reqVO.setTitle(null);
//       reqVO.setPosition(null);
//       reqVO.setType(null);
//       reqVO.setCompany(null);
//       reqVO.setAddress(null);
//       reqVO.setRecruitsNumber(null);
//       reqVO.setSalary(null);
//       reqVO.setEducation(null);
//       reqVO.setText(null);
//       reqVO.setReleaseTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
//       reqVO.setExpirationTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
//       reqVO.setConcernsNumber(null);
//       reqVO.setStatus(null);
//       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
//
//       // 调用
//       PageResult<RecruitmentDO> pageResult = recruitmentService.getRecruitmentPage(reqVO);
//       // 断言
//       assertEquals(1, pageResult.getTotal());
//       assertEquals(1, pageResult.getList().size());
//       assertPojoEquals(dbRecruitment, pageResult.getList().get(0));
//    }
//
//    @Test
//    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
//    public void testGetRecruitmentList() {
//       // mock 数据
//       RecruitmentDO dbRecruitment = randomPojo(RecruitmentDO.class, o -> { // 等会查询到
//           o.setTitle(null);
//           o.setPosition(null);
//           o.setType(null);
//           o.setCompany(null);
//           o.setAddress(null);
//           o.setRecruitsNumber(null);
//           o.setSalary(null);
//           o.setEducation(null);
//           o.setText(null);
//           o.setReleaseTime(null);
//           o.setExpirationTime(null);
//           o.setConcernsNumber(null);
//           o.setStatus(null);
//           o.setCreateTime(null);
//       });
//       recruitmentMapper.insert(dbRecruitment);
//       // 测试 title 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setTitle(null)));
//       // 测试 position 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setPosition(null)));
//       // 测试 type 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setType(null)));
//       // 测试 company 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setCompany(null)));
//       // 测试 address 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setAddress(null)));
//       // 测试 recruitsNumber 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setRecruitsNumber(null)));
//       // 测试 salary 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setSalary(null)));
//       // 测试 education 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setEducation(null)));
//       // 测试 text 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setText(null)));
//       // 测试 releaseTime 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setReleaseTime(null)));
//       // 测试 expirationTime 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setExpirationTime(null)));
//       // 测试 concernsNumber 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setConcernsNumber(null)));
//       // 测试 status 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setStatus(null)));
//       // 测试 createTime 不匹配
//       recruitmentMapper.insert(cloneIgnoreId(dbRecruitment, o -> o.setCreateTime(null)));
//       // 准备参数
//       RecruitmentExportReqVO reqVO = new RecruitmentExportReqVO();
//       reqVO.setTitle(null);
//       reqVO.setPosition(null);
//       reqVO.setType(null);
//       reqVO.setCompany(null);
//       reqVO.setAddress(null);
//       reqVO.setRecruitsNumber(null);
//       reqVO.setSalary(null);
//       reqVO.setEducation(null);
//       reqVO.setText(null);
//       reqVO.setReleaseTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
//       reqVO.setExpirationTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
//       reqVO.setConcernsNumber(null);
//       reqVO.setStatus(null);
//       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
//
//       // 调用
//       List<RecruitmentDO> list = recruitmentService.getRecruitmentList(reqVO);
//       // 断言
//       assertEquals(1, list.size());
//       assertPojoEquals(dbRecruitment, list.get(0));
//    }
//
//}
