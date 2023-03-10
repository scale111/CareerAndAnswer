package cn.iocoder.yudao.module.member.controller.admin.student;

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

import cn.iocoder.yudao.module.member.controller.admin.student.vo.*;
import cn.iocoder.yudao.module.member.dal.dataobject.student.StudentDO;
import cn.iocoder.yudao.module.member.convert.student.StudentConvert;
import cn.iocoder.yudao.module.member.service.student.StudentService;

@Tag(name = "管理后台 - 学生信息")
@RestController
@RequestMapping("/member/student")
@Validated
public class StudentController {

    @Resource
    private StudentService studentService;

    @PostMapping("/create")
    @Operation(summary = "创建学生信息")
    @PreAuthorize("@ss.hasPermission('member:student:create')")
    public CommonResult<Long> createStudent(@Valid @RequestBody StudentCreateReqVO createReqVO) {
        return success(studentService.createStudent(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新学生信息")
    @PreAuthorize("@ss.hasPermission('member:student:update')")
    public CommonResult<Boolean> updateStudent(@Valid @RequestBody StudentUpdateReqVO updateReqVO) {
        studentService.updateStudent(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除学生信息")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('member:student:delete')")
    public CommonResult<Boolean> deleteStudent(@RequestParam("id") Long id) {
        studentService.deleteStudent(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得学生信息")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('member:student:query')")
    public CommonResult<StudentRespVO> getStudent(@RequestParam("id") Long id) {
        StudentDO student = studentService.getStudent(id);
        return success(StudentConvert.INSTANCE.convert(student));
    }

    @GetMapping("/list")
    @Operation(summary = "获得学生信息列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('member:student:query')")
    public CommonResult<List<StudentRespVO>> getStudentList(@RequestParam("ids") Collection<Long> ids) {
        List<StudentDO> list = studentService.getStudentList(ids);
        return success(StudentConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得学生信息分页")
    @PreAuthorize("@ss.hasPermission('member:student:query')")
    public CommonResult<PageResult<StudentRespVO>> getStudentPage(@Valid StudentPageReqVO pageVO) {
        PageResult<StudentDO> pageResult = studentService.getStudentPage(pageVO);
        return success(StudentConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出学生信息 Excel")
    @PreAuthorize("@ss.hasPermission('member:student:export')")
    @OperateLog(type = EXPORT)
    public void exportStudentExcel(@Valid StudentExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<StudentDO> list = studentService.getStudentList(exportReqVO);
        // 导出 Excel
        List<StudentExcelVO> datas = StudentConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "学生信息.xls", "数据", StudentExcelVO.class, datas);
    }

}
