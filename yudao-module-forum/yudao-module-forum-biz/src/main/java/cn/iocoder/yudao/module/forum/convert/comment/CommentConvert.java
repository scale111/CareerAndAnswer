package cn.iocoder.yudao.module.forum.convert.comment;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.forum.controller.app.comment.vo.AppCommentCreateReqVO;
import cn.iocoder.yudao.module.forum.controller.app.comment.vo.AppCommentRespVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.forum.controller.admin.comment.vo.*;
import cn.iocoder.yudao.module.forum.dal.dataobject.comment.CommentDO;

/**
 * 评论 Convert
 *
 * @author SZT
 */
@Mapper
public interface CommentConvert {

    CommentConvert INSTANCE = Mappers.getMapper(CommentConvert.class);

    CommentDO convert(CommentCreateReqVO bean);

    CommentDO convert(CommentUpdateReqVO bean);

    CommentRespVO convert(CommentDO bean);

    List<CommentRespVO> convertList(List<CommentDO> list);

    PageResult<CommentRespVO> convertPage(PageResult<CommentDO> page);

    List<CommentExcelVO> convertList02(List<CommentDO> list);


    //=================== APP =======================


    CommentDO convert(AppCommentCreateReqVO bean);


    AppCommentRespVO appConvert(CommentDO bean);

    List<AppCommentRespVO> appConvertList(List<CommentDO> list);


}
