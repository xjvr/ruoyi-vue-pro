package cn.iocoder.yudao.module.busicard.dal.dto.card;

import lombok.Data;

import java.io.Serializable;

/**
 * 名片字段控制
 * @author rjw
 * @date 2024/12/30
 */
@Data
public class FieldControlDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Boolean title = true;

    private Boolean company = true;

    private Boolean avatar = true;

    private Boolean phone = true;

    private Boolean email = true;

    private Boolean address = true;

}
