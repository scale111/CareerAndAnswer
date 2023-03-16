package cn.iocoder.yudao.module.information.convert.jobfair;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.information.controller.app.careertalk.vo.AppCareertalkConcernsVO;
import cn.iocoder.yudao.module.information.controller.app.jobfair.vo.AppJobfairConcernsVO;
import cn.iocoder.yudao.module.information.controller.app.jobfair.vo.AppJobfairRespVO;
import cn.iocoder.yudao.module.information.dal.dataobject.careertalk.CareertalkDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.information.controller.admin.jobfair.vo.*;
import cn.iocoder.yudao.module.information.dal.dataobject.jobfair.JobfairDO;

/**
 * 招聘会 Convert
 *
 * @author SZT
 */
@Mapper
public interface JobfairConvert {

    JobfairConvert INSTANCE = Mappers.getMapper(JobfairConvert.class);

    JobfairDO convert(JobfairCreateReqVO bean);

    JobfairDO convert(JobfairUpdateReqVO bean);

    JobfairRespVO convert(JobfairDO bean);

    List<JobfairRespVO> convertList(List<JobfairDO> list);

    PageResult<JobfairRespVO> convertPage(PageResult<JobfairDO> page);

    List<JobfairExcelVO> convertList02(List<JobfairDO> list);

    //============== APP ====================
    AppJobfairConcernsVO concernsConvert(JobfairDO bean);

    AppJobfairRespVO appConvert(JobfairDO bean);

    List<AppJobfairRespVO> appConvertList(List<JobfairDO> list);


}
