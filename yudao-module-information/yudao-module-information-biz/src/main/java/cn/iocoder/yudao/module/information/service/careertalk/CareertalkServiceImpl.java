package cn.iocoder.yudao.module.information.service.careertalk;

import cn.iocoder.yudao.module.information.dal.dataobject.jobfair.JobfairDO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.information.controller.admin.careertalk.vo.*;
import cn.iocoder.yudao.module.information.dal.dataobject.careertalk.CareertalkDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.information.convert.careertalk.CareertalkConvert;
import cn.iocoder.yudao.module.information.dal.mysql.careertalk.CareertalkMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.information.enums.ErrorCodeConstants.*;

/**
 * 宣讲会 Service 实现类
 *
 * @author SZT
 */
@Service
@Validated
public class CareertalkServiceImpl implements CareertalkService {
    @Resource
    private CareertalkMapper careertalkMapper;

    @Override
    public void follow(Long id) {
        careertalkMapper.follow(id);
    }

    @Override
    public void unfollow(Long id) {
        careertalkMapper.unfollow(id);
    }

    @Override
    public Long createCareertalk(CareertalkCreateReqVO createReqVO) {
        // 插入
        CareertalkDO careertalk = CareertalkConvert.INSTANCE.convert(createReqVO);
        careertalkMapper.insert(careertalk);
        // 返回
        return careertalk.getId();
    }

    @Override
    public void updateCareertalk(CareertalkUpdateReqVO updateReqVO) {
        // 校验存在
        validateCareertalkExists(updateReqVO.getId());
        // 更新
        CareertalkDO updateObj = CareertalkConvert.INSTANCE.convert(updateReqVO);
        careertalkMapper.updateById(updateObj);
    }

    @Override
    public void deleteCareertalk(Long id) {
        // 校验存在
        validateCareertalkExists(id);
        // 删除
        careertalkMapper.deleteById(id);
    }

    private void validateCareertalkExists(Long id) {
        if (careertalkMapper.selectById(id) == null) {
            throw exception(CAREERTALK_NOT_EXISTS);
        }
    }

    @Override
    public CareertalkDO getCareertalk(Long id) {
        return careertalkMapper.selectById(id);
    }

    @Override
    public List<CareertalkDO> getAllCareertalks() {
//        QueryWrapper<CareertalkDO> wrapper = new QueryWrapper<>();
//        //查询所有开启状态的数据
//        wrapper.eq("status", 0);
//        return careertalkMapper.selectList();

        //BaseMapperX进一步封装
        return careertalkMapper.selectList("status", 0);
    }

    @Override
    public List<CareertalkDO> getCareertalkList(Collection<Long> ids) {
        return careertalkMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<CareertalkDO> getCareertalkPage(CareertalkPageReqVO pageReqVO) {
        return careertalkMapper.selectPage(pageReqVO);
    }

    @Override
    public List<CareertalkDO> getCareertalkList(CareertalkExportReqVO exportReqVO) {
        return careertalkMapper.selectList(exportReqVO);
    }

}
