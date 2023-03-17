package cn.iocoder.yudao.module.information.dal.mysql.careertalk;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.information.dal.dataobject.careertalk.CareertalkDO;
import cn.iocoder.yudao.module.information.dal.dataobject.recruitment.RecruitmentDO;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.information.controller.admin.careertalk.vo.*;

/**
 * 宣讲会 Mapper
 *
 * @author SZT
 */
@Mapper
public interface CareertalkMapper extends BaseMapperX<CareertalkDO> {

    /**
     * 关注宣讲会
     * 根据id让concerns_number加1
     * @param id
     */
    default void follow(Long id) {
        LambdaUpdateWrapper<CareertalkDO> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(CareertalkDO::getId, id)
                .setSql("concerns_number = concerns_number + 1");
        this.update(null, wrapper);
    }

    /**
     * 取消关注宣讲会
     * @param id
     */
    default void unfollow(Long id) {
        LambdaUpdateWrapper<CareertalkDO> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(CareertalkDO::getId, id)
                .setSql("concerns_number = concerns_number - 1");
        this.update(null, wrapper);
    }

    default PageResult<CareertalkDO> selectPage(CareertalkPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CareertalkDO>()
                .eqIfPresent(CareertalkDO::getTitle, reqVO.getTitle())
                .likeIfPresent(CareertalkDO::getName, reqVO.getName())
                .eqIfPresent(CareertalkDO::getAddress, reqVO.getAddress())
                .eqIfPresent(CareertalkDO::getSpeaker, reqVO.getSpeaker())
                .eqIfPresent(CareertalkDO::getTopic, reqVO.getTopic())
                .eqIfPresent(CareertalkDO::getOrganizer, reqVO.getOrganizer())
                .eqIfPresent(CareertalkDO::getEmail, reqVO.getEmail())
                .eqIfPresent(CareertalkDO::getText, reqVO.getText())
                .betweenIfPresent(CareertalkDO::getStartTime, reqVO.getStartTime())
                .betweenIfPresent(CareertalkDO::getEndTime, reqVO.getEndTime())
                .eqIfPresent(CareertalkDO::getConcernsNumber, reqVO.getConcernsNumber())
                .eqIfPresent(CareertalkDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(CareertalkDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CareertalkDO::getId));
    }

    default List<CareertalkDO> selectList(CareertalkExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<CareertalkDO>()
                .eqIfPresent(CareertalkDO::getTitle, reqVO.getTitle())
                .likeIfPresent(CareertalkDO::getName, reqVO.getName())
                .eqIfPresent(CareertalkDO::getAddress, reqVO.getAddress())
                .eqIfPresent(CareertalkDO::getSpeaker, reqVO.getSpeaker())
                .eqIfPresent(CareertalkDO::getTopic, reqVO.getTopic())
                .eqIfPresent(CareertalkDO::getOrganizer, reqVO.getOrganizer())
                .eqIfPresent(CareertalkDO::getEmail, reqVO.getEmail())
                .eqIfPresent(CareertalkDO::getText, reqVO.getText())
                .betweenIfPresent(CareertalkDO::getStartTime, reqVO.getStartTime())
                .betweenIfPresent(CareertalkDO::getEndTime, reqVO.getEndTime())
                .eqIfPresent(CareertalkDO::getConcernsNumber, reqVO.getConcernsNumber())
                .eqIfPresent(CareertalkDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(CareertalkDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CareertalkDO::getId));
    }

}
