package cn.iocoder.yudao.module.busicard.controller.app.card;

import cn.iocoder.yudao.module.busicard.controller.admin.card.vo.CardRespVO;
import cn.iocoder.yudao.module.busicard.dal.dataobject.card.CardDO;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;
import static cn.iocoder.yudao.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

import cn.iocoder.yudao.module.busicard.controller.app.card.vo.*;
import cn.iocoder.yudao.module.busicard.service.card.CardService;

import javax.annotation.Resource;
import javax.validation.Valid;

@Tag(name = "用户 APP - 名片")
@RestController
@RequestMapping("/busicard/card")
@Validated
public class AppCardController {

    @Resource
    private CardService cardService;

    @GetMapping("/get-default")
    @Operation(summary = "获得默认名片")
    public CommonResult<AppCardRespVO> getDefaultCard() {
        Long userId = getLoginUserId();
        return success(cardService.getdefaultCard(userId));
    }


    @GetMapping("/get")
    @Operation(summary = "获得名片")
    @Parameter(name = "id", description = "ID", required = true, example = "1024")
    public CommonResult<AppCardRespVO> getCard(@RequestParam("id") Long id) {
        CardDO card = cardService.getCard(id);
        return success(BeanUtils.toBean(card, AppCardRespVO.class));
    }

    @GetMapping("/get-by-code")
    @Operation(summary = "根据code查询名片信息")
    public CommonResult<AppCardRespVO> getCardByCode(@RequestParam("code") String code) {
        return success(cardService.getCardByCode(code));
    }

    @PostMapping("/create")
    @Operation(summary = "创建名片")
    public CommonResult<Long> createCard(@Valid @RequestBody AppCardSaveReqVO createReqVO) {
        createReqVO.setUserId(getLoginUserId());
        return success(cardService.createCard(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新名片")
    public CommonResult<Boolean> updateCard(@Valid @RequestBody AppCardSaveReqVO updateReqVO) {
        cardService.updateCard(updateReqVO);
        return success(true);
    }

}