package cn.likole.service;

import cn.likole.dao.UserDAO;
import cn.likole.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by likole on 4/14/2017.
 */
@Transactional
@Service
public class UserService {
    @Autowired
    UserDAO userDAO;
    public void add(User user) {
        userDAO.add(user);
    }
}
