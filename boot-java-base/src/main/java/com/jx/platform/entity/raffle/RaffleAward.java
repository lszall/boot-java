/**
*
* @ClassName: RaffleAward
* @Description: 
* @Author: lsz
* @Date: 2021-08-02 15:05:42
* @version: v1.0
*/
package com.jx.platform.entity.raffle;

import javax.persistence.Table;
import java.io.Serializable;

/**
 * 
 *
 * @author lsz
 * @date 2021-08-02 15:05:42
 */
@Table(name = "raffle_award")
public class RaffleAward implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 抽奖批次号
     */
    private String lotNo;

    /**
     * 
     */
    private String prizesName;

    /**
     * 
     */
    private Integer prizesNum;

    private static final long serialVersionUID = 1L;

    //获取:
    public Integer getId() {
        return id;
    }

    //设置:
    public void setId(Integer id) {
        this.id = id;
    }

    //获取:抽奖批次号
    public String getLotNo() {
        return lotNo;
    }

    //设置:抽奖批次号
    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    //获取:
    public String getPrizesName() {
        return prizesName;
    }

    //设置:
    public void setPrizesName(String prizesName) {
        this.prizesName = prizesName;
    }

    //获取:
    public Integer getPrizesNum() {
        return prizesNum;
    }

    //设置:
    public void setPrizesNum(Integer prizesNum) {
        this.prizesNum = prizesNum;
    }

    /**
	* 
	* 
	* @return java.lang.String
	* @author lsz
	* @date 2021-08-02 15:05:42
	*/
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", lotNo=").append(lotNo);
        sb.append(", prizesName=").append(prizesName);
        sb.append(", prizesNum=").append(prizesNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}