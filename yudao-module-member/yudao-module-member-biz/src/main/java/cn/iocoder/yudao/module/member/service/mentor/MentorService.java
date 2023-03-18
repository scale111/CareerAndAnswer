package cn.iocoder.yudao.module.member.service.mentor;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.member.controller.admin.mentor.vo.*;
import cn.iocoder.yudao.module.member.dal.dataobject.mentor.MentorDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 导师信息 Service 接口
 *
 * @author SZT
 */
public interface MentorService {

    /**
     * 创建导师信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createMentor(@Valid MentorCreateReqVO createReqVO);

    /**
     * 更新导师信息
     *
     * @param updateReqVO 更新信息
     */
    void updateMentor(@Valid MentorUpdateReqVO updateReqVO);

    /**
     * 删除导师信息
     *
     * @param id 编号
     */
    void deleteMentor(Long id);

    /**
     * 获得导师信息
     *
     * @param id 编号
     * @return 导师信息
     */
    MentorDO getMentor(Long id);

    /**
     * 获得所有导师信息
     *
     * @return 导师信息
     */
    List<MentorDO> getAllMentors();

    /**
     * 获得导师信息列表
     *
     * @param ids 编号
     * @return 导师信息列表
     */
    List<MentorDO> getMentorList(Collection<Long> ids);

    /**
     * 获得导师信息分页
     *
     * @param pageReqVO 分页查询
     * @return 导师信息分页
     */
    PageResult<MentorDO> getMentorPage(MentorPageReqVO pageReqVO);

    /**
     * 获得导师信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 导师信息列表
     */
    List<MentorDO> getMentorList(MentorExportReqVO exportReqVO);

}
