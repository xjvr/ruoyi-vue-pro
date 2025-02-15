package cn.iocoder.yudao.module.busicard.controller.app.card.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Schema(description = "用户 APP - 名片样式修改 Request VO")
@Data
public class AppCardStyleReqVO {

    @Schema(description = "名片id")
    @NotBlank(message = "名片id不能为空")
    private Long id;

    @Schema(description = "用户ID", example = "4260")
    private Long userId;

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

}