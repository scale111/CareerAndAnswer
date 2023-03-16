package cn.iocoder.yudao.module.information.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * Information 错误码枚举类
 *
 * information 系统，使用 1-020-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== 招聘信息 1020001000 ==========
    ErrorCode RECRUITMENT_NOT_EXISTS = new ErrorCode(1020001000, "招聘信息不存在");

    // ========== 招聘会 1020003000 ==========
    ErrorCode JOBFAIR_NOT_EXISTS = new ErrorCode(1020003000, "招聘会不存在");

    // ========== 宣讲会 1020005000 ==========
    ErrorCode CAREERTALK_NOT_EXISTS = new ErrorCode(1020005000, "宣讲会不存在");
}
