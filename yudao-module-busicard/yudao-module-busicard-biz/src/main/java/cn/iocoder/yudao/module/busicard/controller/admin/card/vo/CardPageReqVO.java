package cn.iocoder.yudao.module.busicard.controller.admin.card.vo;

import lombok.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 名片分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class CardPageReqVO extends PageParam {

    @Schema(description = "名片编码")
    private String code;

    @Schema(description = "用户ID", example = "4260")
    private Long userId;

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

    @Schema(description = "手机号")
    private String phone;

    @Schema(description = "邮箱")
    private String email;

    @Schema(description = "地址")
    private String address;

    @Schema(description = "微信号")
    private String wechat;

    @Schema(description = "微信二维码")
    private String qrcode;

    /**
     * 模版code
     */
    @Schema(description = "模版code", requiredMode = Schema.RequiredMode.REQUIRED, example = "default")
    @NotEmpty(message = "模版code不能为空")
    private String templateCode;

    /**
     * 模版配置
     */
    @Schema(description = "模版配置")
    @NotBlank(message = "模版配置不能为空")
    private String templateConfig;

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