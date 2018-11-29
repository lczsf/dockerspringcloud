package com.lc.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

/**
 * Created by lenovo on 2018/11/28.
 */
@RestController
public class FileController {

    @RequestMapping(path ="/{saveFile}", method = RequestMethod.POST)
    public void saveFile(@RequestBody String fileStr){
        FileOutputStream out=null;
        try {
            File file = new File("/usr/local/files/text.txt");
            out=new FileOutputStream(file);
            PrintStream ps = new PrintStream(out);
            ps.append(fileStr);// 在已有的基础上添加字符串
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(null!=out){
                    out.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}
