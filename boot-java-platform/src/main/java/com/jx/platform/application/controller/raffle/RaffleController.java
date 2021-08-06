package com.jx.platform.application.controller.raffle;

import com.jx.platform.common.response.ResponseData;
import com.jx.platform.dto.raffle.RaffleListDto;
import com.jx.platform.dto.raffle.RaffleMainInsertDto;
import com.jx.platform.dto.raffle.RaffleResultUploadDto;
import com.jx.platform.dto.raffle.RaffleStatusDto;
import com.jx.platform.framework.base.BaseController;
import com.jx.platform.service.raffle.RaffleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


/**
 * 翻牌抽奖
 */
@RestController
@RequestMapping("raffle")
public class RaffleController extends BaseController {

    @Autowired
    private RaffleService raffleService;



    @PostMapping("insertRaffle")
    public ResponseData insertRaffle(@RequestBody @Validated RaffleMainInsertDto dto) {
        return success(raffleService.insertRaffle(dto));
    }


    @PostMapping("updateRaffle")
    public ResponseData updateRaffle(@RequestBody @Validated RaffleMainInsertDto dto) {
        return success(raffleService.updateRaffle(dto));
    }

    @GetMapping("getRaffleMainInfo/{lotNo}")
    public ResponseData getRaffleMainInfo(@PathVariable("lotNo") String lotNo) {
        return success(raffleService.getRaffleMainInfo(lotNo));
    }

    @PostMapping("pageRaffleMain")
    public ResponseData pageRaffleMain(@RequestBody @Validated RaffleListDto dto) {
        return success(raffleService.pageRaffleMain(dto));
    }

    @GetMapping("deleteRaffle/{lotNo}")
    public ResponseData deleteRaffle(@PathVariable("lotNo") String lotNo) {
        return success(raffleService.deleteRaffle(lotNo));
    }

    /**
     * 获取抽奖排列明细
     * @param dto status=1 仅有奖品明细 status=0 包含空奖
     * @return
     */
    @PostMapping("listRaffleDetail")
    public ResponseData listRaffleDetail(@RequestBody @Validated RaffleStatusDto dto) {
        return success(raffleService.listRaffleDetail(dto));
    }


    /**
     * 修改抽奖配置状态
     *
     * @param dto
     * @return
     */
    @PostMapping("reStartRaffle")
    public ResponseData reStartRaffle(@RequestBody @Validated RaffleStatusDto dto) {
        return success(raffleService.reStartRaffle(dto));
    }

    /**
     * 翻牌结果上传
     *
     * @param dto
     * @return
     */
    @PostMapping("raffleResultUpload")
    public ResponseData raffleResultUpload(@RequestBody @Validated RaffleResultUploadDto dto) {
        return success(raffleService.raffleResultUpload(dto));
    }

}
