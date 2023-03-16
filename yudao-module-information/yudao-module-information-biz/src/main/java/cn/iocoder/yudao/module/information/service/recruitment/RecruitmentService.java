package cn.iocoder.yudao.module.information.service.recruitment;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.information.controller.admin.recruitment.vo.*;
import cn.iocoder.yudao.module.information.dal.dataobject.recruitment.RecruitmentDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * 招聘信息 Service 接口
 *
 * @author SZT
 */

public interface RecruitmentService extends IService<RecruitmentDO> {

    /**
     * 创建招聘信息
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createRecruitment(@Valid RecruitmentCreateReqVO createReqVO);

    /**
     * 更新招聘信息
     *
     * @param updateReqVO 更新信息
     */
    void updateRecruitment(@Valid RecruitmentUpdateReqVO updateReqVO);

    /**
     * 删除招聘信息
     *
     * @param id 编号
     */
    void deleteRecruitment(Long id);

    /**
     * 获得招聘信息
     *
     * @param id 编号
     * @return 招聘信息
     */
    RecruitmentDO getRecruitment(Long id);

    /**
     * 获得全部招聘信息
     *
     * @return 招聘信息
     */
    List<RecruitmentDO> getAllRecruitments();

    /**
     * 获得招聘信息列表
     *
     * @param ids 编号
     * @return 招聘信息列表
     */
    List<RecruitmentDO> getRecruitmentList(Collection<Long> ids);

    /**
     * 获得招聘信息分页
     *
     * @param pageReqVO 分页查询
     * @return 招聘信息分页
     */
    PageResult<RecruitmentDO> getRecruitmentPage(RecruitmentPageReqVO pageReqVO);

    /**
     * 获得招聘信息列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 招聘信息列表
     */
    List<RecruitmentDO> getRecruitmentList(RecruitmentExportReqVO exportReqVO);

}
