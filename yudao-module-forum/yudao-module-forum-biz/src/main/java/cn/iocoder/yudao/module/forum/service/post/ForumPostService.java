package cn.iocoder.yudao.module.forum.service.post;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.forum.controller.admin.post.vo.*;
import cn.iocoder.yudao.module.forum.controller.app.post.vo.AppForumPostCreateReqVO;
import cn.iocoder.yudao.module.forum.dal.dataobject.post.ForumPostDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 帖子 Service 接口
 *
 * @author SZT
 */
public interface ForumPostService {

    /**
     * 创建帖子
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPost(@Valid ForumPostCreateReqVO createReqVO);

    /**
     * 创建帖子
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long appCreatePost(@Valid AppForumPostCreateReqVO createReqVO);


    /**
     * 更新帖子
     *
     * @param updateReqVO 更新信息
     */
    void updatePost(@Valid ForumPostUpdateReqVO updateReqVO);

    /**
     * 删除帖子
     *
     * @param id 编号
     */
    void deletePost(Long id);

    /**
     * 获得帖子
     *
     * @param id 编号
     * @return 帖子
     */
    ForumPostDO getPost(Long id);

    /**
     * 获得帖子列表
     *
     * @return 帖子列表
     */
    List<ForumPostDO> getAllPostList();

    /**
     * 获得帖子分页
     *
     * @param pageReqVO 分页查询
     * @return 帖子分页
     */
    PageResult<ForumPostDO> getPostPage(ForumPostPageReqVO pageReqVO);

    /**
     * 获得帖子列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 帖子列表
     */
    List<ForumPostDO> getPostList(ForumPostExportReqVO exportReqVO);

}
