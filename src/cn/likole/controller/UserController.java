package cn.likole.controller;

import cn.likole.entity.User;
import cn.likole.service.UserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by likole on 4/14/2017.
 */
@Controller
public class UserController extends ActionSupport implements ModelDriven<User>{

    private User user=new User();
    @Autowired
    UserService userService;
    @Override
    public User getModel() {
        return user;
    }

    public String regist()
    {
        userService.add(user);
        return null;
    }
}
