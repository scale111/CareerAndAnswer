package cn.iocoder.yudao.module.information.controller.admin.jobfair;

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

import cn.iocoder.yudao.module.information.controller.admin.jobfair.vo.*;
import cn.iocoder.yudao.module.information.dal.dataobject.jobfair.JobfairDO;
import cn.iocoder.yudao.module.information.convert.jobfair.JobfairConvert;
import cn.iocoder.yudao.module.information.service.jobfair.JobfairService;

@Tag(name = "管理后台 - 招聘会")
@RestController
@RequestMapping("/information/jobfair")
@Validated
public class JobfairController {

    @Resource
    private JobfairService jobfairService;

    @PostMapping("/create")
    @Operation(summary = "创建招聘会")
    @PreAuthorize("@ss.hasPermission('information:jobfair:create')")
    public CommonResult<Long> createJobfair(@Valid @RequestBody JobfairCreateReqVO createReqVO) {
        return success(jobfairService.createJobfair(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新招聘会")
    @PreAuthorize("@ss.hasPermission('information:jobfair:update')")
    public CommonResult<Boolean> updateJobfair(@Valid @RequestBody JobfairUpdateReqVO updateReqVO) {
        jobfairService.updateJobfair(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除招聘会")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('information:jobfair:delete')")
    public CommonResult<Boolean> deleteJobfair(@RequestParam("id") Long id) {
        jobfairService.deleteJobfair(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得招聘会")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('information:jobfair:query')")
    public CommonResult<JobfairRespVO> getJobfair(@RequestParam("id") Long id) {
        JobfairDO jobfair = jobfairService.getJobfair(id);
        return success(JobfairConvert.INSTANCE.convert(jobfair));
    }

    @GetMapping("/list")
    @Operation(summary = "获得招聘会列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('information:jobfair:query')")
    public CommonResult<List<JobfairRespVO>> getJobfairList(@RequestParam("ids") Collection<Long> ids) {
        List<JobfairDO> list = jobfairService.getJobfairList(ids);
        return success(JobfairConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得招聘会分页")
    @PreAuthorize("@ss.hasPermission('information:jobfair:query')")
    public CommonResult<PageResult<JobfairRespVO>> getJobfairPage(@Valid JobfairPageReqVO pageVO) {
        PageResult<JobfairDO> pageResult = jobfairService.getJobfairPage(pageVO);
        return success(JobfairConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出招聘会 Excel")
    @PreAuthorize("@ss.hasPermission('information:jobfair:export')")
    @OperateLog(type = EXPORT)
    public void exportJobfairExcel(@Valid JobfairExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<JobfairDO> list = jobfairService.getJobfairList(exportReqVO);
        // 导出 Excel
        List<JobfairExcelVO> datas = JobfairConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "招聘会.xls", "数据", JobfairExcelVO.class, datas);
    }

}
