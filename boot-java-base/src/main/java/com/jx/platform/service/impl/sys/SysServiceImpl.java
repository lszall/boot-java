package com.jx.platform.service.impl.sys;

import com.jx.platform.dao.sys.SysActionLogMapper;
import com.jx.platform.dao.sys.SysDictMapper;
import com.jx.platform.dao.sys.SysDictTypeMapper;
import com.jx.platform.entity.sys.SysActionLog;
import com.jx.platform.entity.sys.SysDict;
import com.jx.platform.entity.sys.SysDictType;
import com.jx.platform.service.sys.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysServiceImpl implements SysService {

    @Autowired
    private SysActionLogMapper sysActionLogMapper;
    @Autowired
    private SysDictMapper sysDictMapper;
    @Autowired
    private SysDictTypeMapper sysDictTypeMapper;


    @Override
    public int insertSysActionLog(SysActionLog sysActionLog) {
        return sysActionLogMapper.insert(sysActionLog);
    }

    @Override
    public void loadDict() {
        List<SysDictType> typeList = sysDictTypeMapper.selectAll();
        typeList.stream().forEach(item -> {
            sysDictMapper.selectByTypeCode(item.getTypeCode());
        });
    }

    @Override
    public List<SysDict> getDictList(String typeCode) {
        return sysDictMapper.selectByTypeCode(typeCode);
    }


}
