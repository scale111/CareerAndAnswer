package cn.iocoder.yudao.module.information.controller.app.recruitment;

import cn.iocoder.yudao.module.information.dal.mysql.recruitment.RecruitmentMapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.module.information.controller.app.recruitment.vo.*;
import cn.iocoder.yudao.module.information.dal.dataobject.recruitment.RecruitmentDO;
import cn.iocoder.yudao.module.information.convert.recruitment.RecruitmentConvert;
import cn.iocoder.yudao.module.information.service.recruitment.RecruitmentService;

@Tag(name = "用户 APP - 招聘信息")
@RestController
@RequestMapping("/information/recruitment")
@Validated
public class AppRecruitmentController {

    @Resource
    private RecruitmentService recruitmentService;
    @Resource
    private RecruitmentMapper recruitmentMapper;

    @GetMapping("/getall")
    @Operation(summary = "获得全部招聘信息")
    public CommonResult<List<AppRecruitmentRespVO>> getAllRecruitments() {
        List<RecruitmentDO> list = recruitmentService.getAllRecruitments();
        return success(RecruitmentConvert.INSTANCE.appConvertList(list));
    }

    @GetMapping("/follow")
    @Operation(summary = "关注招聘信息")
    public CommonResult<AppRecruitmentConcernsVO> follow(@RequestParam("id") Long id) {
        UpdateWrapper<RecruitmentDO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",id).setSql("concerns_number = concerns_number + 1");
        recruitmentMapper.update(null,updateWrapper);

        RecruitmentDO recruitmentDO = recruitmentService.getRecruitment(id);
        return success(RecruitmentConvert.INSTANCE.concernsConvert(recruitmentDO));
    }

    @GetMapping("/unfollow")
    @Operation(summary = "取消关注招聘信息")
    public CommonResult<AppRecruitmentConcernsVO> unfollow(@RequestParam("id") Long id) {
        UpdateWrapper<RecruitmentDO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",id).setSql("concerns_number = concerns_number - 1");
        recruitmentMapper.update(null,updateWrapper);

        RecruitmentDO recruitmentDO = recruitmentService.getRecruitment(id);
        return success(RecruitmentConvert.INSTANCE.concernsConvert(recruitmentDO));
    }




}
