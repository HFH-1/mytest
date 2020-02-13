package com.leyou.mappers;

import com.leyou.pojo.User;
import com.leyou.pojo.User1;
import com.leyou.vo.QueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @auther HuangFeiHong
 * @date 2020-02-04 14:28
 */
public class UserMapperTest {
    private InputStream inputStreamn;

    private SqlSession sqlSession;
    private UserMapper userMapper;


    @Before
    public void setUp() throws Exception {
        inputStreamn=Resources.getResourceAsStream("mybatis/mybatis-config.xml");
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStreamn);
        sqlSession=sessionFactory.openSession();
        userMapper=sqlSession.getMapper(UserMapper.class);
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.commit();
        sqlSession.close();
        inputStreamn.close();

    }

    @Test
    public void findById() {
        User user = userMapper.findById(41);
        System.out.println("user = " + user);
    }

    @Test
    public void saveUser() {
        User user=new User();
        user.setBirthday(new Date());
        user.setSex("男");
        user.setUsername("黄飞鸿红");
        user.setAddress("安徽淮北");
        userMapper.saveUser(user);
        System.out.println("user = " + user);
    }

    @Test
    public void updateUser() {
        User user=new User();
        user.setId(58);
        user.setBirthday(new Date());
        user.setSex("男");
        user.setUsername("我的区长父亲");
        user.setAddress("安徽淮北");
        userMapper.updateUser(user);
        System.out.println("user = " + user);
    }

    @Test
    public void deleteUser() {
        userMapper.deleteUser(58);
    }

    @Test
    public void findByName() {
        List<User> users = userMapper.findByName("二");
        for (User user : users) {

            System.out.println("user = " + user);
            
        }
    }


    @Test
    public void queryByVo() {
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("二");
        queryVo.setUser(user);
        List<User> list = userMapper.queryByVo(queryVo);

        for (User user1 : list) {
            System.out.println("user1 = " + user1);
        }
    }

    @Test
    public void findTotal() {
        int total = userMapper.findTotal();
        System.out.println("total = " + total);
    }

    @Test
    public void findAll() {
        List<User1> all = userMapper.findAll();
        for (User1 user1 : all) {

            System.out.println("user1 = " + user1);
        }
    }
}
