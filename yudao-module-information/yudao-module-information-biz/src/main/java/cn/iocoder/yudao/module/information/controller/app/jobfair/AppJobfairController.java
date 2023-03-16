package cn.iocoder.yudao.module.information.controller.app.jobfair;

import cn.iocoder.yudao.module.information.controller.app.recruitment.vo.AppRecruitmentConcernsVO;
import cn.iocoder.yudao.module.information.convert.recruitment.RecruitmentConvert;
import cn.iocoder.yudao.module.information.dal.dataobject.recruitment.RecruitmentDO;
import cn.iocoder.yudao.module.information.dal.mysql.jobfair.JobfairMapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.information.controller.app.jobfair.vo.*;
import cn.iocoder.yudao.module.information.dal.dataobject.jobfair.JobfairDO;
import cn.iocoder.yudao.module.information.convert.jobfair.JobfairConvert;
import cn.iocoder.yudao.module.information.service.jobfair.JobfairService;

@Tag(name = "用户 APP - 招聘会")
@RestController
@RequestMapping("/information/jobfair")
@Validated
public class AppJobfairController {

    @Resource
    private JobfairService jobfairService;
    @Resource
    private JobfairMapper jobfairMapper;

    @GetMapping("/getall")
    @Operation(summary = "获得招聘会列表")
    public CommonResult<List<AppJobfairRespVO>> getAllJobfairs() {
        List<JobfairDO> list = jobfairService.getAllJobfairs();
        return success(JobfairConvert.INSTANCE.appConvertList(list));
    }

    @GetMapping("/follow")
    @Operation(summary = "关注招聘会")
    public CommonResult<AppJobfairConcernsVO> follow(@RequestParam("id") Long id) {
        UpdateWrapper<JobfairDO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",id).setSql("concerns_number = concerns_number + 1");
        jobfairMapper.update(null,updateWrapper);

        JobfairDO jobfairDO = jobfairService.getJobfair(id);
        return success(JobfairConvert.INSTANCE.concernsConvert(jobfairDO));
    }

    @GetMapping("/unfollow")
    @Operation(summary = "取消关注招聘会")
    public CommonResult<AppJobfairConcernsVO> unfollow(@RequestParam("id") Long id) {
        UpdateWrapper<JobfairDO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",id).setSql("concerns_number = concerns_number - 1");
        jobfairMapper.update(null,updateWrapper);

        JobfairDO jobfairDO = jobfairService.getJobfair(id);
        return success(JobfairConvert.INSTANCE.concernsConvert(jobfairDO));
    }


}
