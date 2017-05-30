package cn.likole.controller;

import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by likole on 4/16/2017.
 */
@Controller
@Scope("prototype")
public class ErrorController extends ActionSupport{

    private Map<String,Object> map=new HashMap<String,Object>();

    public Map<String, Object> getMap() {
        return map;
    }

    public String notFound() throws IOException {
            map.put("status",404);
        map.put("message","Not found");
        return SUCCESS;
    }
}
