package com.atdc.spring05.mapper;

import com.atdc.spring05.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    List<User> queryUserList();
    int addUser(User user);


}
