package cn.iocoder.yudao.module.information.convert.careertalk;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.information.controller.app.careertalk.vo.AppCareertalkConcernsVO;
import cn.iocoder.yudao.module.information.controller.app.careertalk.vo.AppCareertalkRespVO;
import cn.iocoder.yudao.module.information.controller.app.recruitment.vo.AppRecruitmentConcernsVO;
import cn.iocoder.yudao.module.information.dal.dataobject.recruitment.RecruitmentDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.information.controller.admin.careertalk.vo.*;
import cn.iocoder.yudao.module.information.dal.dataobject.careertalk.CareertalkDO;

/**
 * 宣讲会 Convert
 *
 * @author SZT
 */
@Mapper
public interface CareertalkConvert {

    CareertalkConvert INSTANCE = Mappers.getMapper(CareertalkConvert.class);

    CareertalkDO convert(CareertalkCreateReqVO bean);

    CareertalkDO convert(CareertalkUpdateReqVO bean);

    CareertalkRespVO convert(CareertalkDO bean);

    List<CareertalkRespVO> convertList(List<CareertalkDO> list);

    PageResult<CareertalkRespVO> convertPage(PageResult<CareertalkDO> page);

    List<CareertalkExcelVO> convertList02(List<CareertalkDO> list);

    //============== APP ====================
    AppCareertalkConcernsVO concernsConvert(CareertalkDO bean);

    AppCareertalkRespVO appConvert(CareertalkDO bean);

    List<AppCareertalkRespVO> appConvertList(List<CareertalkDO> list);

}
