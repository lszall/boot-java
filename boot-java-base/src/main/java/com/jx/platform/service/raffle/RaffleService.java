package com.jx.platform.service.raffle;

import com.github.pagehelper.PageInfo;
import com.jx.platform.dto.raffle.RaffleListDto;
import com.jx.platform.dto.raffle.RaffleMainInsertDto;
import com.jx.platform.dto.raffle.RaffleResultUploadDto;
import com.jx.platform.dto.raffle.RaffleStatusDto;
import com.jx.platform.entity.raffle.RaffleDetail;
import com.jx.platform.entity.raffle.RaffleMain;

import java.util.List;

/**
 * 抽奖类别
 * A 翻牌 设置牌子数量与奖品， 翻牌子抽奖
 * B 抽人
 *
 *
 */
public interface RaffleService {


    /**
     * 新增一次抽奖
     *
     * @param dto
     * @return
     */
    int insertRaffle(RaffleMainInsertDto dto);

    /**
     * 查询抽奖配置
     *
     * @return
     */
    RaffleMain getRaffleMainInfo(String lotNo);

    /**
     * 更新一次抽奖
     *
     * @param dto
     * @return
     */
    int updateRaffle(RaffleMainInsertDto dto);


    /**
     * 删除
     *
     * @param lotNo
     * @return
     */
    int deleteRaffle(String lotNo);

    /**
     * 修改抽奖配置状态
     * @param dto
     * @return
     */
    int reStartRaffle(RaffleStatusDto dto);

    /**
     * 翻牌结果上传
     * @param dto
     * @return
     */
    int raffleResultUpload(RaffleResultUploadDto dto);

    /**
     * 列表
     *
     * @return
     */
    PageInfo<RaffleMain> pageRaffleMain(RaffleListDto dto);

    /**
     * 明细列表
     *
     * @param dto        批次
     * @return
     */
    List<RaffleDetail> listRaffleDetail(RaffleStatusDto dto);
}
