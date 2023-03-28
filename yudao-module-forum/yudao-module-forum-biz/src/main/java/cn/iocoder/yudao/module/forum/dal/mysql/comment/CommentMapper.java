package cn.iocoder.yudao.module.forum.dal.mysql.comment;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.forum.dal.dataobject.comment.CommentDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.forum.controller.admin.comment.vo.*;

/**
 * 评论 Mapper
 *
 * @author SZT
 */
@Mapper
public interface CommentMapper extends BaseMapperX<CommentDO> {

    default PageResult<CommentDO> selectPage(CommentPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CommentDO>()
                .eqIfPresent(CommentDO::getCommenterId, reqVO.getCommenterId())
                .likeIfPresent(CommentDO::getCommenterNickname, reqVO.getCommenterNickname())
                .eqIfPresent(CommentDO::getCommenterAvatar, reqVO.getCommenterAvatar())
                .eqIfPresent(CommentDO::getReviewedId, reqVO.getReviewedId())
                .likeIfPresent(CommentDO::getReviewedNickname, reqVO.getReviewedNickname())
                .eqIfPresent(CommentDO::getReviewedAvatar, reqVO.getReviewedAvatar())
                .eqIfPresent(CommentDO::getPostId, reqVO.getPostId())
                .eqIfPresent(CommentDO::getLevel, reqVO.getLevel())
                .eqIfPresent(CommentDO::getSuperiorId, reqVO.getSuperiorId())
                .eqIfPresent(CommentDO::getText, reqVO.getText())
                .eqIfPresent(CommentDO::getAuditStatus, reqVO.getAuditStatus())
                .betweenIfPresent(CommentDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CommentDO::getId));
    }

    default List<CommentDO> selectList(CommentExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<CommentDO>()
                .eqIfPresent(CommentDO::getCommenterId, reqVO.getCommenterId())
                .likeIfPresent(CommentDO::getCommenterNickname, reqVO.getCommenterNickname())
                .eqIfPresent(CommentDO::getCommenterAvatar, reqVO.getCommenterAvatar())
                .eqIfPresent(CommentDO::getReviewedId, reqVO.getReviewedId())
                .likeIfPresent(CommentDO::getReviewedNickname, reqVO.getReviewedNickname())
                .eqIfPresent(CommentDO::getReviewedAvatar, reqVO.getReviewedAvatar())
                .eqIfPresent(CommentDO::getPostId, reqVO.getPostId())
                .eqIfPresent(CommentDO::getLevel, reqVO.getLevel())
                .eqIfPresent(CommentDO::getSuperiorId, reqVO.getSuperiorId())
                .eqIfPresent(CommentDO::getText, reqVO.getText())
                .eqIfPresent(CommentDO::getAuditStatus, reqVO.getAuditStatus())
                .betweenIfPresent(CommentDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CommentDO::getId));
    }

}
