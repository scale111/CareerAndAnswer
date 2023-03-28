package cn.iocoder.yudao.module.forum.convert.post;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.forum.controller.app.post.vo.AppForumPostCreateReqVO;
import cn.iocoder.yudao.module.forum.controller.app.post.vo.AppForumPostRespVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.forum.controller.admin.post.vo.*;
import cn.iocoder.yudao.module.forum.dal.dataobject.post.ForumPostDO;

/**
 * 帖子 Convert
 *
 * @author SZT
 */
@Mapper
public interface ForumPostConvert {

    ForumPostConvert INSTANCE = Mappers.getMapper(ForumPostConvert.class);

    ForumPostDO convert(ForumPostCreateReqVO bean);

    ForumPostDO convert(ForumPostUpdateReqVO bean);

    ForumPostRespVO convert(ForumPostDO bean);

    List<ForumPostRespVO> convertList(List<ForumPostDO> list);

    PageResult<ForumPostRespVO> convertPage(PageResult<ForumPostDO> page);

    List<ForumPostExcelVO> convertList02(List<ForumPostDO> list);


    //=================== APP =======================

    ForumPostDO convert(AppForumPostCreateReqVO bean);

//    ForumPostDO convert(AppForumPostUpdateReqVO bean);

    AppForumPostRespVO appConvert(ForumPostDO bean);

    List<AppForumPostRespVO> appConvertList(List<ForumPostDO> list);

//    PageResult<AppForumPostRespVO> convertPage(PageResult<ForumPostDO> page);

}
