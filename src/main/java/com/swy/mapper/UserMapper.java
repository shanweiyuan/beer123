package com.swy.mapper;

import com.swy.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    /**
     * 注册，插入数据
     * @param user
     */
    void insertUser(User user);

    /**
     * 根据邮箱查询
     * @param email
     * @return
     */
    User queryByEmail(String email);

}
