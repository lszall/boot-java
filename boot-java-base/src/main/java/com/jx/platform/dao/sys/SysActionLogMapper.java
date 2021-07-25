/**
*
* @ClassName: SysActionLogMapper
* @Description: 
* @Author: lsz
* @Date: 2021-07-15 21:44:09
* @version: v1.0
*/
package com.jx.platform.dao.sys;

import com.jx.platform.entity.sys.SysActionLog;

public interface SysActionLogMapper {
    /**
	* 
	* 
	* @param id:   
	* @return int
	* @author lsz
	* @date 2021-07-15 21:44:09
	*/
    int deleteByPrimaryKey(Integer id);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-07-15 21:44:09
	*/
    int insert(SysActionLog record);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-07-15 21:44:09
	*/
    int insertSelective(SysActionLog record);

    /**
	* 
	* 
	* @param id:   
	* @return com.jx.platform.entity.sys.SysActionLog
	* @author lsz
	* @date 2021-07-15 21:44:09
	*/
    SysActionLog selectByPrimaryKey(Integer id);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-07-15 21:44:09
	*/
    int updateByPrimaryKeySelective(SysActionLog record);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-07-15 21:44:09
	*/
    int updateByPrimaryKeyWithBLOBs(SysActionLog record);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-07-15 21:44:09
	*/
    int updateByPrimaryKey(SysActionLog record);
}