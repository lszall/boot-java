/**
*
* @ClassName: SysUploadMapper
* @Description: 
* @Author: lsz
* @Date: 2021-08-02 21:38:26
* @version: v1.0
*/
package com.jx.platform.dao.sys;

import com.jx.platform.entity.sys.SysUpload;

public interface SysUploadMapper {
    /**
	* 
	* 
	* @param id:   
	* @return int
	* @author lsz
	* @date 2021-08-02 21:38:26
	*/
    int deleteByPrimaryKey(Integer id);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-08-02 21:38:26
	*/
    int insert(SysUpload record);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-08-02 21:38:26
	*/
    int insertSelective(SysUpload record);

    /**
	* 
	* 
	* @param id:   
	* @return com.jx.platform.entity.sys.SysUpload
	* @author lsz
	* @date 2021-08-02 21:38:26
	*/
    SysUpload selectByPrimaryKey(Integer id);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-08-02 21:38:26
	*/
    int updateByPrimaryKeySelective(SysUpload record);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-08-02 21:38:26
	*/
    int updateByPrimaryKey(SysUpload record);
}