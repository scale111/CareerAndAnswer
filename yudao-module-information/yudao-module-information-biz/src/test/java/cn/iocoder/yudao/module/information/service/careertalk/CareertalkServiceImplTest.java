//package cn.iocoder.yudao.module.information.service.careertalk;
//
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import javax.annotation.Resource;
//
//import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;
//
//import cn.iocoder.yudao.module.information.controller.admin.careertalk.vo.*;
//import cn.iocoder.yudao.module.information.dal.dataobject.careertalk.CareertalkDO;
//import cn.iocoder.yudao.module.information.dal.mysql.careertalk.CareertalkMapper;
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
//* {@link CareertalkServiceImpl} 的单元测试类
//*
//* @author SZT
//*/
//@Import(CareertalkServiceImpl.class)
//public class CareertalkServiceImplTest extends BaseDbUnitTest {
//
//    @Resource
//    private CareertalkServiceImpl careertalkService;
//
//    @Resource
//    private CareertalkMapper careertalkMapper;
//
//    @Test
//    public void testCreateCareertalk_success() {
//        // 准备参数
//        CareertalkCreateReqVO reqVO = randomPojo(CareertalkCreateReqVO.class);
//
//        // 调用
//        Long careertalkId = careertalkService.createCareertalk(reqVO);
//        // 断言
//        assertNotNull(careertalkId);
//        // 校验记录的属性是否正确
//        CareertalkDO careertalk = careertalkMapper.selectById(careertalkId);
//        assertPojoEquals(reqVO, careertalk);
//    }
//
//    @Test
//    public void testUpdateCareertalk_success() {
//        // mock 数据
//        CareertalkDO dbCareertalk = randomPojo(CareertalkDO.class);
//        careertalkMapper.insert(dbCareertalk);// @Sql: 先插入出一条存在的数据
//        // 准备参数
//        CareertalkUpdateReqVO reqVO = randomPojo(CareertalkUpdateReqVO.class, o -> {
//            o.setId(dbCareertalk.getId()); // 设置更新的 ID
//        });
//
//        // 调用
//        careertalkService.updateCareertalk(reqVO);
//        // 校验是否更新正确
//        CareertalkDO careertalk = careertalkMapper.selectById(reqVO.getId()); // 获取最新的
//        assertPojoEquals(reqVO, careertalk);
//    }
//
//    @Test
//    public void testUpdateCareertalk_notExists() {
//        // 准备参数
//        CareertalkUpdateReqVO reqVO = randomPojo(CareertalkUpdateReqVO.class);
//
//        // 调用, 并断言异常
//        assertServiceException(() -> careertalkService.updateCareertalk(reqVO), CAREERTALK_NOT_EXISTS);
//    }
//
//    @Test
//    public void testDeleteCareertalk_success() {
//        // mock 数据
//        CareertalkDO dbCareertalk = randomPojo(CareertalkDO.class);
//        careertalkMapper.insert(dbCareertalk);// @Sql: 先插入出一条存在的数据
//        // 准备参数
//        Long id = dbCareertalk.getId();
//
//        // 调用
//        careertalkService.deleteCareertalk(id);
//       // 校验数据不存在了
//       assertNull(careertalkMapper.selectById(id));
//    }
//
//    @Test
//    public void testDeleteCareertalk_notExists() {
//        // 准备参数
//        Long id = randomLongId();
//
//        // 调用, 并断言异常
//        assertServiceException(() -> careertalkService.deleteCareertalk(id), CAREERTALK_NOT_EXISTS);
//    }
//
//    @Test
//    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
//    public void testGetCareertalkPage() {
//       // mock 数据
//       CareertalkDO dbCareertalk = randomPojo(CareertalkDO.class, o -> { // 等会查询到
//           o.setTitle(null);
//           o.setName(null);
//           o.setAddress(null);
//           o.setSpeaker(null);
//           o.setTopic(null);
//           o.setOrganizer(null);
//           o.setEmail(null);
//           o.setText(null);
//           o.setStartTime(null);
//           o.setEndTime(null);
//           o.setConcernsNumber(null);
//           o.setStatus(null);
//           o.setCreateTime(null);
//       });
//       careertalkMapper.insert(dbCareertalk);
//       // 测试 title 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setTitle(null)));
//       // 测试 name 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setName(null)));
//       // 测试 address 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setAddress(null)));
//       // 测试 speaker 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setSpeaker(null)));
//       // 测试 topic 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setTopic(null)));
//       // 测试 organizer 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setOrganizer(null)));
//       // 测试 email 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setEmail(null)));
//       // 测试 text 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setText(null)));
//       // 测试 startTime 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setStartTime(null)));
//       // 测试 endTime 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setEndTime(null)));
//       // 测试 concernsNumber 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setConcernsNumber(null)));
//       // 测试 status 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setStatus(null)));
//       // 测试 createTime 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setCreateTime(null)));
//       // 准备参数
//       CareertalkPageReqVO reqVO = new CareertalkPageReqVO();
//       reqVO.setTitle(null);
//       reqVO.setName(null);
//       reqVO.setAddress(null);
//       reqVO.setSpeaker(null);
//       reqVO.setTopic(null);
//       reqVO.setOrganizer(null);
//       reqVO.setEmail(null);
//       reqVO.setText(null);
//       reqVO.setStartTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
//       reqVO.setEndTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
//       reqVO.setConcernsNumber(null);
//       reqVO.setStatus(null);
//       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
//
//       // 调用
//       PageResult<CareertalkDO> pageResult = careertalkService.getCareertalkPage(reqVO);
//       // 断言
//       assertEquals(1, pageResult.getTotal());
//       assertEquals(1, pageResult.getList().size());
//       assertPojoEquals(dbCareertalk, pageResult.getList().get(0));
//    }
//
//    @Test
//    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
//    public void testGetCareertalkList() {
//       // mock 数据
//       CareertalkDO dbCareertalk = randomPojo(CareertalkDO.class, o -> { // 等会查询到
//           o.setTitle(null);
//           o.setName(null);
//           o.setAddress(null);
//           o.setSpeaker(null);
//           o.setTopic(null);
//           o.setOrganizer(null);
//           o.setEmail(null);
//           o.setText(null);
//           o.setStartTime(null);
//           o.setEndTime(null);
//           o.setConcernsNumber(null);
//           o.setStatus(null);
//           o.setCreateTime(null);
//       });
//       careertalkMapper.insert(dbCareertalk);
//       // 测试 title 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setTitle(null)));
//       // 测试 name 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setName(null)));
//       // 测试 address 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setAddress(null)));
//       // 测试 speaker 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setSpeaker(null)));
//       // 测试 topic 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setTopic(null)));
//       // 测试 organizer 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setOrganizer(null)));
//       // 测试 email 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setEmail(null)));
//       // 测试 text 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setText(null)));
//       // 测试 startTime 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setStartTime(null)));
//       // 测试 endTime 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setEndTime(null)));
//       // 测试 concernsNumber 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setConcernsNumber(null)));
//       // 测试 status 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setStatus(null)));
//       // 测试 createTime 不匹配
//       careertalkMapper.insert(cloneIgnoreId(dbCareertalk, o -> o.setCreateTime(null)));
//       // 准备参数
//       CareertalkExportReqVO reqVO = new CareertalkExportReqVO();
//       reqVO.setTitle(null);
//       reqVO.setName(null);
//       reqVO.setAddress(null);
//       reqVO.setSpeaker(null);
//       reqVO.setTopic(null);
//       reqVO.setOrganizer(null);
//       reqVO.setEmail(null);
//       reqVO.setText(null);
//       reqVO.setStartTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
//       reqVO.setEndTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
//       reqVO.setConcernsNumber(null);
//       reqVO.setStatus(null);
//       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
//
//       // 调用
//       List<CareertalkDO> list = careertalkService.getCareertalkList(reqVO);
//       // 断言
//       assertEquals(1, list.size());
//       assertPojoEquals(dbCareertalk, list.get(0));
//    }
//
//}
