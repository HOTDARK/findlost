package cn.one.findlost.controller.api;

import cn.one.findlost.pojo.User;
import cn.one.findlost.pojo.Userinfo;
import cn.one.findlost.service.UserService;
import cn.one.findlost.service.UserServiceImpl;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@ResponseBody
@RequestMapping("/api/user")
public class UserAPI {

    @Autowired
    UserService userService;

    @RequestMapping("/register")
    public int register(HttpServletRequest request, Model model,String user,String userinfo){

        System.out.println(user +userinfo);

        User user1 = JSON.parseObject(user, User.class);
        Userinfo userInfo = JSON.parseObject(userinfo, Userinfo.class);

        return userService.register(user1,userInfo);
    }

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        Userinfo userinfo = userService.login(user);
        String s = JSON.toJSONString(userinfo);

        System.out.println("userinfo :"+s);
        if(userinfo==null){
            return null;
        }
        return s;
    }

    public int reset(){
        return 0;
    }

    /**
     * 返回userinfo字符串
     * @param id
     * @return
     */
    @RequestMapping("/info")
    public String  getInfo(String id){
        return userService.getInfo(id);
    }


    /**
     * 成功返回success
     * 失败返回fail
     * @param userJson
     * @param newUserinfoJson
     * @return
     */
    @RequestMapping("/update")
    public String update(String userJson,String newUserinfoJson){
        User user = JSON.parseObject(userJson,User.class);
        Userinfo newUserinfo = JSON.parseObject(newUserinfoJson,Userinfo.class);

        return userService.update(user,newUserinfo);
    }
}
