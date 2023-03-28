package cn.iocoder.yudao.module.forum.service.comment;

import cn.iocoder.yudao.module.forum.controller.app.comment.vo.AppCommentCreateReqVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.forum.controller.admin.comment.vo.*;
import cn.iocoder.yudao.module.forum.dal.dataobject.comment.CommentDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.forum.convert.comment.CommentConvert;
import cn.iocoder.yudao.module.forum.dal.mysql.comment.CommentMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.forum.enums.ErrorCodeConstants.*;

/**
 * 评论 Service 实现类
 *
 * @author SZT
 */
@Service
@Validated
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public Long createComment(CommentCreateReqVO createReqVO) {
        // 插入
        CommentDO comment = CommentConvert.INSTANCE.convert(createReqVO);
        commentMapper.insert(comment);
        // 返回
        return comment.getId();
    }

    @Override
    public Long appCreateComment(AppCommentCreateReqVO createReqVO) {
        // 插入
        CommentDO comment = CommentConvert.INSTANCE.convert(createReqVO);
        commentMapper.insert(comment);
        // 返回
        return comment.getId();
    }

    @Override
    public void updateComment(CommentUpdateReqVO updateReqVO) {
        // 校验存在
        validateCommentExists(updateReqVO.getId());
        // 更新
        CommentDO updateObj = CommentConvert.INSTANCE.convert(updateReqVO);
        commentMapper.updateById(updateObj);
    }

    @Override
    public void deleteComment(Long id) {
        // 校验存在
        validateCommentExists(id);
        // 删除
        commentMapper.deleteById(id);
    }

    private void validateCommentExists(Long id) {
        if (commentMapper.selectById(id) == null) {
            throw exception(COMMENT_NOT_EXISTS);
        }
    }

    @Override
    public CommentDO getComment(Long id) {
        return commentMapper.selectById(id);
    }

    @Override
    public List<CommentDO> getCommentList(Collection<Long> ids) {
        return commentMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<CommentDO> getCommentPage(CommentPageReqVO pageReqVO) {
        return commentMapper.selectPage(pageReqVO);
    }

    @Override
    public List<CommentDO> getCommentList(CommentExportReqVO exportReqVO) {
        return commentMapper.selectList(exportReqVO);
    }

}
