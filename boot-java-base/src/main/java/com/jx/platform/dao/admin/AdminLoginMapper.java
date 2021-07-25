/**
*
* @ClassName: AdminLoginMapper
* @Description: 
* @Author: lsz
* @Date: 2021-07-11 10:16:28
* @version: v1.0
*/
package com.jx.platform.dao.admin;


import com.jx.platform.entity.admin.AdminLogin;

public interface AdminLoginMapper {


	/**
	 *
	 *
	 * @param account:
	 * @return com.boot.application.entity.AdminLogin
	 * @author lsz
	 * @date 2021-07-11 10:16:28
	 */
	AdminLogin selectByAccount(String account);


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
    int insert(AdminLogin record);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-07-11 10:16:28
	*/
    int insertSelective(AdminLogin record);

    /**
	* 
	* 
	* @param id:   
	* @return com.boot.application.entity.AdminLogin
	* @author lsz
	* @date 2021-07-11 10:16:28
	*/
    AdminLogin selectByPrimaryKey(Integer id);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-07-11 10:16:28
	*/
    int updateByPrimaryKeySelective(AdminLogin record);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-07-11 10:16:28
	*/
    int updateByPrimaryKey(AdminLogin record);
}