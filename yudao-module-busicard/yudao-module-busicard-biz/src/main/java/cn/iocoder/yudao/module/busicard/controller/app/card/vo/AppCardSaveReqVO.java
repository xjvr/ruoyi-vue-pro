package cn.iocoder.yudao.module.busicard.controller.app.card.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
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

    @Schema(description = "最后访问时间")
    private LocalDateTime lastVisitTime;

    @Schema(description = "最后分享时间")
    private LocalDateTime lastShareTime;

}