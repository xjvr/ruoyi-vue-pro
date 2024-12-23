package cn.iocoder.yudao.module.busicard.service.card;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import cn.iocoder.yudao.module.busicard.controller.app.card.vo.AppCardRespVO;
import cn.iocoder.yudao.module.busicard.controller.app.card.vo.AppCardSaveReqVO;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import cn.iocoder.yudao.module.busicard.controller.admin.card.vo.*;
import cn.iocoder.yudao.module.busicard.dal.dataobject.card.CardDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;

import cn.iocoder.yudao.module.busicard.dal.mysql.card.CardMapper;

import javax.annotation.Resource;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.busicard.enums.ErrorCodeConstants.CARD_NOT_EXISTS;

/**
 * 名片 Service 实现类
 *
 * @author Ecat
 */
@Service
@Validated
public class CardServiceImpl implements CardService {

    @Resource
    private CardMapper cardMapper;

    @Override
    public Long createCard(CardSaveReqVO createReqVO) {
        // 插入
        CardDO card = BeanUtils.toBean(createReqVO, CardDO.class);
        cardMapper.insert(card);
        // 返回
        return card.getId();
    }

    @Override
    public Long createCard(AppCardSaveReqVO createReqVO) {
        // 插入
        CardDO card = BeanUtils.toBean(createReqVO, CardDO.class);
        card.setCardCode(IdUtil.fastSimpleUUID());
        cardMapper.insert(card);
        // 返回
        return card.getId();
    }

    @Override
    public void updateCard(CardSaveReqVO updateReqVO) {
        // 校验存在
        validateCardExists(updateReqVO.getId());
        // 更新
        CardDO updateObj = BeanUtils.toBean(updateReqVO, CardDO.class);
        cardMapper.updateById(updateObj);
    }

    @Override
    public void updateCard(AppCardSaveReqVO updateReqVO) {
        // 更新
        CardDO updateObj = BeanUtils.toBean(updateReqVO, CardDO.class);
        cardMapper.updateById(updateObj);
    }

    @Override
    public AppCardRespVO getdefaultCard(Long userId) {
        // 查询默认卡片
        CardDO card = cardMapper.selectOne(Wrappers.<CardDO>lambdaQuery()
                .eq(CardDO::getUserId, userId)
                .eq(CardDO::getIsDefault, true));
        if(card != null) {
            return BeanUtils.toBean(card, AppCardRespVO.class);
        }

        // 查询所有卡片
        List<CardDO> cards = cardMapper.selectList(Wrappers.<CardDO>lambdaQuery()
                .eq(CardDO::getUserId, userId));
        if (CollUtil.isNotEmpty(cards)) {
            // 设置默认卡片
            CardDO cardDO = cards.get(0);
            cardDO.setIsDefault(true);
            cardMapper.updateById(cardDO);
            return BeanUtils.toBean(cardDO, AppCardRespVO.class);
        }
        return null;
    }

    @Override
    public void deleteCard(Long id) {
        // 校验存在
        validateCardExists(id);
        // 删除
        cardMapper.deleteById(id);
    }

    private void validateCardExists(Long id) {
        if (cardMapper.selectById(id) == null) {
            throw exception(CARD_NOT_EXISTS);
        }
    }

    @Override
    public CardDO getCard(Long id) {
        return cardMapper.selectById(id);
    }

    @Override
    public PageResult<CardDO> getCardPage(CardPageReqVO pageReqVO) {
        return cardMapper.selectPage(pageReqVO);
    }


}