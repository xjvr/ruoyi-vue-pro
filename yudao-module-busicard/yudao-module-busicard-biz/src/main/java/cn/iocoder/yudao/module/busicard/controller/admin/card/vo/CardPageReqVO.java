package cn.iocoder.yudao.module.busicard.controller.admin.card.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 名片分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CardPageReqVO extends PageParam {

    @Schema(description = "名片编码")
    private String cardCode;

    @Schema(description = "用户ID", example = "4260")
    private Long userId;

    @Schema(description = "社交用户编号", example = "13313")
    private Long socialUserId;

    @Schema(description = "是否默认名片")
    private Boolean isDefault;

    @Schema(description = "名片类型: personal-个人 company-企业", example = "2")
    private String cardType;

    @Schema(description = "企业编号", example = "15955")
    private Long companyId;

    @Schema(description = "姓名", example = "李四")
    private String name;

    @Schema(description = "职位")
    private String title;

    @Schema(description = "头像地址")
    private String avatar;

    @Schema(description = "个人手机号")
    private String personalPhone;

    @Schema(description = "个人邮箱")
    private String personalEmail;

    @Schema(description = "个人地址")
    private String personalAddress;

    @Schema(description = "个人微信号")
    private String personalWechat;

    @Schema(description = "个人微信二维码")
    private String personalQrcode;

    @Schema(description = "工号")
    private String employeeNo;

    @Schema(description = "办公电话")
    private String officePhone;

    @Schema(description = "企业邮箱")
    private String officeEmail;

    @Schema(description = "分机号")
    private String extensionNumber;

    @Schema(description = "样式类型", example = "1")
    private String styleType;

    @Schema(description = "自定义样式配置")
    private String customStyle;

    @Schema(description = "分享图片地址", example = "https://www.iocoder.cn")
    private String shareImageUrl;

    @Schema(description = "小程序码地址", example = "https://www.iocoder.cn")
    private String qrcodeUrl;

    @Schema(description = "访问次数", example = "13449")
    private Integer visitCount;

    @Schema(description = "保存次数", example = "25416")
    private Integer saveCount;

    @Schema(description = "分享次数", example = "28212")
    private Integer shareCount;

    @Schema(description = "最后访问时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] lastVisitTime;

    @Schema(description = "最后分享时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] lastShareTime;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}