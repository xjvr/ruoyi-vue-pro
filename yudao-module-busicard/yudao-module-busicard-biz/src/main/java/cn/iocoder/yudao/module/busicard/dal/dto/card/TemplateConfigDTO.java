package cn.iocoder.yudao.module.busicard.dal.dto.card;

import lombok.Data;

import java.io.Serializable;

/**
 * 名片模版配置
 * @author rjw
 * @date 2024/12/30
 */
@Data
public class TemplateConfigDTO implements Serializable {

    /**
     * 模板编码
     */
    private String templateCode = "t1";

    /**
     * 背景编码
     */
    private String backgroundCode = "t1b1";

    /**
     * 字段控制
     */
    private FieldControlDTO fieldControls;

}
