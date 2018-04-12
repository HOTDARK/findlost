package cn.one.findlost.utils;

import cn.one.findlost.pojo.User;

import java.util.ArrayList;
import java.util.List;

public class UserIdentity {
    private List<User> userList = new ArrayList<>();
    private UserIdentity(){
    }
    private static UserIdentity userIdentity = new UserIdentity();
    public static UserIdentity getUserTable(){
        return userIdentity;
    }

    /**
     * 添加一条用户信息
     * @param User
     * @return
     */
    public boolean addUser(User User ){
        try {
            synchronized (userList){
                userList.add(User);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 删除一条用户信息
     * @param User
     * @return
     */
    public boolean remove(User User){
        try {
            synchronized (userList){
                userList.remove(User);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public int  getCount(){
        return userList.size();
    }
}
