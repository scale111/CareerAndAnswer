package cn.iocoder.yudao.module.forum.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * forum 错误码枚举类
 *
 * forum 系统，使用 1-030-000-000 段
 */
public interface ErrorCodeConstants {

    // ========== 帖子 1030001000 ==========
    ErrorCode POST_NOT_EXISTS = new ErrorCode(1030001000, "帖子不存在");

    // ========== 评论 1030003000 ==========
    ErrorCode COMMENT_NOT_EXISTS = new ErrorCode(1030003000, "评论不存在");
}
