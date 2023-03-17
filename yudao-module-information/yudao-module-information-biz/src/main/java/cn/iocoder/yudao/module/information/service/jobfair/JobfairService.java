package cn.iocoder.yudao.module.information.service.jobfair;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.information.controller.admin.jobfair.vo.*;
import cn.iocoder.yudao.module.information.dal.dataobject.jobfair.JobfairDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 招聘会 Service 接口
 *
 * @author SZT
 */

public interface JobfairService  {
    /**
     * 关注招聘会
     *
     * @param id 招聘会id
     */
    void follow(Long id);

    /**
     * 取消关注招聘会
     *
     * @param id 招聘会id
     */
    void unfollow(Long id);

    /**
     * 创建招聘会
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createJobfair(@Valid JobfairCreateReqVO createReqVO);

    /**
     * 更新招聘会
     *
     * @param updateReqVO 更新信息
     */
    void updateJobfair(@Valid JobfairUpdateReqVO updateReqVO);

    /**
     * 删除招聘会
     *
     * @param id 编号
     */
    void deleteJobfair(Long id);

    /**
     * 获得招聘会
     *
     * @param id 编号
     * @return 招聘会
     */
    JobfairDO getJobfair(Long id);

    /**
     * 获得全部招聘会列表
     *
     * @return 招聘会列表
     */
    List<JobfairDO> getAllJobfairs();

    /**
     * 获得招聘会列表
     *
     * @param ids 编号
     * @return 招聘会列表
     */
    List<JobfairDO> getJobfairList(Collection<Long> ids);

    /**
     * 获得招聘会分页
     *
     * @param pageReqVO 分页查询
     * @return 招聘会分页
     */
    PageResult<JobfairDO> getJobfairPage(JobfairPageReqVO pageReqVO);

    /**
     * 获得招聘会列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 招聘会列表
     */
    List<JobfairDO> getJobfairList(JobfairExportReqVO exportReqVO);

}
