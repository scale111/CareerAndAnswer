package cn.iocoder.yudao.module.information.controller.app.careertalk;

import cn.iocoder.yudao.module.information.dal.mysql.careertalk.CareertalkMapper;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

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

    @GetMapping("/get")
    @Operation(summary = "根据id获得宣讲会信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<AppCareertalkRespVO> getCareertalk(@RequestParam("id") Long id) {
        CareertalkDO careertalkDO = careertalkService.getCareertalk(id);
        return success(CareertalkConvert.INSTANCE.appConvert(careertalkDO));
    }

    @GetMapping("/follow")
    @Operation(summary = "关注宣讲会")
    public CommonResult<Boolean> follow(@RequestParam("id") Long id) {
        careertalkService.follow(id);
        return success(true);
    }

    @GetMapping("/unfollow")
    @Operation(summary = "取消关注宣讲会")
    public CommonResult<Boolean> unfollow(@RequestParam("id") Long id) {
        careertalkService.unfollow(id);
        return success(true);
    }

}
