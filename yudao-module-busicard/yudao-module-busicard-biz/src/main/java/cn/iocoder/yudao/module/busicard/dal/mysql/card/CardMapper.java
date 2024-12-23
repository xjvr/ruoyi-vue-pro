package cn.iocoder.yudao.module.busicard.dal.mysql.card;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.busicard.dal.dataobject.card.CardDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.busicard.controller.admin.card.vo.*;

/**
 * 名片 Mapper
 *
 * @author Ecat
 */
@Mapper
public interface CardMapper extends BaseMapperX<CardDO> {

    default PageResult<CardDO> selectPage(CardPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<CardDO>()
                .eqIfPresent(CardDO::getCardCode, reqVO.getCardCode())
                .eqIfPresent(CardDO::getUserId, reqVO.getUserId())
                .eqIfPresent(CardDO::getSocialUserId, reqVO.getSocialUserId())
                .eqIfPresent(CardDO::getIsDefault, reqVO.getIsDefault())
                .eqIfPresent(CardDO::getCardType, reqVO.getCardType())
                .eqIfPresent(CardDO::getCompanyId, reqVO.getCompanyId())
                .likeIfPresent(CardDO::getName, reqVO.getName())
                .eqIfPresent(CardDO::getTitle, reqVO.getTitle())
                .eqIfPresent(CardDO::getAvatar, reqVO.getAvatar())
                .eqIfPresent(CardDO::getPersonalPhone, reqVO.getPersonalPhone())
                .eqIfPresent(CardDO::getPersonalEmail, reqVO.getPersonalEmail())
                .eqIfPresent(CardDO::getPersonalAddress, reqVO.getPersonalAddress())
                .eqIfPresent(CardDO::getPersonalWechat, reqVO.getPersonalWechat())
                .eqIfPresent(CardDO::getPersonalQrcode, reqVO.getPersonalQrcode())
                .eqIfPresent(CardDO::getEmployeeNo, reqVO.getEmployeeNo())
                .eqIfPresent(CardDO::getOfficePhone, reqVO.getOfficePhone())
                .eqIfPresent(CardDO::getOfficeEmail, reqVO.getOfficeEmail())
                .eqIfPresent(CardDO::getExtensionNumber, reqVO.getExtensionNumber())
                .eqIfPresent(CardDO::getStyleType, reqVO.getStyleType())
                .eqIfPresent(CardDO::getCustomStyle, reqVO.getCustomStyle())
                .eqIfPresent(CardDO::getShareImageUrl, reqVO.getShareImageUrl())
                .eqIfPresent(CardDO::getQrcodeUrl, reqVO.getQrcodeUrl())
                .eqIfPresent(CardDO::getVisitCount, reqVO.getVisitCount())
                .eqIfPresent(CardDO::getSaveCount, reqVO.getSaveCount())
                .eqIfPresent(CardDO::getShareCount, reqVO.getShareCount())
                .betweenIfPresent(CardDO::getLastVisitTime, reqVO.getLastVisitTime())
                .betweenIfPresent(CardDO::getLastShareTime, reqVO.getLastShareTime())
                .betweenIfPresent(CardDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(CardDO::getId));
    }

}