package cn.iocoder.yudao.module.member.controller.app.student;

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

import cn.iocoder.yudao.module.member.controller.app.student.vo.*;
import cn.iocoder.yudao.module.member.dal.dataobject.student.StudentDO;
import cn.iocoder.yudao.module.member.convert.student.StudentConvert;
import cn.iocoder.yudao.module.member.service.student.StudentService;

@Tag(name = "用户 APP - 学生信息")
@RestController
@RequestMapping("/member/student")
@Validated
public class AppStudentController {

    @Resource
    private StudentService studentService;

//    @PutMapping("/update")
//    @Operation(summary = "更新学生信息")
//
//    public CommonResult<Boolean> updateStudent(@Valid @RequestBody AppStudentUpdateReqVO updateReqVO) {
//        studentService.updateStudent(updateReqVO);
//        return success(true);
//    }

    @GetMapping("/get")
    @Operation(summary = "根据mobile获得学生信息")
    @Parameter(name = "mobile", description = "手机号", required = true, example = "15888806517")
    public CommonResult<AppStudentRespVO> getStudent(@RequestParam("mobile") String mobile) {
        StudentDO student = studentService.getStudentByMobile(mobile);
        return success(StudentConvert.INSTANCE.appConvert(student));
    }

}
