package cn.iocoder.yudao.module.member.dal.mysql.mentor;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.member.dal.dataobject.mentor.MentorDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.member.controller.admin.mentor.vo.*;

/**
 * 导师信息 Mapper
 *
 * @author SZT
 */
@Mapper
public interface MentorMapper extends BaseMapperX<MentorDO> {

    default PageResult<MentorDO> selectPage(MentorPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MentorDO>()
                .eqIfPresent(MentorDO::getJobNumber, reqVO.getJobNumber())
                .eqIfPresent(MentorDO::getMobile, reqVO.getMobile())
                .likeIfPresent(MentorDO::getName, reqVO.getName())
                .eqIfPresent(MentorDO::getPhoto, reqVO.getPhoto())
                .eqIfPresent(MentorDO::getGender, reqVO.getGender())
                .eqIfPresent(MentorDO::getSchool, reqVO.getSchool())
                .eqIfPresent(MentorDO::getCollege, reqVO.getCollege())
                .eqIfPresent(MentorDO::getMajor, reqVO.getMajor())
                .eqIfPresent(MentorDO::getBio, reqVO.getBio())
                .eqIfPresent(MentorDO::getDio, reqVO.getDio())
                .eqIfPresent(MentorDO::getOpenid, reqVO.getOpenid())
                .betweenIfPresent(MentorDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MentorDO::getId));
    }

    default List<MentorDO> selectList(MentorExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MentorDO>()
                .eqIfPresent(MentorDO::getJobNumber, reqVO.getJobNumber())
                .eqIfPresent(MentorDO::getMobile, reqVO.getMobile())
                .likeIfPresent(MentorDO::getName, reqVO.getName())
                .eqIfPresent(MentorDO::getPhoto, reqVO.getPhoto())
                .eqIfPresent(MentorDO::getGender, reqVO.getGender())
                .eqIfPresent(MentorDO::getSchool, reqVO.getSchool())
                .eqIfPresent(MentorDO::getCollege, reqVO.getCollege())
                .eqIfPresent(MentorDO::getMajor, reqVO.getMajor())
                .eqIfPresent(MentorDO::getBio, reqVO.getBio())
                .eqIfPresent(MentorDO::getDio, reqVO.getDio())
                .eqIfPresent(MentorDO::getOpenid, reqVO.getOpenid())
                .betweenIfPresent(MentorDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(MentorDO::getId));
    }

}
