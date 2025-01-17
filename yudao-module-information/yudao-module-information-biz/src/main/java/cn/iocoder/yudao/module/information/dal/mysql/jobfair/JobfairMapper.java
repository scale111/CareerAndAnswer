package cn.iocoder.yudao.module.information.dal.mysql.jobfair;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.information.dal.dataobject.jobfair.JobfairDO;
import cn.iocoder.yudao.module.information.dal.dataobject.recruitment.RecruitmentDO;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.information.controller.admin.jobfair.vo.*;

/**
 * 招聘会 Mapper
 *
 * @author SZT
 */
@Mapper
public interface JobfairMapper extends BaseMapperX<JobfairDO> {

    /**
     * 关注招聘会
     * 根据id让concerns_number加1
     * @param id
     */
    default void follow(Long id) {
        LambdaUpdateWrapper<JobfairDO> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(JobfairDO::getId, id)
                .setSql("concerns_number = concerns_number + 1");
        this.update(null, wrapper);
    }

    /**
     * 取消关注招聘会
     * @param id
     */
    default void unfollow(Long id) {
        LambdaUpdateWrapper<JobfairDO> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(JobfairDO::getId, id)
                .setSql("concerns_number = concerns_number - 1");
        this.update(null, wrapper);
    }

    default PageResult<JobfairDO> selectPage(JobfairPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<JobfairDO>()
                .eqIfPresent(JobfairDO::getTitle, reqVO.getTitle())
                .likeIfPresent(JobfairDO::getName, reqVO.getName())
                .eqIfPresent(JobfairDO::getCity, reqVO.getCity())
                .eqIfPresent(JobfairDO::getAddress, reqVO.getAddress())
                .eqIfPresent(JobfairDO::getType, reqVO.getType())
                .eqIfPresent(JobfairDO::getHostUnit, reqVO.getHostUnit())
                .eqIfPresent(JobfairDO::getUndertakingUnit, reqVO.getUndertakingUnit())
                .eqIfPresent(JobfairDO::getUnitNumber, reqVO.getUnitNumber())
                .eqIfPresent(JobfairDO::getConcernsNumber, reqVO.getConcernsNumber())
                .eqIfPresent(JobfairDO::getText, reqVO.getText())
                .betweenIfPresent(JobfairDO::getStartTime, reqVO.getStartTime())
                .betweenIfPresent(JobfairDO::getEndTime, reqVO.getEndTime())
                .eqIfPresent(JobfairDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(JobfairDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(JobfairDO::getId));
    }

    default List<JobfairDO> selectList(JobfairExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<JobfairDO>()
                .eqIfPresent(JobfairDO::getTitle, reqVO.getTitle())
                .likeIfPresent(JobfairDO::getName, reqVO.getName())
                .eqIfPresent(JobfairDO::getCity, reqVO.getCity())
                .eqIfPresent(JobfairDO::getAddress, reqVO.getAddress())
                .eqIfPresent(JobfairDO::getType, reqVO.getType())
                .eqIfPresent(JobfairDO::getHostUnit, reqVO.getHostUnit())
                .eqIfPresent(JobfairDO::getUndertakingUnit, reqVO.getUndertakingUnit())
                .eqIfPresent(JobfairDO::getUnitNumber, reqVO.getUnitNumber())
                .eqIfPresent(JobfairDO::getConcernsNumber, reqVO.getConcernsNumber())
                .eqIfPresent(JobfairDO::getText, reqVO.getText())
                .betweenIfPresent(JobfairDO::getStartTime, reqVO.getStartTime())
                .betweenIfPresent(JobfairDO::getEndTime, reqVO.getEndTime())
                .eqIfPresent(JobfairDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(JobfairDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(JobfairDO::getId));
    }

}
