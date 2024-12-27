package cn.iocoder.yudao.module.busicard.controller.admin.card;

import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import cn.iocoder.yudao.framework.common.util.object.BeanUtils;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.module.busicard.controller.admin.card.vo.*;
import cn.iocoder.yudao.module.busicard.dal.dataobject.card.CardDO;
import cn.iocoder.yudao.module.busicard.service.card.CardService;

import javax.annotation.Resource;
import javax.validation.Valid;

@Tag(name = "管理后台 - 名片")
@RestController
@RequestMapping("/busicard/card")
@Validated
public class CardController {

    @Resource
    private CardService cardService;

    @PostMapping("/create")
    @Operation(summary = "创建名片")
    public CommonResult<Long> createCard(@Valid @RequestBody CardSaveReqVO createReqVO) {
        return success(cardService.createCard(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新名片")
    public CommonResult<Boolean> updateCard(@Valid @RequestBody CardSaveReqVO updateReqVO) {
        cardService.updateCard(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除名片")
    @Parameter(name = "id", description = "ID", required = true)
    public CommonResult<Boolean> deleteCard(@RequestParam("id") Long id) {
        cardService.deleteCard(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得名片")
    @Parameter(name = "id", description = "ID", required = true, example = "1024")
    public CommonResult<CardRespVO> getCard(@RequestParam("id") Long id) {
        CardDO card = cardService.getCard(id);
        return success(BeanUtils.toBean(card, CardRespVO.class));
    }

    @GetMapping("/page")
    @Operation(summary = "获得名片分页")
    public CommonResult<PageResult<CardRespVO>> getCardPage(@Valid CardPageReqVO pageReqVO) {
        PageResult<CardDO> pageResult = cardService.getCardPage(pageReqVO);
        return success(BeanUtils.toBean(pageResult, CardRespVO.class));
    }

}