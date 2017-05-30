package cn.likole.controller;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by likole on 5/20/2017.
 */
@Controller
@Scope("prototype")
public class ImageTestController extends ActionSupport{
    private File file;
    private String fileFileName;
    private String fileContentType;
    private Map<String,Object> map=new HashMap<String, Object>();

    public Map<String, Object> getMap() {
        return map;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    @Override
    public String execute() throws Exception {
        String root= ServletActionContext.getServletContext().getRealPath("/upload");
        InputStream is=new FileInputStream(file);
        OutputStream os=new FileOutputStream(new File(root,fileFileName));
        byte[] buffer=new byte[100];
        while(is.read(buffer,0,buffer.length)!=-1)
        {
            os.write(buffer);
        }
        is.close();
        os.close();
        return SUCCESS;
    }
}
