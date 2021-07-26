/**
*
* @ClassName: AdminRoleMapper
* @Description: 
* @Author: lsz
* @Date: 2021-07-11 10:16:28
* @version: v1.0
*/
package com.jx.platform.dao.admin;


import com.jx.platform.dto.admin.RoleInsertDto;
import com.jx.platform.dto.admin.RoleListDto;
import com.jx.platform.entity.admin.AdminRole;

import java.util.List;

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
    int insert(RoleInsertDto record);

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
	* @param roleCode:
	* @return com.boot.application.entity.AdminRole
	* @author lsz
	* @date 2021-07-11 10:16:28
	*/
    AdminRole selectByPrimaryKey(String roleCode);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-07-11 10:16:28
	*/
    int updateByPrimaryKeySelective(RoleInsertDto record);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-07-11 10:16:28
	*/
    int updateByPrimaryKey(AdminRole record);


	List<AdminRole> listAdminRole(RoleListDto dto);
	/**
	 *
	 *删除菜单角色
	 * @param record:
	 * @return int
	 * @author lsz
	 * @date 2021-07-11 10:16:28
	 */
	int deleteRoleMenus(RoleInsertDto record);
	/**
	 *
	 *新增菜单角色
	 * @param record:
	 * @return int
	 * @author lsz
	 * @date 2021-07-11 10:16:28
	 */
	int insertRoleMenus(RoleInsertDto record);


}