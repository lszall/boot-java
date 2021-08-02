/**
*
* @ClassName: RaffleDetailMapper
* @Description: 
* @Author: lsz
* @Date: 2021-08-02 15:05:42
* @version: v1.0
*/
package com.jx.platform.dao.raffle;

import com.jx.platform.entity.raffle.RaffleDetail;

import java.util.List;

public interface RaffleDetailMapper {
    /**
	* 
	* 
	* @param id:   
	* @return int
	* @author lsz
	* @date 2021-08-02 15:05:42
	*/
    int deleteByPrimaryKey(Integer id);
	int deleteByLotNo(String lotNo);
    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-08-02 15:05:42
	*/
    int insert(RaffleDetail record);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-08-02 15:05:42
	*/
    int insertSelective(RaffleDetail record);

    /**
	* 
	* 
	* @param id:   
	* @return com.jx.platform.entity.raffle.RaffleDetail
	* @author lsz
	* @date 2021-08-02 15:05:42
	*/
    RaffleDetail selectByPrimaryKey(Integer id);

	List<RaffleDetail> selectByLotNo(String lotNo);
    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-08-02 15:05:42
	*/
    int updateByPrimaryKeySelective(RaffleDetail record);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-08-02 15:05:42
	*/
    int updateByPrimaryKey(RaffleDetail record);


	/**
	 * 查询剩余未翻牌的数量
	 * @param resetPick
	 * @return
	 */
	int resetPick(String resetPick);
	/**
	 * 查询剩余未翻牌的数量
	 * @param lotNo
	 * @return
	 */
	int countNoPickNum(String lotNo);
}