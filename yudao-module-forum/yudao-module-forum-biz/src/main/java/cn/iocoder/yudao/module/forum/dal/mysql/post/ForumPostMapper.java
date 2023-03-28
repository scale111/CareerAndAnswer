package cn.iocoder.yudao.module.forum.dal.mysql.post;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.forum.dal.dataobject.post.ForumPostDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.forum.controller.admin.post.vo.*;

/**
 * 帖子 Mapper
 *
 * @author SZT
 */
@Mapper
public interface ForumPostMapper extends BaseMapperX<ForumPostDO> {

    default PageResult<ForumPostDO> selectPage(ForumPostPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<ForumPostDO>()
                .eqIfPresent(ForumPostDO::getUserId, reqVO.getUserId())
                .likeIfPresent(ForumPostDO::getUserNickname, reqVO.getUserNickname())
                .eqIfPresent(ForumPostDO::getAvatar, reqVO.getAvatar())
                .eqIfPresent(ForumPostDO::getTitle, reqVO.getTitle())
                .eqIfPresent(ForumPostDO::getText, reqVO.getText())
                .eqIfPresent(ForumPostDO::getCommentNumber, reqVO.getCommentNumber())
                .eqIfPresent(ForumPostDO::getLikeNumber, reqVO.getLikeNumber())
                .eqIfPresent(ForumPostDO::getUnlikeNumber, reqVO.getUnlikeNumber())
                .eqIfPresent(ForumPostDO::getSticky, reqVO.getSticky())
                .eqIfPresent(ForumPostDO::getAuditStatus, reqVO.getAuditStatus())
                .betweenIfPresent(ForumPostDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ForumPostDO::getId));
    }

    default List<ForumPostDO> selectList(ForumPostExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<ForumPostDO>()
                .eqIfPresent(ForumPostDO::getUserId, reqVO.getUserId())
                .likeIfPresent(ForumPostDO::getUserNickname, reqVO.getUserNickname())
                .eqIfPresent(ForumPostDO::getAvatar, reqVO.getAvatar())
                .eqIfPresent(ForumPostDO::getTitle, reqVO.getTitle())
                .eqIfPresent(ForumPostDO::getText, reqVO.getText())
                .eqIfPresent(ForumPostDO::getCommentNumber, reqVO.getCommentNumber())
                .eqIfPresent(ForumPostDO::getLikeNumber, reqVO.getLikeNumber())
                .eqIfPresent(ForumPostDO::getUnlikeNumber, reqVO.getUnlikeNumber())
                .eqIfPresent(ForumPostDO::getSticky, reqVO.getSticky())
                .eqIfPresent(ForumPostDO::getAuditStatus, reqVO.getAuditStatus())
                .betweenIfPresent(ForumPostDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(ForumPostDO::getId));
    }

}
