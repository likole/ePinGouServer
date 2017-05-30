package cn.likole.service;

import cn.likole.dao.UserDAO;
import cn.likole.entity.User;
import cn.likole.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

/**
 * Created by likole on 4/14/2017.
 */
@Transactional
@Service
public class UserService {
    @Autowired
    UserDAO userDAO;
    public int register(User user){
        if(user.getPassword()==null||user.getPassword().length()!=32) return 102;//密码格式错误
        if(user.getPhone()==null||user.getPhone().length()!=11)return 101;//手机格式错误
        if(userDAO.getByPhone(user.getPhone())!=null) return 103;//手机号已注册
        long prefix=Calendar.getInstance().getTimeInMillis();
        user.setToken(MD5Util.MD5Encode(prefix+user.getPhone()));
        userDAO.add(user);
        return 0;
    }

    public int login(User user){
        if(user.getPassword()==null||user.getPassword().length()!=32) return 102;//密码格式错误
        if(user.getPhone()==null||user.getPhone().length()!=11)return 101;//手机格式错误
        if(userDAO.getByPhoneAndPassword(user.getPhone(),user.getPassword())==null) return 104;//用户名或密码错误
        return 0;
    }

    public String getToken(User user){
        return userDAO.getByPhone(user.getPhone()).getToken();
    }
}
