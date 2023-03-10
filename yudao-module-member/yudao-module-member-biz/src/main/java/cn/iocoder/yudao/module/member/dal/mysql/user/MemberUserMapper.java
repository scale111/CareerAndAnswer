package cn.iocoder.yudao.module.member.dal.mysql.user;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.member.dal.dataobject.user.MemberUserDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.member.controller.admin.user.vo.*;

/**
 * 用户登录表 Mapper
 *
 * @author SZT
 */
@Mapper
public interface MemberUserMapper extends BaseMapperX<MemberUserDO> {

    default MemberUserDO selectByMobile(String mobile) {
        return selectOne(MemberUserDO::getMobile, mobile);
    }

    default List<MemberUserDO> selectListByNicknameLike(String nickname) {
        return selectList(new LambdaQueryWrapperX<MemberUserDO>()
        .likeIfPresent(MemberUserDO::getNickname, nickname));
    }

    default PageResult<MemberUserDO> selectPage(MemberUserPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MemberUserDO>()
        .likeIfPresent(MemberUserDO::getNickname, reqVO.getNickname())
        .eqIfPresent(MemberUserDO::getAvatar, reqVO.getAvatar())
        .eqIfPresent(MemberUserDO::getStatus, reqVO.getStatus())
        .eqIfPresent(MemberUserDO::getMobile, reqVO.getMobile())
        .eqIfPresent(MemberUserDO::getRole, reqVO.getRole())
        .eqIfPresent(MemberUserDO::getOpenid, reqVO.getOpenid())
        .eqIfPresent(MemberUserDO::getPassword, reqVO.getPassword())
        .eqIfPresent(MemberUserDO::getRegisterIp, reqVO.getRegisterIp())
        .eqIfPresent(MemberUserDO::getLoginIp, reqVO.getLoginIp())
        .betweenIfPresent(MemberUserDO::getLoginDate, reqVO.getLoginDate())
        .betweenIfPresent(MemberUserDO::getCreateTime, reqVO.getCreateTime())
        .orderByDesc(MemberUserDO::getId));
    }

    default List<MemberUserDO> selectList(MemberUserExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<MemberUserDO>()
        .likeIfPresent(MemberUserDO::getNickname, reqVO.getNickname())
        .eqIfPresent(MemberUserDO::getAvatar, reqVO.getAvatar())
        .eqIfPresent(MemberUserDO::getStatus, reqVO.getStatus())
        .eqIfPresent(MemberUserDO::getMobile, reqVO.getMobile())
        .eqIfPresent(MemberUserDO::getRole, reqVO.getRole())
        .eqIfPresent(MemberUserDO::getOpenid, reqVO.getOpenid())
        .eqIfPresent(MemberUserDO::getPassword, reqVO.getPassword())
        .eqIfPresent(MemberUserDO::getRegisterIp, reqVO.getRegisterIp())
        .eqIfPresent(MemberUserDO::getLoginIp, reqVO.getLoginIp())
        .betweenIfPresent(MemberUserDO::getLoginDate, reqVO.getLoginDate())
        .betweenIfPresent(MemberUserDO::getCreateTime, reqVO.getCreateTime())
        .orderByDesc(MemberUserDO::getId));
    }

}

