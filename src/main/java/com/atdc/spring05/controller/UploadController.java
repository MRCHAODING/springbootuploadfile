package com.atdc.spring05.controller;
import com.atdc.spring05.mapper.PictureMapper;
import com.atdc.spring05.pojo.Message;
import com.atdc.spring05.pojo.Picture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@RestController
public class UploadController {

    @Autowired
    PictureMapper pictureMapper;
    @GetMapping("/queryPictureList")
    public List<Picture> queryUserList(){
        List<Picture> pictures = pictureMapper.queryPictureList();
        for(Picture picture:pictures){
            System.out.println(picture);
        }
        return pictures;
    }
    @GetMapping("/addPicture")
    public Picture addUser(){
        Picture picture = new Picture(null, "445c56e9-0024-49ed-b2a7-b7cb3d7fb5d6.png");
        pictureMapper.addPicture(picture);
        return picture;
    }

    @PostMapping("/upload")
    public Object upload(MultipartFile fileUpload){
        //获取文件名
        String fileName = fileUpload.getOriginalFilename();
        //获取文件后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //重新生成文件名
        fileName = UUID.randomUUID()+suffixName;

        //指定本地文件夹存储图片，写到需要保存的目录下
        String filePath = "D:\\javaText\\";
        try {
            //将图片保存到static文件夹里
            fileUpload.transferTo(new File(filePath+fileName));
            pictureMapper.addPicture(new Picture(null,fileName));
            //返回提示信息
            return new Message(0,"上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Message(-1,"上传失败");
        }
    }
}
