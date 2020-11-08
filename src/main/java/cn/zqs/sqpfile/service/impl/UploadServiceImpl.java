package cn.zqs.sqpfile.service.impl;

import cn.zqs.sqpfile.bean.OssProperties;
import cn.zqs.sqpfile.common.ResultCommon;
import cn.zqs.sqpfile.service.UploadService;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private OssProperties ossProperties;

    @Override
    public ResultCommon upload(MultipartFile[] files){
        OSS ossClient = new OSSClientBuilder().build(ossProperties.getEndpoint(),ossProperties.getKeyid(),ossProperties.getKeysecret());
        List uploadFileName = new ArrayList();
        boolean flag = true;
        for (MultipartFile file : files) {
            InputStream inputStream = null;
            try {
                inputStream = file.getInputStream();
                String filename = file.getOriginalFilename();
                String datetime = new DateTime().toString("yyyy/MM/dd");
                String uuid = UUID.randomUUID().toString().replace("-", "");
                String filePath = datetime + "/" + uuid + filename;
                ossClient.putObject(ossProperties.getBucketname(),filePath,inputStream);
                ossClient.shutdown();
                //回显上传后图片路径
                uploadFileName.add("https://" + ossProperties.getBucketname() + "." + ossProperties.getEndpoint() + "/" + filePath);
            } catch (IOException e) {
                flag = false;
                e.printStackTrace();
            }
        }
        if(flag){
            return ResultCommon.success(uploadFileName);
        }
        return ResultCommon.fail();
    }

}
