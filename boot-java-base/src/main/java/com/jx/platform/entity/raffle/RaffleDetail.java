/**
*
* @ClassName: RaffleDetail
* @Description: 
* @Author: lsz
* @Date: 2021-08-02 15:05:42
* @version: v1.0
*/
package com.jx.platform.entity.raffle;

import lombok.Data;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * 
 *
 * @author lsz
 * @date 2021-08-02 15:05:42
 */
@Table(name = "raffle_detail")
@Data
public class RaffleDetail implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 抽奖批次号
     */
    private String lotNo;

    /**
     * 奖品名称
     */
    private Integer prizesId;
    /**
     * 奖品名称
     */
    private String prizesName;

    /**
     * 顺序号
     */
    private Integer sortNum;

    /**
     * 是否翻牌  Y 是 N 否
     */
    private String pick;

    private static final long serialVersionUID = 1L;


}