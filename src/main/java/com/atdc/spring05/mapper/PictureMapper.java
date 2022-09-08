package com.atdc.spring05.mapper;

import com.atdc.spring05.pojo.Picture;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PictureMapper {
    List<Picture> queryPictureList();
    int addPicture(Picture picture);

}
