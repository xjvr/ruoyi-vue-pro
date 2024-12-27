package cn.iocoder.yudao.module.busicard.controller.app.card.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Schema(description = "用户 APP - 名片新增/修改 Request VO")
@Data
public class AppCardSaveReqVO {

    @Schema(description = "用户ID", example = "4260")
    private Long userId;

    @Schema(description = "是否默认名片", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "是否默认名片不能为空")
    private Boolean isDefault;

    @Schema(description = "名片类型: personal-个人 company-企业", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @NotEmpty(message = "名片类型不能为空")
    private String cardType;

    @Schema(description = "企业编号", example = "15955")
    private Long companyId;

    @Schema(description = "姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "李四")
    @NotEmpty(message = "姓名不能为空")
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

    @Schema(description = "样式类型", requiredMode = Schema.RequiredMode.REQUIRED, example = "1")
    @NotEmpty(message = "样式类型不能为空")
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
    private LocalDateTime lastVisitTime;

    @Schema(description = "最后分享时间")
    private LocalDateTime lastShareTime;

}