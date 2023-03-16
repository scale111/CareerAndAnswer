package cn.iocoder.yudao.module.information.dal.mysql.recruitment;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.information.dal.dataobject.recruitment.RecruitmentDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.information.controller.admin.recruitment.vo.*;

/**
 * 招聘信息 Mapper
 *
 * @author SZT
 */
@Mapper
public interface RecruitmentMapper extends BaseMapperX<RecruitmentDO> {

    default PageResult<RecruitmentDO> selectPage(RecruitmentPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<RecruitmentDO>()
                .eqIfPresent(RecruitmentDO::getTitle, reqVO.getTitle())
                .eqIfPresent(RecruitmentDO::getPosition, reqVO.getPosition())
                .eqIfPresent(RecruitmentDO::getType, reqVO.getType())
                .eqIfPresent(RecruitmentDO::getCompany, reqVO.getCompany())
                .eqIfPresent(RecruitmentDO::getAddress, reqVO.getAddress())
                .eqIfPresent(RecruitmentDO::getRecruitsNumber, reqVO.getRecruitsNumber())
                .eqIfPresent(RecruitmentDO::getSalary, reqVO.getSalary())
                .eqIfPresent(RecruitmentDO::getEducation, reqVO.getEducation())
                .eqIfPresent(RecruitmentDO::getText, reqVO.getText())
                .betweenIfPresent(RecruitmentDO::getReleaseTime, reqVO.getReleaseTime())
                .betweenIfPresent(RecruitmentDO::getExpirationTime, reqVO.getExpirationTime())
                .eqIfPresent(RecruitmentDO::getConcernsNumber, reqVO.getConcernsNumber())
                .eqIfPresent(RecruitmentDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(RecruitmentDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(RecruitmentDO::getId));
    }

    default List<RecruitmentDO> selectList(RecruitmentExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<RecruitmentDO>()
                .eqIfPresent(RecruitmentDO::getTitle, reqVO.getTitle())
                .eqIfPresent(RecruitmentDO::getPosition, reqVO.getPosition())
                .eqIfPresent(RecruitmentDO::getType, reqVO.getType())
                .eqIfPresent(RecruitmentDO::getCompany, reqVO.getCompany())
                .eqIfPresent(RecruitmentDO::getAddress, reqVO.getAddress())
                .eqIfPresent(RecruitmentDO::getRecruitsNumber, reqVO.getRecruitsNumber())
                .eqIfPresent(RecruitmentDO::getSalary, reqVO.getSalary())
                .eqIfPresent(RecruitmentDO::getEducation, reqVO.getEducation())
                .eqIfPresent(RecruitmentDO::getText, reqVO.getText())
                .betweenIfPresent(RecruitmentDO::getReleaseTime, reqVO.getReleaseTime())
                .betweenIfPresent(RecruitmentDO::getExpirationTime, reqVO.getExpirationTime())
                .eqIfPresent(RecruitmentDO::getConcernsNumber, reqVO.getConcernsNumber())
                .eqIfPresent(RecruitmentDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(RecruitmentDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(RecruitmentDO::getId));
    }

}
