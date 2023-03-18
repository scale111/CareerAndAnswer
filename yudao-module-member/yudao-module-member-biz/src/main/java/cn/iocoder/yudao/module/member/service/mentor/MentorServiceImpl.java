package cn.iocoder.yudao.module.member.service.mentor;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.member.controller.admin.mentor.vo.*;
import cn.iocoder.yudao.module.member.dal.dataobject.mentor.MentorDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.member.convert.mentor.MentorConvert;
import cn.iocoder.yudao.module.member.dal.mysql.mentor.MentorMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.member.enums.ErrorCodeConstants.*;

/**
 * 导师信息 Service 实现类
 *
 * @author SZT
 */
@Service
@Validated
public class MentorServiceImpl implements MentorService {

    @Resource
    private MentorMapper mentorMapper;

    @Override
    public Long createMentor(MentorCreateReqVO createReqVO) {
        // 插入
        MentorDO mentor = MentorConvert.INSTANCE.convert(createReqVO);
        mentorMapper.insert(mentor);
        // 返回
        return mentor.getId();
    }

    @Override
    public void updateMentor(MentorUpdateReqVO updateReqVO) {
        // 校验存在
        validateMentorExists(updateReqVO.getId());
        // 更新
        MentorDO updateObj = MentorConvert.INSTANCE.convert(updateReqVO);
        mentorMapper.updateById(updateObj);
    }

    @Override
    public void deleteMentor(Long id) {
        // 校验存在
        validateMentorExists(id);
        // 删除
        mentorMapper.deleteById(id);
    }

    private void validateMentorExists(Long id) {
        if (mentorMapper.selectById(id) == null) {
            throw exception(MENTOR_NOT_EXISTS);
        }
    }

    @Override
    public MentorDO getMentor(Long id) {
        return mentorMapper.selectById(id);
    }

    @Override
    public List<MentorDO> getAllMentors() {
        return mentorMapper.selectList();
    }

    @Override
    public List<MentorDO> getMentorList(Collection<Long> ids) {
        return mentorMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<MentorDO> getMentorPage(MentorPageReqVO pageReqVO) {
        return mentorMapper.selectPage(pageReqVO);
    }

    @Override
    public List<MentorDO> getMentorList(MentorExportReqVO exportReqVO) {
        return mentorMapper.selectList(exportReqVO);
    }

}
