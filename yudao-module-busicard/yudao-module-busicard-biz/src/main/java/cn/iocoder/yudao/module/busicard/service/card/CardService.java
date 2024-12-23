package cn.iocoder.yudao.module.busicard.service.card;

import cn.iocoder.yudao.module.busicard.controller.admin.card.vo.*;
import cn.iocoder.yudao.module.busicard.controller.app.card.vo.AppCardRespVO;
import cn.iocoder.yudao.module.busicard.controller.app.card.vo.AppCardSaveReqVO;
import cn.iocoder.yudao.module.busicard.dal.dataobject.card.CardDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.validation.Valid;

/**
 * 名片 Service 接口
 *
 * @author Ecat
 */
public interface CardService {

    /**
     * 创建名片
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createCard(@Valid CardSaveReqVO createReqVO);

    /**
     * 更新名片
     *
     * @param updateReqVO 更新信息
     */
    void updateCard(@Valid CardSaveReqVO updateReqVO);

    /**
     * 删除名片
     *
     * @param id 编号
     */
    void deleteCard(Long id);

    /**
     * 获得名片
     *
     * @param id 编号
     * @return 名片
     */
    CardDO getCard(Long id);

    /**
     * 获得名片分页
     *
     * @param pageReqVO 分页查询
     * @return 名片分页
     */
    PageResult<CardDO> getCardPage(CardPageReqVO pageReqVO);

    Long createCard(AppCardSaveReqVO createReqVO);

    void updateCard(AppCardSaveReqVO updateReqVO);

    AppCardRespVO getdefaultCard(Long userId);
}