package cn.iocoder.yudao.module.information.service.recruitment;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.information.controller.admin.recruitment.vo.*;
import cn.iocoder.yudao.module.information.dal.dataobject.recruitment.RecruitmentDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.information.convert.recruitment.RecruitmentConvert;
import cn.iocoder.yudao.module.information.dal.mysql.recruitment.RecruitmentMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.information.enums.ErrorCodeConstants.*;

/**
 * 招聘信息 Service 实现类
 *
 * @author SZT
 */
@Service
@Validated
public class RecruitmentServiceImpl implements RecruitmentService {

    @Resource
    private RecruitmentMapper recruitmentMapper;

    @Override
    public void follow(Long id) {
        recruitmentMapper.follow(id);
    }

    @Override
    public void unfollow(Long id) {
        recruitmentMapper.unfollow(id);
    }

    @Override
    public Long createRecruitment(RecruitmentCreateReqVO createReqVO) {
        // 插入
        RecruitmentDO recruitment = RecruitmentConvert.INSTANCE.convert(createReqVO);
        recruitmentMapper.insert(recruitment);
        // 返回
        return recruitment.getId();
    }

    @Override
    public void updateRecruitment(RecruitmentUpdateReqVO updateReqVO) {
        // 校验存在
        validateRecruitmentExists(updateReqVO.getId());
        // 更新
        RecruitmentDO updateObj = RecruitmentConvert.INSTANCE.convert(updateReqVO);
        recruitmentMapper.updateById(updateObj);
    }

    @Override
    public void deleteRecruitment(Long id) {
        // 校验存在
        validateRecruitmentExists(id);
        // 删除
        recruitmentMapper.deleteById(id);
    }

    private void validateRecruitmentExists(Long id) {
        if (recruitmentMapper.selectById(id) == null) {
            throw exception(RECRUITMENT_NOT_EXISTS);
        }
    }

    @Override
    public RecruitmentDO getRecruitment(Long id) {
        return recruitmentMapper.selectById(id);
    }

    @Override
    public List<RecruitmentDO> getAllRecruitments() {
//        QueryWrapper<RecruitmentDO> wrapper = new QueryWrapper<>();
//        //查询所有开启状态的数据
//        wrapper.eq("status", 0);
//        return recruitmentMapper.selectList(wrapper);

        //BaseMapperX进一步封装
        return recruitmentMapper.selectList("status",0);
    }

    @Override
    public List<RecruitmentDO> getRecruitmentList(Collection<Long> ids) {
        return recruitmentMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<RecruitmentDO> getRecruitmentPage(RecruitmentPageReqVO pageReqVO) {
        return recruitmentMapper.selectPage(pageReqVO);
    }

    @Override
    public List<RecruitmentDO> getRecruitmentList(RecruitmentExportReqVO exportReqVO) {
        return recruitmentMapper.selectList(exportReqVO);
    }

}
