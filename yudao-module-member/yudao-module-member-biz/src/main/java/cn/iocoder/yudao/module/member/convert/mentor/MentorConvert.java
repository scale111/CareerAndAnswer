package cn.iocoder.yudao.module.member.convert.mentor;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.member.controller.app.mentor.vo.AppMentorRespVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.member.controller.admin.mentor.vo.*;
import cn.iocoder.yudao.module.member.dal.dataobject.mentor.MentorDO;

/**
 * 导师信息 Convert
 *
 * @author SZT
 */
@Mapper
public interface MentorConvert {

    MentorConvert INSTANCE = Mappers.getMapper(MentorConvert.class);

    MentorDO convert(MentorCreateReqVO bean);

    MentorDO convert(MentorUpdateReqVO bean);

    MentorRespVO convert(MentorDO bean);

    List<MentorRespVO> convertList(List<MentorDO> list);

    PageResult<MentorRespVO> convertPage(PageResult<MentorDO> page);

    List<MentorExcelVO> convertList02(List<MentorDO> list);


    //====================  APP  ======================

    AppMentorRespVO appConvert(MentorDO bean);

    List<AppMentorRespVO> appConvertList(List<MentorDO> list);

//    PageResult<AppMentorRespVO> convertPage(PageResult<MentorDO> page);



}
