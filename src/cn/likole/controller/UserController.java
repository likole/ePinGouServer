package cn.likole.controller;

import cn.likole.entity.User;
import cn.likole.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;
/**
 * Created by likole on 4/14/2017.
 */
@Controller
@Scope("prototype")
public class UserController extends ActionSupport implements ModelDriven<User>{

   private Map<String,Object> map=new HashMap<String, Object>() {
    };

    public Map<String, Object> getMap() {
        return map;
    }

    private User user=new User();
    @Autowired
    UserService userService;
    @Override
    public User getModel() {
        return user;
    }

    public String register()
    {
        map.put("status",userService.register(user));
        return SUCCESS;
    }

    public String login()
    {
        int rsCode=userService.login(user);
        map.put("status",rsCode);
        if(rsCode==0)map.put("token",userService.getToken(user));
        return SUCCESS;
    }
}
