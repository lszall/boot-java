/**
*
* @ClassName: AdminRoleMapper
* @Description: 
* @Author: lsz
* @Date: 2021-07-11 10:16:28
* @version: v1.0
*/
package com.jx.platform.dao.admin;


import com.jx.platform.entity.admin.AdminRole;

public interface AdminRoleMapper {
    /**
	* 
	* 
	* @param id:   
	* @return int
	* @author lsz
	* @date 2021-07-11 10:16:28
	*/
    int deleteByPrimaryKey(Integer id);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-07-11 10:16:28
	*/
    int insert(AdminRole record);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-07-11 10:16:28
	*/
    int insertSelective(AdminRole record);

    /**
	* 
	* 
	* @param id:   
	* @return com.boot.application.entity.AdminRole
	* @author lsz
	* @date 2021-07-11 10:16:28
	*/
    AdminRole selectByPrimaryKey(Integer id);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-07-11 10:16:28
	*/
    int updateByPrimaryKeySelective(AdminRole record);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-07-11 10:16:28
	*/
    int updateByPrimaryKey(AdminRole record);
}