package cn.iocoder.yudao.module.busicard.controller.admin.card.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import com.alibaba.excel.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Schema(description = "管理后台 - 名片 Response VO")
@Data
public class CardRespVO {

    @Schema(description = "名片ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "5147")
    @ExcelProperty("名片ID")
    private Long id;

    @Schema(description = "名片编码", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("名片编码")
    private String code;

    @Schema(description = "用户ID", requiredMode = Schema.RequiredMode.REQUIRED, example = "4260")
    @ExcelProperty("用户ID")
    private Long userId;

    @Schema(description = "社交用户编号", example = "13313")
    @ExcelProperty("社交用户编号")
    private Long socialUserId;

    @Schema(description = "名片类型: personal-个人 company-企业", requiredMode = Schema.RequiredMode.REQUIRED, example = "2")
    @ExcelProperty("名片类型: personal-个人 company-企业")
    private String cardType;

    @Schema(description = "企业编号", example = "15955")
    @ExcelProperty("企业编号")
    private Long companyId;

    @Schema(description = "姓名", requiredMode = Schema.RequiredMode.REQUIRED, example = "李四")
    @ExcelProperty("姓名")
    private String name;

    @Schema(description = "职位")
    @ExcelProperty("职位")
    private String title;

    @Schema(description = "头像地址")
    @ExcelProperty("头像地址")
    private String avatar;

    @Schema(description = "手机号")
    @ExcelProperty("手机号")
    private String phone;

    @Schema(description = "邮箱")
    @ExcelProperty("邮箱")
    private String email;

    @Schema(description = "地址")
    @ExcelProperty("地址")
    private String address;

    @Schema(description = "微信号")
    @ExcelProperty("微信号")
    private String wechat;

    @Schema(description = "微信二维码")
    @ExcelProperty("微信二维码")
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
    @ExcelProperty("分享图片地址")
    private String shareImageUrl;

    @Schema(description = "小程序码地址", example = "https://www.iocoder.cn")
    @ExcelProperty("小程序码地址")
    private String qrcodeUrl;

    @Schema(description = "访问次数", example = "13449")
    @ExcelProperty("访问次数")
    private Integer visitCount;

    @Schema(description = "保存次数", example = "25416")
    @ExcelProperty("保存次数")
    private Integer saveCount;

    @Schema(description = "分享次数", example = "28212")
    @ExcelProperty("分享次数")
    private Integer shareCount;

    @Schema(description = "最后访问时间")
    @ExcelProperty("最后访问时间")
    private LocalDateTime lastVisitTime;

    @Schema(description = "最后分享时间")
    @ExcelProperty("最后分享时间")
    private LocalDateTime lastShareTime;

    @Schema(description = "创建时间", requiredMode = Schema.RequiredMode.REQUIRED)
    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}