package cn.likole.service;

import cn.likole.dao.SecondHandGoodDAO;
import cn.likole.entity.SecondHandGood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by likole on 5/31/2017.
 */
@Transactional
@Service
public class SecondHandService {
    @Autowired
    SecondHandGoodDAO secondHandGoodDAO;

    public List<SecondHandGood> getList(int start,int num) {
        return secondHandGoodDAO.getList(start,num);
    }
}
