package com.study.mapper;

import com.study.domain.Order;
import com.study.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Insert("insert into user values(#{id},#{username},#{password},#{birthday})")
    public void save(User user);

    @Update("update user set username=#{username},password=#{password} where id=#{id}")
    public void update(User user);

    @Delete("delete from user where id=#{id}")
    public void delete(int id);

    @Select("select * from user where id=#{id}")
    public User findById(int id);

    @Select("select * from user")
    public List<User> findAll();

    @Select("select * from user")
    @Results({
            @Result(column = "id", property = "id", id = true),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(
                    property = "orderList",
                    column = "id",
                    javaType = List.class, //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                    many = @Many(select = "com.study.mapper.OrderMapper.findByUid")
            )
    })
    public List<User> findUserAndOrderAll();

    @Select("select * from user")
    @Results({
            @Result(column = "id",property = "id",id = true),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(
                    property = "roleList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.study.mapper.RoleMapper.findByUid")
            )
    })
    public List<User> findUserAndRoleAll();
}
