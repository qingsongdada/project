package cn.zqs.sqpfile.controller;

import cn.zqs.sqpfile.common.ResultCommon;
import cn.zqs.sqpfile.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

    @Autowired
    private UploadService uploadService;

    @PostMapping(value = "upload",headers = "content-type=multipart/form-data")
    public ResultCommon upload(@RequestPart("files") MultipartFile[] files){
        for (MultipartFile file : files) {
            System.out.println(file.getOriginalFilename());
        }
        return uploadService.upload(files);
    }
}
