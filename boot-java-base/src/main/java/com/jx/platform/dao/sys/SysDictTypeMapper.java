/**
*
* @ClassName: SysDictTypeMapper
* @Description: 
* @Author: lsz
* @Date: 2021-07-15 23:15:39
* @version: v1.0
*/
package com.jx.platform.dao.sys;

import com.jx.platform.entity.sys.SysDictType;

import java.util.List;

public interface SysDictTypeMapper {
    /**
	* 
	* 
	* @param id:   
	* @return int
	* @author lsz
	* @date 2021-07-15 23:15:39
	*/
    int deleteByPrimaryKey(Integer id);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-07-15 23:15:39
	*/
    int insert(SysDictType record);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-07-15 23:15:39
	*/
    int insertSelective(SysDictType record);

    /**
	* 
	* 
	* @param id:   
	* @return com.jx.platform.entity.sys.SysDictType
	* @author lsz
	* @date 2021-07-15 23:15:39
	*/
    SysDictType selectByPrimaryKey(Integer id);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-07-15 23:15:39
	*/
    int updateByPrimaryKeySelective(SysDictType record);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-07-15 23:15:39
	*/
    int updateByPrimaryKey(SysDictType record);
	/**
	 * 获取全部字典类型
	 * @return
	 */
	List<SysDictType> selectAll();
}