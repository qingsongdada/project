package cn.zqs.sqpfile.service;

import cn.zqs.sqpfile.common.ResultCommon;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    ResultCommon upload(MultipartFile[] files);
}
