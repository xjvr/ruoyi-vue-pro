package cn.iocoder.yudao.module.busicard.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * Member 错误码枚举类
 * <p>
 * member 系统，使用 1-004-000-000 段
 */
public interface ErrorCodeConstants {

    //========== 用户分组 1-004-012-000 ==========

    ErrorCode CARD_NOT_EXISTS = new ErrorCode(1_099_001_001, "名片不存在");

}
