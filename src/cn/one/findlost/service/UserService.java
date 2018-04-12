package cn.one.findlost.service;

import cn.one.findlost.pojo.User;
import cn.one.findlost.pojo.Userinfo;

public interface UserService {

    int register(User user1, Userinfo userinfo);

    Userinfo login(User user);

    String getInfo(String id);

    String update(User newUser, Userinfo newUserinfo);
}
