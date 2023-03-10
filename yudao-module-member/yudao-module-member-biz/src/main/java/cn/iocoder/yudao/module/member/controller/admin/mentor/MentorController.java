package cn.iocoder.yudao.module.member.controller.admin.mentor;

import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
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

import cn.iocoder.yudao.module.member.controller.admin.mentor.vo.*;
import cn.iocoder.yudao.module.member.dal.dataobject.mentor.MentorDO;
import cn.iocoder.yudao.module.member.convert.mentor.MentorConvert;
import cn.iocoder.yudao.module.member.service.mentor.MentorService;

@Tag(name = "管理后台 - 导师信息")
@RestController
@RequestMapping("/member/mentor")
@Validated
public class MentorController {

    @Resource
    private MentorService mentorService;

    @PostMapping("/create")
    @Operation(summary = "创建导师信息")
    @PreAuthorize("@ss.hasPermission('member:mentor:create')")
    public CommonResult<Long> createMentor(@Valid @RequestBody MentorCreateReqVO createReqVO) {
        return success(mentorService.createMentor(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新导师信息")
    @PreAuthorize("@ss.hasPermission('member:mentor:update')")
    public CommonResult<Boolean> updateMentor(@Valid @RequestBody MentorUpdateReqVO updateReqVO) {
        mentorService.updateMentor(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除导师信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('member:mentor:delete')")
    public CommonResult<Boolean> deleteMentor(@RequestParam("id") Long id) {
        mentorService.deleteMentor(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得导师信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('member:mentor:query')")
    public CommonResult<MentorRespVO> getMentor(@RequestParam("id") Long id) {
        MentorDO mentor = mentorService.getMentor(id);
        return success(MentorConvert.INSTANCE.convert(mentor));
    }

    @GetMapping("/list")
    @Operation(summary = "获得导师信息列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('member:mentor:query')")
    public CommonResult<List<MentorRespVO>> getMentorList(@RequestParam("ids") Collection<Long> ids) {
        List<MentorDO> list = mentorService.getMentorList(ids);
        return success(MentorConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得导师信息分页")
    @PreAuthorize("@ss.hasPermission('member:mentor:query')")
    public CommonResult<PageResult<MentorRespVO>> getMentorPage(@Valid MentorPageReqVO pageVO) {
        PageResult<MentorDO> pageResult = mentorService.getMentorPage(pageVO);
        return success(MentorConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出导师信息 Excel")
    @PreAuthorize("@ss.hasPermission('member:mentor:export')")
    @OperateLog(type = EXPORT)
    public void exportMentorExcel(@Valid MentorExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<MentorDO> list = mentorService.getMentorList(exportReqVO);
        // 导出 Excel
        List<MentorExcelVO> datas = MentorConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "导师信息.xls", "数据", MentorExcelVO.class, datas);
    }

}
