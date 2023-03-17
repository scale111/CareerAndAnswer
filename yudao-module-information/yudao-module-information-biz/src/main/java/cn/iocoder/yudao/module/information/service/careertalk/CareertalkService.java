package cn.iocoder.yudao.module.information.service.careertalk;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.information.controller.admin.careertalk.vo.*;
import cn.iocoder.yudao.module.information.dal.dataobject.careertalk.CareertalkDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;


/**
 * 宣讲会 Service 接口
 *
 * @author SZT
 */
public interface CareertalkService {
    /**
     * 关注宣讲会
     *
     * @param id 宣讲会id
     */
    void follow(Long id);

    /**
     * 取消关注宣讲会
     *
     * @param id 宣讲会id
     */
    void unfollow(Long id);

    /**
     * 创建宣讲会
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createCareertalk(@Valid CareertalkCreateReqVO createReqVO);

    /**
     * 更新宣讲会
     *
     * @param updateReqVO 更新信息
     */
    void updateCareertalk(@Valid CareertalkUpdateReqVO updateReqVO);

    /**
     * 删除宣讲会
     *
     * @param id 编号
     */
    void deleteCareertalk(Long id);

    /**
     * 获得宣讲会
     *
     * @param id 编号
     * @return 宣讲会
     */
    CareertalkDO getCareertalk(Long id);

    /**
     * 获得全部宣讲会列表
     *
     * @return 宣讲会列表
     */
    List<CareertalkDO> getAllCareertalks();

    /**
     * 获得宣讲会列表
     *
     * @param ids 编号
     * @return 宣讲会列表
     */
    List<CareertalkDO> getCareertalkList(Collection<Long> ids);

    /**
     * 获得宣讲会分页
     *
     * @param pageReqVO 分页查询
     * @return 宣讲会分页
     */
    PageResult<CareertalkDO> getCareertalkPage(CareertalkPageReqVO pageReqVO);

    /**
     * 获得宣讲会列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 宣讲会列表
     */
    List<CareertalkDO> getCareertalkList(CareertalkExportReqVO exportReqVO);

}
