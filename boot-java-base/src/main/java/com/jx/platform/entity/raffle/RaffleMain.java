/**
*
* @ClassName: RaffleMain
* @Description: 
* @Author: lsz
* @Date: 2021-08-02 15:05:42
* @version: v1.0
*/
package com.jx.platform.entity.raffle;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * 
 *
 * @author lsz
 * @date 2021-08-02 15:05:42
 */
@Table(name = "raffle_main")
@Data
public class RaffleMain implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 抽奖批次号
     */
    private String lotNo;

    /**
     * 名称
     */
    private String name;

    /**
     * 类型 A 翻牌（乱序）
     */
    private String raffleType;

    /**
     * 
     */
    private Integer totalNum;

    /**
     * 封面地址
     */
    private String coverUrl;

    /**
     * 状态 0 未开始 1 进行中 2 已完成
     */
    private Integer status;

    /**
     * 未中奖提示语
     */
    private String noPrizesMsg;

    /**
     * 
     */
    private LocalDateTime createDate;

    List<RaffleAward> awards;


}