/**
 * @ClassName: SysDictMapper
 * @Description:
 * @Author: lsz
 * @Date: 2021-07-15 23:15:39
 * @version: v1.0
 */
package com.jx.platform.dao.sys;

import com.jx.platform.entity.sys.SysDict;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

public interface SysDictMapper {
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
    int insert(SysDict record);

    /**
     *
     *
     * @param record:
     * @return int
     * @author lsz
     * @date 2021-07-15 23:15:39
     */
    int insertSelective(SysDict record);

    /**
     *
     *
     * @param id:
     * @return com.jx.platform.entity.sys.SysDict
     * @author lsz
     * @date 2021-07-15 23:15:39
     */
    SysDict selectByPrimaryKey(Integer id);

    /**
     *
     *
     * @param record:
     * @return int
     * @author lsz
     * @date 2021-07-15 23:15:39
     */
    int updateByPrimaryKeySelective(SysDict record);

    /**
     *
     *
     * @param record:
     * @return int
     * @author lsz
     * @date 2021-07-15 23:15:39
     */
    int updateByPrimaryKey(SysDict record);
	/**
	 * 获取字典列表
	 * @param typeCode
	 * @return
	 */
    @Cacheable(cacheNames = "spring-cache:dict",key = "#typeCode")
    List<SysDict> selectByTypeCode(String typeCode);
}