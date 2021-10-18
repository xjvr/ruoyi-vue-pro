package cn.iocoder.yudao.coreservice.modules.pay.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

/**
 * Pay 错误码枚举类
 *
 * pay 系统，使用 1-007-000-000 段
 */
public interface PayErrorCodeConstants {

    // ========== APP 模块 1-007-000-000 ==========
    ErrorCode PAY_APP_NOT_FOUND = new ErrorCode(1007000000, "App 不存在");
    ErrorCode PAY_APP_IS_DISABLE = new ErrorCode(1007000002, "App 已经被禁用");

    // ========== CHANNEL 模块 1-007-001-000 ==========
    ErrorCode PAY_CHANNEL_NOT_FOUND = new ErrorCode(1007001000, "支付渠道的配置不存在");
    ErrorCode PAY_CHANNEL_IS_DISABLE = new ErrorCode(1007001000, "支付渠道已经禁用");

    // ========== ORDER 模块 1-007-002-000 ==========
    ErrorCode PAY_ORDER_NOT_FOUND = new ErrorCode(100401000, "支付订单不存在");
    ErrorCode PAY_ORDER_STATUS_IS_NOT_WAITING = new ErrorCode(100401001, "支付订单不处于待支付");
    ErrorCode PAY_ORDER_STATUS_IS_NOT_SUCCESS = new ErrorCode(100401002, "支付订单不处于已支付");
    ErrorCode PAY_ORDER_ERROR_USER = new ErrorCode(100401003, "支付订单用户不正确");

    ErrorCode PAY_ORDER_EXTENSION_NOT_FOUND = new ErrorCode(100401050, "支付交易拓展单不存在");
    ErrorCode PAY_ORDER_EXTENSION_STATUS_IS_NOT_WAITING = new ErrorCode(100401051, "支付交易拓展单不处于待支付");
    ErrorCode PAY_ORDER_EXTENSION_STATUS_IS_NOT_SUCCESS = new ErrorCode(100401052, "支付订单不处于已支付");

}
