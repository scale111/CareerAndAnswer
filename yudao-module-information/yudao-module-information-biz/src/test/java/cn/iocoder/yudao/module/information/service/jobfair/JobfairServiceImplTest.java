//package cn.iocoder.yudao.module.information.service.jobfair;
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import javax.annotation.Resource;
//
//import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
//
//import cn.iocoder.yudao.module.information.controller.admin.jobfair.vo.*;
//import cn.iocoder.yudao.module.information.dal.dataobject.jobfair.JobfairDO;
//import cn.iocoder.yudao.module.information.dal.mysql.jobfair.JobfairMapper;
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
//* {@link JobfairServiceImpl} 的单元测试类
//*
//* @author SZT
//*/
//@Import(JobfairServiceImpl.class)
//public class JobfairServiceImplTest extends BaseDbUnitTest {
//
//    @Resource
//    private JobfairServiceImpl jobfairService;
//
//    @Resource
//    private JobfairMapper jobfairMapper;
//
//    @Test
//    public void testCreateJobfair_success() {
//        // 准备参数
//        JobfairCreateReqVO reqVO = randomPojo(JobfairCreateReqVO.class);
//
//        // 调用
//        Long jobfairId = jobfairService.createJobfair(reqVO);
//        // 断言
//        assertNotNull(jobfairId);
//        // 校验记录的属性是否正确
//        JobfairDO jobfair = jobfairMapper.selectById(jobfairId);
//        assertPojoEquals(reqVO, jobfair);
//    }
//
//    @Test
//    public void testUpdateJobfair_success() {
//        // mock 数据
//        JobfairDO dbJobfair = randomPojo(JobfairDO.class);
//        jobfairMapper.insert(dbJobfair);// @Sql: 先插入出一条存在的数据
//        // 准备参数
//        JobfairUpdateReqVO reqVO = randomPojo(JobfairUpdateReqVO.class, o -> {
//            o.setId(dbJobfair.getId()); // 设置更新的 ID
//        });
//
//        // 调用
//        jobfairService.updateJobfair(reqVO);
//        // 校验是否更新正确
//        JobfairDO jobfair = jobfairMapper.selectById(reqVO.getId()); // 获取最新的
//        assertPojoEquals(reqVO, jobfair);
//    }
//
//    @Test
//    public void testUpdateJobfair_notExists() {
//        // 准备参数
//        JobfairUpdateReqVO reqVO = randomPojo(JobfairUpdateReqVO.class);
//
//        // 调用, 并断言异常
//        assertServiceException(() -> jobfairService.updateJobfair(reqVO), JOBFAIR_NOT_EXISTS);
//    }
//
//    @Test
//    public void testDeleteJobfair_success() {
//        // mock 数据
//        JobfairDO dbJobfair = randomPojo(JobfairDO.class);
//        jobfairMapper.insert(dbJobfair);// @Sql: 先插入出一条存在的数据
//        // 准备参数
//        Long id = dbJobfair.getId();
//
//        // 调用
//        jobfairService.deleteJobfair(id);
//       // 校验数据不存在了
//       assertNull(jobfairMapper.selectById(id));
//    }
//
//    @Test
//    public void testDeleteJobfair_notExists() {
//        // 准备参数
//        Long id = randomLongId();
//
//        // 调用, 并断言异常
//        assertServiceException(() -> jobfairService.deleteJobfair(id), JOBFAIR_NOT_EXISTS);
//    }
//
//    @Test
//    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
//    public void testGetJobfairPage() {
//       // mock 数据
//       JobfairDO dbJobfair = randomPojo(JobfairDO.class, o -> { // 等会查询到
//           o.setTitle(null);
//           o.setName(null);
//           o.setCity(null);
//           o.setAddress(null);
//           o.setType(null);
//           o.setHostUnit(null);
//           o.setUndertakingUnit(null);
//           o.setUnitNumber(null);
//           o.setConcernsNumber(null);
//           o.setText(null);
//           o.setStartTime(null);
//           o.setEndTime(null);
//           o.setStatus(null);
//           o.setCreateTime(null);
//       });
//       jobfairMapper.insert(dbJobfair);
//       // 测试 title 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setTitle(null)));
//       // 测试 name 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setName(null)));
//       // 测试 city 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setCity(null)));
//       // 测试 address 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setAddress(null)));
//       // 测试 type 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setType(null)));
//       // 测试 hostUnit 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setHostUnit(null)));
//       // 测试 undertakingUnit 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setUndertakingUnit(null)));
//       // 测试 unitNumber 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setUnitNumber(null)));
//       // 测试 concernsNumber 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setConcernsNumber(null)));
//       // 测试 text 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setText(null)));
//       // 测试 startTime 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setStartTime(null)));
//       // 测试 endTime 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setEndTime(null)));
//       // 测试 status 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setStatus(null)));
//       // 测试 createTime 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setCreateTime(null)));
//       // 准备参数
//       JobfairPageReqVO reqVO = new JobfairPageReqVO();
//       reqVO.setTitle(null);
//       reqVO.setName(null);
//       reqVO.setCity(null);
//       reqVO.setAddress(null);
//       reqVO.setType(null);
//       reqVO.setHostUnit(null);
//       reqVO.setUndertakingUnit(null);
//       reqVO.setUnitNumber(null);
//       reqVO.setConcernsNumber(null);
//       reqVO.setText(null);
//       reqVO.setStartTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
//       reqVO.setEndTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
//       reqVO.setStatus(null);
//       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
//
//       // 调用
//       PageResult<JobfairDO> pageResult = jobfairService.getJobfairPage(reqVO);
//       // 断言
//       assertEquals(1, pageResult.getTotal());
//       assertEquals(1, pageResult.getList().size());
//       assertPojoEquals(dbJobfair, pageResult.getList().get(0));
//    }
//
//    @Test
//    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
//    public void testGetJobfairList() {
//       // mock 数据
//       JobfairDO dbJobfair = randomPojo(JobfairDO.class, o -> { // 等会查询到
//           o.setTitle(null);
//           o.setName(null);
//           o.setCity(null);
//           o.setAddress(null);
//           o.setType(null);
//           o.setHostUnit(null);
//           o.setUndertakingUnit(null);
//           o.setUnitNumber(null);
//           o.setConcernsNumber(null);
//           o.setText(null);
//           o.setStartTime(null);
//           o.setEndTime(null);
//           o.setStatus(null);
//           o.setCreateTime(null);
//       });
//       jobfairMapper.insert(dbJobfair);
//       // 测试 title 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setTitle(null)));
//       // 测试 name 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setName(null)));
//       // 测试 city 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setCity(null)));
//       // 测试 address 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setAddress(null)));
//       // 测试 type 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setType(null)));
//       // 测试 hostUnit 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setHostUnit(null)));
//       // 测试 undertakingUnit 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setUndertakingUnit(null)));
//       // 测试 unitNumber 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setUnitNumber(null)));
//       // 测试 concernsNumber 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setConcernsNumber(null)));
//       // 测试 text 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setText(null)));
//       // 测试 startTime 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setStartTime(null)));
//       // 测试 endTime 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setEndTime(null)));
//       // 测试 status 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setStatus(null)));
//       // 测试 createTime 不匹配
//       jobfairMapper.insert(cloneIgnoreId(dbJobfair, o -> o.setCreateTime(null)));
//       // 准备参数
//       JobfairExportReqVO reqVO = new JobfairExportReqVO();
//       reqVO.setTitle(null);
//       reqVO.setName(null);
//       reqVO.setCity(null);
//       reqVO.setAddress(null);
//       reqVO.setType(null);
//       reqVO.setHostUnit(null);
//       reqVO.setUndertakingUnit(null);
//       reqVO.setUnitNumber(null);
//       reqVO.setConcernsNumber(null);
//       reqVO.setText(null);
//       reqVO.setStartTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
//       reqVO.setEndTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
//       reqVO.setStatus(null);
//       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
//
//       // 调用
//       List<JobfairDO> list = jobfairService.getJobfairList(reqVO);
//       // 断言
//       assertEquals(1, list.size());
//       assertPojoEquals(dbJobfair, list.get(0));
//    }
//
//}
