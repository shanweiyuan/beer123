package com.swy.mapper;

import com.swy.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    /**
     * 添加信息
     * @param email
     * @return
     */
    void AddUser(String username, String email, String password);


    /**
     * 更新信息
     * @param email
     * @return
     */
    void updateUser(String username, String email, String password);

    /**
     * 查询讯息
     * @return
     */
    List<User> selectAll();

    /**
     * 删除信息
     * @return
     */
    int deleteInfo(int id);

}
