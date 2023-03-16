package cn.iocoder.yudao.module.information.controller.app.careertalk;

import cn.iocoder.yudao.module.information.controller.app.jobfair.vo.AppJobfairConcernsVO;
import cn.iocoder.yudao.module.information.convert.jobfair.JobfairConvert;
import cn.iocoder.yudao.module.information.dal.dataobject.jobfair.JobfairDO;
import cn.iocoder.yudao.module.information.dal.mysql.careertalk.CareertalkMapper;
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

import cn.iocoder.yudao.module.information.controller.app.careertalk.vo.*;
import cn.iocoder.yudao.module.information.dal.dataobject.careertalk.CareertalkDO;
import cn.iocoder.yudao.module.information.convert.careertalk.CareertalkConvert;
import cn.iocoder.yudao.module.information.service.careertalk.CareertalkService;

@Tag(name = "用户 APP - 宣讲会")
@RestController
@RequestMapping("/information/careertalk")
@Validated
public class AppCareertalkController {

    @Resource
    private CareertalkService careertalkService;

    @Resource
    private CareertalkMapper careertalkMapper;


    @GetMapping("/getall")
    @Operation(summary = "获得宣讲会列表")
    public CommonResult<List<AppCareertalkRespVO>> getAllCareertalks() {
        List<CareertalkDO> list = careertalkService.getAllCareertalks();
        return success(CareertalkConvert.INSTANCE.appConvertList(list));
    }

    @GetMapping("/follow")
    @Operation(summary = "关注宣讲会")
    public CommonResult<AppCareertalkConcernsVO> follow(@RequestParam("id") Long id) {
        UpdateWrapper<CareertalkDO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",id).setSql("concerns_number = concerns_number + 1");
        careertalkMapper.update(null,updateWrapper);

        CareertalkDO careertalkDO = careertalkService.getCareertalk(id);
        return success(CareertalkConvert.INSTANCE.concernsConvert(careertalkDO));
    }

    @GetMapping("/unfollow")
    @Operation(summary = "取消关注宣讲会")
    public CommonResult<AppCareertalkConcernsVO> unfollow(@RequestParam("id") Long id) {
        UpdateWrapper<CareertalkDO> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",id).setSql("concerns_number = concerns_number - 1");
        careertalkMapper.update(null,updateWrapper);

        CareertalkDO careertalkDO = careertalkService.getCareertalk(id);
        return success(CareertalkConvert.INSTANCE.concernsConvert(careertalkDO));
    }

}
