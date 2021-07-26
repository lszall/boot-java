/**
*
* @ClassName: AdminMenuMapper
* @Description: 
* @Author: lsz
* @Date: 2021-07-26 15:04:39
* @version: v1.0
*/
package com.jx.platform.dao.admin;

import com.jx.platform.dto.admin.MenuInsertDto;
import com.jx.platform.dto.admin.MenuListDto;
import com.jx.platform.entity.admin.AdminMenu;

import java.util.List;

public interface AdminMenuMapper {
    /**
	* 
	* 
	* @param id:   
	* @return int
	* @author lsz
	* @date 2021-07-26 15:04:39
	*/
    int deleteByPrimaryKey(Integer id);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-07-26 15:04:39
	*/
    int insert(MenuInsertDto record);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-07-26 15:04:39
	*/
    int insertSelective(MenuInsertDto record);

    /**
	* 
	* 
	* @param menuCode:
	* @return com.jx.platform.entity.admin.AdminMenu
	* @author lsz
	* @date 2021-07-26 15:04:39
	*/
    AdminMenu selectByPrimaryKey(String menuCode);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-07-26 15:04:39
	*/
    int updateByPrimaryKeySelective(MenuInsertDto record);

    /**
	* 
	* 
	* @param record:   
	* @return int
	* @author lsz
	* @date 2021-07-26 15:04:39
	*/
    int updateByPrimaryKey(AdminMenu record);

	/**
	 *
	 *
	 * @param roleCode:   角色编码
	 * @return com.jx.platform.entity.admin.AdminMenu
	 * @author lsz
	 * @date 2021-07-26 15:04:39
	 */
	List<AdminMenu> selectByRoleCode(String roleCode);


	/**
	 * @param dto:
	 * @return com.jx.platform.entity.admin.AdminMenu
	 * @author lsz
	 * @date 2021-07-26 15:04:39
	 */
	List<AdminMenu> listAdminMenu(MenuListDto dto);

}