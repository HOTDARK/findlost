package cn.one.findlost.service;

import cn.one.findlost.dao.UserMapper;
import cn.one.findlost.dao.UserinfoMapper;
import cn.one.findlost.pojo.User;
import cn.one.findlost.pojo.Userinfo;
import cn.one.findlost.pojo.UserinfoExample;
import cn.one.findlost.utils.UUIDUtils;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public Userinfo login(User user) {

        User exitUser = userMapper.selectByUser(user);
        if(exitUser == null){
            return null;
        }

        String userinfoID = exitUser.getUserinfo();
        UserinfoExample userinfoExample = new UserinfoExample();
        UserinfoExample.Criteria criteria1 = userinfoExample.createCriteria();
        criteria1.andIdEqualTo(userinfoID);
        userinfoExample.or(criteria1);
        List<Userinfo> userinfos = userinfoMapper.selectByExample(userinfoExample);

        if(userinfos.size() <= 0){
            return null;
        }
        return userinfos.get(0);
    }

    @Override
    public String getInfo(String id) {

        UserinfoExample userinfoExample = new UserinfoExample();
        UserinfoExample.Criteria criteria1 = userinfoExample.createCriteria();
        criteria1.andIdEqualTo(id);
        userinfoExample.or(criteria1);
        List<Userinfo> userinfos = userinfoMapper.selectByExample(userinfoExample);

        if(userinfos.size() <= 0){
            return null;
        }else{
            return JSON.toJSONString(userinfos.get(0));
        }
    }

    /**
     * 注册成功返回1，失败返回-1
     * @param user1
     * @param userinfo
     * @return 1or-1
     */
    @Override
    public int register(User user1, Userinfo userinfo) {
        String userId = UUIDUtils.getUUID();
        String userinfoId = UUIDUtils.getUUID();

        user1.setId(userId);
        user1.setUserinfo(userinfoId);

        userinfo.setId(userinfoId);
        userinfo.setUserid(userId);
        userinfo.setState(0);
        System.out.println(user1.toString() + userinfo.toString());
        if(userMapper.insert(user1)*userinfoMapper.insert(userinfo)>0){


            return 1;
        }else {
            return -1;
        }
    }

    @Override
    public String update(User user, Userinfo newUserinfo) {
        User user1 = userMapper.selectByUser(user);
        if(user1 != null){
            newUserinfo.setId(user1.getUserinfo());
            userinfoMapper.updateByPrimaryKey(newUserinfo);
            return "success";
        }else{
            return "fail";
        }
    }
}
