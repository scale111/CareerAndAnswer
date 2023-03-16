package cn.iocoder.yudao.module.information.controller.admin.recruitment;

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

import cn.iocoder.yudao.module.information.controller.admin.recruitment.vo.*;
import cn.iocoder.yudao.module.information.dal.dataobject.recruitment.RecruitmentDO;
import cn.iocoder.yudao.module.information.convert.recruitment.RecruitmentConvert;
import cn.iocoder.yudao.module.information.service.recruitment.RecruitmentService;

@Tag(name = "管理后台 - 招聘信息")
@RestController
@RequestMapping("/information/recruitment")
@Validated
public class RecruitmentController {

    @Resource
    private RecruitmentService recruitmentService;

    @PostMapping("/create")
    @Operation(summary = "创建招聘信息")
    @PreAuthorize("@ss.hasPermission('information:recruitment:create')")
    public CommonResult<Long> createRecruitment(@Valid @RequestBody RecruitmentCreateReqVO createReqVO) {
        return success(recruitmentService.createRecruitment(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新招聘信息")
    @PreAuthorize("@ss.hasPermission('information:recruitment:update')")
    public CommonResult<Boolean> updateRecruitment(@Valid @RequestBody RecruitmentUpdateReqVO updateReqVO) {
        recruitmentService.updateRecruitment(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除招聘信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('information:recruitment:delete')")
    public CommonResult<Boolean> deleteRecruitment(@RequestParam("id") Long id) {
        recruitmentService.deleteRecruitment(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得招聘信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('information:recruitment:query')")
    public CommonResult<RecruitmentRespVO> getRecruitment(@RequestParam("id") Long id) {
        RecruitmentDO recruitment = recruitmentService.getRecruitment(id);
        return success(RecruitmentConvert.INSTANCE.convert(recruitment));
    }

    @GetMapping("/list")
    @Operation(summary = "获得招聘信息列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('information:recruitment:query')")
    public CommonResult<List<RecruitmentRespVO>> getRecruitmentList(@RequestParam("ids") Collection<Long> ids) {
        List<RecruitmentDO> list = recruitmentService.getRecruitmentList(ids);
        return success(RecruitmentConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得招聘信息分页")
    @PreAuthorize("@ss.hasPermission('information:recruitment:query')")
    public CommonResult<PageResult<RecruitmentRespVO>> getRecruitmentPage(@Valid RecruitmentPageReqVO pageVO) {
        PageResult<RecruitmentDO> pageResult = recruitmentService.getRecruitmentPage(pageVO);
        return success(RecruitmentConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出招聘信息 Excel")
    @PreAuthorize("@ss.hasPermission('information:recruitment:export')")
    @OperateLog(type = EXPORT)
    public void exportRecruitmentExcel(@Valid RecruitmentExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<RecruitmentDO> list = recruitmentService.getRecruitmentList(exportReqVO);
        // 导出 Excel
        List<RecruitmentExcelVO> datas = RecruitmentConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "招聘信息.xls", "数据", RecruitmentExcelVO.class, datas);
    }

}
