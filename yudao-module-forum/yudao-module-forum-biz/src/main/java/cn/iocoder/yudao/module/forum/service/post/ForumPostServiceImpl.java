package cn.iocoder.yudao.module.forum.service.post;

import cn.iocoder.yudao.module.forum.controller.app.post.vo.AppForumPostCreateReqVO;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.forum.controller.admin.post.vo.*;
import cn.iocoder.yudao.module.forum.dal.dataobject.post.ForumPostDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.forum.convert.post.ForumPostConvert;
import cn.iocoder.yudao.module.forum.dal.mysql.post.ForumPostMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.forum.enums.ErrorCodeConstants.*;

/**
 * 帖子 Service 实现类
 *
 * @author SZT
 */
@Service
@Validated
public class ForumPostServiceImpl implements ForumPostService {

    @Resource
    private ForumPostMapper forumPostMapper;

    @Override
    public Long createPost(ForumPostCreateReqVO createReqVO) {
        // 插入
        ForumPostDO post = ForumPostConvert.INSTANCE.convert(createReqVO);
        forumPostMapper.insert(post);
        // 返回
        return post.getId();
    }

    @Override
    public Long appCreatePost(AppForumPostCreateReqVO createReqVO) {
        // 插入
        ForumPostDO post = ForumPostConvert.INSTANCE.convert(createReqVO);
        forumPostMapper.insert(post);
        // 返回
        return post.getId();
    }

    @Override
    public void updatePost(ForumPostUpdateReqVO updateReqVO) {
        // 校验存在
        validatePostExists(updateReqVO.getId());
        // 更新
        ForumPostDO updateObj = ForumPostConvert.INSTANCE.convert(updateReqVO);
        forumPostMapper.updateById(updateObj);
    }

    @Override
    public void deletePost(Long id) {
        // 校验存在
        validatePostExists(id);
        // 删除
        forumPostMapper.deleteById(id);
    }

    private void validatePostExists(Long id) {
        if (forumPostMapper.selectById(id) == null) {
            throw exception(POST_NOT_EXISTS);
        }
    }

    @Override
    public ForumPostDO getPost(Long id) {
        return forumPostMapper.selectById(id);
    }

    @Override
    public List<ForumPostDO> getAllPostList() {
        return forumPostMapper.selectList();
    }

    @Override
    public PageResult<ForumPostDO> getPostPage(ForumPostPageReqVO pageReqVO) {
        return forumPostMapper.selectPage(pageReqVO);
    }

    @Override
    public List<ForumPostDO> getPostList(ForumPostExportReqVO exportReqVO) {
        return forumPostMapper.selectList(exportReqVO);
    }

}
