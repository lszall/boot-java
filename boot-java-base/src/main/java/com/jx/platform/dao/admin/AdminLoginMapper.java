/**
 * @ClassName: AdminLoginMapper
 * @Description:
 * @Author: lsz
 * @Date: 2021-07-11 10:16:28
 * @version: v1.0
 */
package com.jx.platform.dao.admin;


import com.jx.platform.dto.admin.AccountListDto;
import com.jx.platform.entity.admin.AdminLogin;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface AdminLoginMapper {


    /**
     *
     * unless = "#result == null" 结果是null的时候不缓存
     * @param account:
     * @return com.boot.application.entity.AdminLogin
     * @author lsz
     * @date 2021-07-11 10:16:28
     */
    @Cacheable(cacheNames = "spring-cache:login", key = "#account",unless = "#result == null")
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
	@CacheEvict(value = "spring-cache:login",key = "#record.account")
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

    /**
     *
     * @param dto
     * @return
     */
    List<AdminLogin> listAdminLogin(AccountListDto dto);
}