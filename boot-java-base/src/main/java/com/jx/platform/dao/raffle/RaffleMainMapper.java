/**
*
* @ClassName: RaffleMainMapper
* @Description: 
* @Author: lsz
* @Date: 2021-08-02 15:05:42
* @version: v1.0
*/
package com.jx.platform.dao.raffle;

import com.jx.platform.dto.raffle.RaffleListDto;
import com.jx.platform.dto.raffle.RaffleMainInsertDto;
import com.jx.platform.entity.raffle.RaffleMain;

import java.util.List;

public interface RaffleMainMapper {
    /**
	* 
	* 
	* @param lotNo:
	* @return int
	* @author lsz
	* @date 2021-08-02 15:05:42
	*/
    int deleteByPrimaryKey(String lotNo);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-08-02 15:05:42
	*/
    int insert(RaffleMain record);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-08-02 15:05:42
	*/
    int insertSelective(RaffleMain record);

    /**
	* 
	* 
	* @param lotNo:
	* @return com.jx.platform.entity.raffle.RaffleMain
	* @author lsz
	* @date 2021-08-02 15:05:42
	*/
    RaffleMain selectByPrimaryKey(String lotNo);

	List<RaffleMain> selectRaffleMainList(RaffleListDto dto);
    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-08-02 15:05:42
	*/
    int updateByPrimaryKeySelective(RaffleMain record);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-08-02 15:05:42
	*/
    int updateByPrimaryKey(RaffleMain record);
}