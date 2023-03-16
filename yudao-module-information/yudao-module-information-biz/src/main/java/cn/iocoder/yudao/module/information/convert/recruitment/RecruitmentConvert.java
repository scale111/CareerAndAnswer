package cn.iocoder.yudao.module.information.convert.recruitment;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

//import cn.iocoder.yudao.module.information.controller.app.recruitment.vo.AppRecruitmentCreateReqVO;
import cn.iocoder.yudao.module.information.controller.app.recruitment.vo.AppRecruitmentConcernsVO;
import cn.iocoder.yudao.module.information.controller.app.recruitment.vo.AppRecruitmentRespVO;
//import cn.iocoder.yudao.module.information.controller.app.recruitment.vo.AppRecruitmentUpdateReqVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.information.controller.admin.recruitment.vo.*;
import cn.iocoder.yudao.module.information.dal.dataobject.recruitment.RecruitmentDO;

/**
 * 招聘信息 Convert
 *
 * @author SZT
 */
@Mapper
public interface RecruitmentConvert {

    RecruitmentConvert INSTANCE = Mappers.getMapper(RecruitmentConvert.class);

    RecruitmentDO convert(RecruitmentCreateReqVO bean);

    RecruitmentDO convert(RecruitmentUpdateReqVO bean);

    RecruitmentRespVO convert(RecruitmentDO bean);

    List<RecruitmentRespVO> convertList(List<RecruitmentDO> list);

    PageResult<RecruitmentRespVO> convertPage(PageResult<RecruitmentDO> page);

    List<RecruitmentExcelVO> convertList02(List<RecruitmentDO> list);


    //============== APP ====================

    AppRecruitmentConcernsVO concernsConvert(RecruitmentDO bean);

    AppRecruitmentRespVO appConvert(RecruitmentDO bean);

    List<AppRecruitmentRespVO> appConvertList(List<RecruitmentDO> list);



}
