package com.leyou.mappers;

import com.leyou.pojo.User;
import com.leyou.pojo.User1;
import com.leyou.vo.QueryVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @auther HuangFeiHong
 * @date 2020-02-04 14:20
 */
public interface UserMapper {
    User findById(Integer id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    List<User> findByName(@Param("username") String username);
    List<User>queryByVo(QueryVo vo);
    int findTotal();
    List<User1>findAll();
}
