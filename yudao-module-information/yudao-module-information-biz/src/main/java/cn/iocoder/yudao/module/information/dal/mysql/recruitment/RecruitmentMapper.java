package cn.iocoder.yudao.module.information.dal.mysql.recruitment;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.information.dal.dataobject.recruitment.RecruitmentDO;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.information.controller.admin.recruitment.vo.*;

/**
 * 招聘信息 Mapper
 *
 * @author SZT
 */
@Mapper
public interface RecruitmentMapper extends BaseMapperX<RecruitmentDO> {

    /**
     * 关注招聘信息
     * 根据id让concerns_number加1
     * @param id
     */
    default void follow(Long id) {
        LambdaUpdateWrapper<RecruitmentDO> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(RecruitmentDO::getId, id)
                .setSql("concerns_number = concerns_number + 1");
        this.update(null, wrapper);
    }

    /**
     * 取消关注招聘信息
     * @param id
     */
    default void unfollow(Long id) {
        LambdaUpdateWrapper<RecruitmentDO> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(RecruitmentDO::getId, id)
                .setSql("concerns_number = concerns_number - 1");
        this.update(null, wrapper);
    }

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
