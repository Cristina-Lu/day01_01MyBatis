package com.mySQLClasses.domain;

import com.mySQLClasses.dao.IUserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyFirstTest {

    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao iUserDao;

    @Before
    public void init() throws IOException {
        //1、读取数据文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2、创建sqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory Factory = builder.build(in);
        //3、使用工厂生产sqlSession对象
        sqlSession = Factory.openSession();
        //4、使用sqlSession对象创建Dao接口的代理对象
        iUserDao = sqlSession.getMapper(IUserDao.class);
    }

    @After
    public void destoryTry() throws IOException {
        //提交事务
        sqlSession.commit();
        //资源关闭
        sqlSession.close();
        in.close();
    }

    @Test
    public void findAll() throws Exception{

        //5、使用代理对象执行方法
        List<User>users = iUserDao.findAll();
        for (User user:users){
            System.out.println(user);
        }

    }

    @Test
    public void insert(){
        User user = new User();
        user.setUserName("加入");
        //user.setUserId("15827202");
        user.setUserMobile("158531228");
        user.setAccountId("152712");
        Date date = new Date();
        user.setAccessTime(date);
        user.setUserStatues(true);

        System.out.println(user);
        iUserDao.sendUser(user);
        System.out.println(user);

    }

    @Test
    public void updateUser(){
        User user = new User();
        user.setUserName("更新的值");
        user.setUserId("158271202");
        user.setUserMobile("158271228");
        user.setAccountId("1582712");
        Date date = new Date();
        user.setAccessTime(date);
        user.setUserStatues(true);

        iUserDao.updateUser(user);
    }

    @Test
    public void updateByNoPrivate(){
        User user = new User();
        user.setUserName("非主键定位更新");
        user.setUserId("158271203");
        user.setUserMobile("158271228");
        user.setAccountId("1582712");
        Date date = new Date();
        user.setAccessTime(date);
        user.setUserStatues(true);

        iUserDao.updateByNoPrivate(user);
    }

    @Test
    public void deleteTry(){
        iUserDao.deleteUser("158271203");
    }

    @Test
    public void selectById(){
        //User user = new User();
        User user=iUserDao.selectById("158271202");
        System.out.println(user.toString());
    }

    @Test
    public void selectLike(){
        List<User> users=iUserDao.selectLike("加入");
        for (User user:users) {
            System.out.println(user);
        }
    }
}
