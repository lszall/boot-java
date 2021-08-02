/**
*
* @ClassName: RaffleAwardMapper
* @Description: 
* @Author: lsz
* @Date: 2021-08-02 15:05:42
* @version: v1.0
*/
package com.jx.platform.dao.raffle;

import com.jx.platform.dto.raffle.RaffleAwardInsertDto;
import com.jx.platform.entity.raffle.RaffleAward;

import java.util.List;

public interface RaffleAwardMapper {
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
    int insert(RaffleAward record);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-08-02 15:05:42
	*/
    int insertSelective(RaffleAward record);

    /**
	* 
	* 
	* @param id:   
	* @return com.jx.platform.entity.raffle.RaffleAward
	* @author lsz
	* @date 2021-08-02 15:05:42
	*/
    RaffleAward selectByPrimaryKey(Integer id);


	List<RaffleAward> selectByLotNo(String lotNo);
    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-08-02 15:05:42
	*/
    int updateByPrimaryKeySelective(RaffleAward record);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-08-02 15:05:42
	*/
    int updateByPrimaryKey(RaffleAward record);
}