package com.mySQLClasses.dao;

import com.mySQLClasses.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IUserDao  {

    /*
    * 查询所有
    * */
    List<User> findAll();

    /*
    * 保存用户
    * */

    void sendUser(User user);

    /*
    * 更新用户
    * */
    void updateUser(User user);

    /*
    * 删除用户
    * */
    void deleteUser(String userId);

    /*
    * 根据非主键定位更新主键信息
    * */
    void updateByNoPrivate(User user);

    /*
    * 根据主键查询数据全部信息
    * */
    User selectById(String userId);

    /*
    * 模糊查询
    * */
    List<User> selectLike(String userId);
}
