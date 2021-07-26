package com.jx.platform.application.controller.sys;

import com.jx.platform.common.response.ResponseData;
import com.jx.platform.framework.base.BaseController;
import com.jx.platform.service.sys.SysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sys/dict")
public class DictController extends BaseController {

    @Autowired
    private SysService sysService;

    @RequestMapping("/getDict/{typeCode}")

    public ResponseData getDict(@PathVariable("typeCode")String typeCode){
        return success(sysService.getDictList(typeCode));
    }

}
