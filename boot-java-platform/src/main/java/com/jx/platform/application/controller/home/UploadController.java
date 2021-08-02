package com.jx.platform.application.controller.home;

import com.jx.platform.common.response.ResponseData;
import com.jx.platform.entity.sys.SysUpload;
import com.jx.platform.framework.base.BaseController;
import com.jx.platform.service.sys.SysService;
import com.jx.platform.util.file.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

@RestController
@RequestMapping("upload")
public class UploadController extends BaseController {

    @Value("${local-config.upload-path-root}")
    private String filePath;

    @Autowired
    private SysService sysService;

    @PostMapping("uploadPicture")
    public ResponseData uploadPicture(MultipartFile file, String location) {

        if (file.isEmpty()) {
            return failure("上传失败，请选择文件");
        }
        String fileName = file.getOriginalFilename();
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        String saveFileName = "img" + File.separator + LocalDate.now().toString() + File.separator + uuid + FileUtil.getFileSuffix(fileName);
        SysUpload upload = new SysUpload();
        upload.setLocation(location);
        upload.setUuid(uuid);
        upload.setOriginName(fileName);
        upload.setFilePath(saveFileName);
        upload.setFileType("P");
        File dest = new File(filePath + saveFileName);
        try {
            if(!dest.getParentFile().exists()){
                dest.getParentFile().mkdirs();
            }
            file.transferTo(dest);
            sysService.insertSysUpload(upload);
            return success(saveFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return failure("上传失败！");
    }


}
