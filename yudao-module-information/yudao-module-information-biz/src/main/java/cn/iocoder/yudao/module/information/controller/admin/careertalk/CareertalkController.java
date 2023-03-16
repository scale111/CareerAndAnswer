package cn.iocoder.yudao.module.information.controller.admin.careertalk;

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

import cn.iocoder.yudao.module.information.controller.admin.careertalk.vo.*;
import cn.iocoder.yudao.module.information.dal.dataobject.careertalk.CareertalkDO;
import cn.iocoder.yudao.module.information.convert.careertalk.CareertalkConvert;
import cn.iocoder.yudao.module.information.service.careertalk.CareertalkService;

@Tag(name = "管理后台 - 宣讲会")
@RestController
@RequestMapping("/information/careertalk")
@Validated
public class CareertalkController {

    @Resource
    private CareertalkService careertalkService;

    @PostMapping("/create")
    @Operation(summary = "创建宣讲会")
    @PreAuthorize("@ss.hasPermission('information:careertalk:create')")
    public CommonResult<Long> createCareertalk(@Valid @RequestBody CareertalkCreateReqVO createReqVO) {
        return success(careertalkService.createCareertalk(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新宣讲会")
    @PreAuthorize("@ss.hasPermission('information:careertalk:update')")
    public CommonResult<Boolean> updateCareertalk(@Valid @RequestBody CareertalkUpdateReqVO updateReqVO) {
        careertalkService.updateCareertalk(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除宣讲会")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('information:careertalk:delete')")
    public CommonResult<Boolean> deleteCareertalk(@RequestParam("id") Long id) {
        careertalkService.deleteCareertalk(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得宣讲会")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('information:careertalk:query')")
    public CommonResult<CareertalkRespVO> getCareertalk(@RequestParam("id") Long id) {
        CareertalkDO careertalk = careertalkService.getCareertalk(id);
        return success(CareertalkConvert.INSTANCE.convert(careertalk));
    }

    @GetMapping("/list")
    @Operation(summary = "获得宣讲会列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('information:careertalk:query')")
    public CommonResult<List<CareertalkRespVO>> getCareertalkList(@RequestParam("ids") Collection<Long> ids) {
        List<CareertalkDO> list = careertalkService.getCareertalkList(ids);
        return success(CareertalkConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得宣讲会分页")
    @PreAuthorize("@ss.hasPermission('information:careertalk:query')")
    public CommonResult<PageResult<CareertalkRespVO>> getCareertalkPage(@Valid CareertalkPageReqVO pageVO) {
        PageResult<CareertalkDO> pageResult = careertalkService.getCareertalkPage(pageVO);
        return success(CareertalkConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出宣讲会 Excel")
    @PreAuthorize("@ss.hasPermission('information:careertalk:export')")
    @OperateLog(type = EXPORT)
    public void exportCareertalkExcel(@Valid CareertalkExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<CareertalkDO> list = careertalkService.getCareertalkList(exportReqVO);
        // 导出 Excel
        List<CareertalkExcelVO> datas = CareertalkConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "宣讲会.xls", "数据", CareertalkExcelVO.class, datas);
    }

}
