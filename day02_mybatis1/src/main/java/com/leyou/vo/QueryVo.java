package com.leyou.vo;

import com.leyou.pojo.User;

/**
 * @auther HuangFeiHong
 * @date 2020-02-04 15:26
 */
public class QueryVo {
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "user=" + user +
                '}';
    }
}
