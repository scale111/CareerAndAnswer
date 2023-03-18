package cn.iocoder.yudao.module.member.controller.app.mentor;

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

import cn.iocoder.yudao.module.member.controller.app.mentor.vo.*;
import cn.iocoder.yudao.module.member.dal.dataobject.mentor.MentorDO;
import cn.iocoder.yudao.module.member.convert.mentor.MentorConvert;
import cn.iocoder.yudao.module.member.service.mentor.MentorService;

@Tag(name = "用户 APP - 导师信息")
@RestController
@RequestMapping("/member/mentor")
@Validated
public class AppMentorController {

    @Resource
    private MentorService mentorService;


    @GetMapping("/get")
    @Operation(summary = "根据id获得导师信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    public CommonResult<AppMentorRespVO> getMentor(@RequestParam("id") Long id) {
        MentorDO mentor = mentorService.getMentor(id);
        return success(MentorConvert.INSTANCE.appConvert(mentor));
    }

    @GetMapping("/getall")
    @Operation(summary = "获得所有导师信息")
    public CommonResult<List<AppMentorRespVO>> getAllMentors() {
        List<MentorDO> list = mentorService.getAllMentors();
        return success(MentorConvert.INSTANCE.appConvertList(list));
    }

//    @GetMapping("/page")
//    @Operation(summary = "获得导师信息分页")
//
//    public CommonResult<PageResult<AppMentorRespVO>> getMentorPage(@Valid AppMentorPageReqVO pageVO) {
//        PageResult<MentorDO> pageResult = mentorService.getMentorPage(pageVO);
//        return success(MentorConvert.INSTANCE.convertPage(pageResult));
//    }


}
