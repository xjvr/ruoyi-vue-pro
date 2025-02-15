package cn.iocoder.yudao.module.busicard.dal.dataobject.card;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 名片 DO
 *
 * @author Ecat
 */
@TableName("busicard_card")
@KeySequence("busicard_card_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardDO extends BaseDO {

    /**
     * 名片ID
     */
    @TableId
    private Long id;
    /**
     * 名片编码
     */
    private String code;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 是否默认名片
     */
    private Boolean isDefault;
    /**
     * 名片类型: personal-个人 company-企业
     */
    private String cardType;
    /**
     * 企业编号
     */
    private Long companyId;
    /**
     * 姓名
     */
    private String name;
    /**
     * 职位
     */
    private String title;
    /**
     * 头像地址
     */
    private String avatar;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 地址
     */
    private String address;
    /**
     * 微信号
     */
    private String wechat;
    /**
     * 微信二维码
     */
    private String qrcode;

    /**
     * 模版code
     */
    private String templateCode;

    /**
     * 模版配置
     */
    private String templateConfig;

    /**
     * 分享图片地址
     */
    private String shareImageUrl;
    /**
     * 小程序码地址
     */
    private String qrcodeUrl;
    /**
     * 访问次数
     */
    private Integer visitCount;
    /**
     * 保存次数
     */
    private Integer saveCount;
    /**
     * 分享次数
     */
    private Integer shareCount;
    /**
     * 最后访问时间
     */
    private LocalDateTime lastVisitTime;
    /**
     * 最后分享时间
     */
    private LocalDateTime lastShareTime;

}