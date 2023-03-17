package cn.iocoder.yudao.module.information.service.jobfair;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.information.controller.admin.jobfair.vo.*;
import cn.iocoder.yudao.module.information.dal.dataobject.jobfair.JobfairDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.information.convert.jobfair.JobfairConvert;
import cn.iocoder.yudao.module.information.dal.mysql.jobfair.JobfairMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.information.enums.ErrorCodeConstants.*;

/**
 * 招聘会 Service 实现类
 *
 * @author SZT
 */
@Service
@Validated
public class JobfairServiceImpl  implements JobfairService {

    @Resource
    private JobfairMapper jobfairMapper;

    @Override
    public void follow(Long id) {
        jobfairMapper.follow(id);
    }

    @Override
    public void unfollow(Long id) {
        jobfairMapper.unfollow(id);
    }

    @Override
    public Long createJobfair(JobfairCreateReqVO createReqVO) {
        // 插入
        JobfairDO jobfair = JobfairConvert.INSTANCE.convert(createReqVO);
        jobfairMapper.insert(jobfair);
        // 返回
        return jobfair.getId();
    }

    @Override
    public void updateJobfair(JobfairUpdateReqVO updateReqVO) {
        // 校验存在
        validateJobfairExists(updateReqVO.getId());
        // 更新
        JobfairDO updateObj = JobfairConvert.INSTANCE.convert(updateReqVO);
        jobfairMapper.updateById(updateObj);
    }

    @Override
    public void deleteJobfair(Long id) {
        // 校验存在
        validateJobfairExists(id);
        // 删除
        jobfairMapper.deleteById(id);
    }

    private void validateJobfairExists(Long id) {
        if (jobfairMapper.selectById(id) == null) {
            throw exception(JOBFAIR_NOT_EXISTS);
        }
    }

    @Override
    public JobfairDO getJobfair(Long id) {
        return jobfairMapper.selectById(id);
    }

    @Override
    public List<JobfairDO> getAllJobfairs() {
        return jobfairMapper.selectList();
    }

    @Override
    public List<JobfairDO> getJobfairList(Collection<Long> ids) {
        return jobfairMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<JobfairDO> getJobfairPage(JobfairPageReqVO pageReqVO) {
        return jobfairMapper.selectPage(pageReqVO);
    }

    @Override
    public List<JobfairDO> getJobfairList(JobfairExportReqVO exportReqVO) {
        return jobfairMapper.selectList(exportReqVO);
    }

}
