package cn.iocoder.yudao.coreservice.modules.pay.dal.dataobject.order;

import cn.iocoder.yudao.coreservice.modules.pay.dal.dataobject.merchant.PayChannelDO;
import cn.iocoder.yudao.coreservice.modules.pay.enums.order.PayOrderStatusEnum;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 支付订单拓展 DO
 *
 *
 * @author 芋道源码
 */
@TableName("pay_order_extension")
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class PayOrderExtensionDO extends BaseDO {

    /**
     * 订单拓展编号，数据库自增
     */
    private Long id;
    /**
     * 订单号，根据规则生成
     * 调用支付渠道时，使用该字段作为对接的订单号。
     * 1. 调用微信支付 https://api.mch.weixin.qq.com/pay/unifiedorder 时，使用该字段作为 out_trade_no
     * 2. 调用支付宝 https://opendocs.alipay.com/apis 时，使用该字段作为 out_trade_no
     *
     * 例如说，P202110132239124200055
     */
    private String no;
    /**
     * 订单号
     *
     * 关联 {@link PayOrderDO#getId()}
     */
    private Long orderId;
    /**
     * 渠道编号
     *
     * 关联 {@link PayChannelDO#getId()}
     */
    private Long channelId;
    /**
     * 渠道编码
     */
    private Integer channelCode;
    /**
     * 客户端 IP
     */
    private String clientIp;
    /**
     * 支付状态
     *
     * 枚举 {@link PayOrderStatusEnum}
     * 注意，只包含上述枚举的 WAITING 和 SUCCESS
     */
    private Integer status;
    /**
     * 支付渠道异步通知的内容
     *
     * 在支持成功后，会记录回调的数据
     */
    private String channelCallbackData;

}
