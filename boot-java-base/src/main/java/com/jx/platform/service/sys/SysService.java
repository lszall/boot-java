package com.jx.platform.service.sys;

import com.jx.platform.entity.sys.SysActionLog;
import com.jx.platform.entity.sys.SysDict;
import com.jx.platform.entity.sys.SysDictType;
import com.jx.platform.entity.sys.SysUpload;

import java.util.List;

public interface SysService {

    /**
     * 保存controller访问日志
     *
     * @param sysActionLog
     * @return
     */
    int insertSysActionLog(SysActionLog sysActionLog);


    /**
     * 加载字典值到缓存
     */
    void loadDict();


    /**
     * 获取字典列表
     * @param typeCode 字典类型码
     * @return
     */
    List<SysDict> getDictList(String typeCode);

    /**
     * 保存上传文件
     * @param upload
     * @return
     */
    int insertSysUpload(SysUpload upload);
}
