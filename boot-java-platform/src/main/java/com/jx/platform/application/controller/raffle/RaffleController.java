package com.jx.platform.application.controller.raffle;

import com.jx.platform.common.response.ResponseData;
import com.jx.platform.dto.raffle.RaffleListDto;
import com.jx.platform.dto.raffle.RaffleMainInsertDto;
import com.jx.platform.dto.raffle.RaffleResultUploadDto;
import com.jx.platform.dto.raffle.RaffleStatusDto;
import com.jx.platform.entity.raffle.RaffleDetail;
import com.jx.platform.framework.base.BaseController;
import com.jx.platform.service.raffle.RaffleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("listRaffleDetail/{lotNo}")
    public ResponseData listRaffleDetail(@PathVariable("lotNo") String lotNo) {
        return success(raffleService.listRaffleDetail(lotNo));
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
