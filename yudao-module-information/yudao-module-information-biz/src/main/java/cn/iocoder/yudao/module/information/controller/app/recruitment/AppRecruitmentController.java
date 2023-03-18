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

    @GetMapping("/getall")
    @Operation(summary = "获得全部招聘信息")
    public CommonResult<List<AppRecruitmentRespVO>> getAllRecruitments() {
        List<RecruitmentDO> list = recruitmentService.getAllRecruitments();
        return success(RecruitmentConvert.INSTANCE.appConvertList(list));
    }

    @GetMapping("/get")
    @Operation(summary = "根据id获得招聘信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<AppRecruitmentRespVO> getRecruitment(@RequestParam("id") Long id) {
        RecruitmentDO recruitmentDO = recruitmentService.getRecruitment(id);
        return success(RecruitmentConvert.INSTANCE.appConvert(recruitmentDO));
    }

    @GetMapping("/follow")
    @Operation(summary = "关注招聘信息")
    public CommonResult<Boolean> follow(@RequestParam("id") Long id) {
        recruitmentService.follow(id);
        return success(true);
    }

    @GetMapping("/unfollow")
    @Operation(summary = "取消关注招聘信息")
    public CommonResult<Boolean> unfollow(@RequestParam("id") Long id) {
        recruitmentService.unfollow(id);
        return success(true);
    }


}
