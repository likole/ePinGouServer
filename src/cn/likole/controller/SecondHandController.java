package cn.likole.controller;

import cn.likole.entity.SecondHandGood;
import cn.likole.service.SecondHandService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by likole on 5/31/2017.
 */
@Controller
@Scope("prototype")
public class SecondHandController extends ActionSupport implements ModelDriven<SecondHandGood> {

    @Autowired
    SecondHandService secondHandService;

    Map<String, Object> map = new HashMap<String, Object>();

    public Map<String, Object> getMap() {
        return map;
    }

    SecondHandGood secondHandGood = new SecondHandGood();

    int start = 0;
    int num=10;

    public void setNum(int num) {
        this.num = num;
    }

    public void setStart(int start) {
        this.start = start;
    }

    @Override
    public SecondHandGood getModel() {
        return secondHandGood;
    }

    public String getList() {
        List<SecondHandGood> list = secondHandService.getList(start,num);
        if (list == null) {
            map.put("status", 100);
        } else {
            map.put("status", 0);
            map.put("list", list);
            map.put("next",start+list.size());
        }
        return SUCCESS;
    }
}
