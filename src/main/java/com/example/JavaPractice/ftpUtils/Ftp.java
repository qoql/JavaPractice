package com.example.JavaPractice.ftpUtils;

import org.apache.commons.net.ftp.FTPClient;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ftp {

    public static void main(String[] args) {
        String ftpuser="ftpuser1";
        String ftppass="123456";
        String localPath="C:\\Users\\40346\\Desktop\\test\\test";
        FTPClient ftpClient = null;
        OutputStream outputStream = null;
        try {
            ftpClient = new FTPClient();
            ftpClient.setControlEncoding("UTF-8");
            ftpClient.enterLocalPassiveMode();
            ftpClient.connect("192.168.3.214",21);
            boolean login = ftpClient.login(ftpuser, ftppass);
            if(login){
                ftpClient.changeWorkingDirectory("/home/ftpuser1/CIM/CM");
                outputStream = new FileOutputStream(localPath+"/X86_JS_SuYan_CM_CIM_CMP-JS_Manager_V2.5.0_20221121060119_20221121060119_001.json.gz");
                boolean b = ftpClient.retrieveFile("X86_JS_SuYan_CM_CIM_CMP-JS_Manager_V2.5.0_20221121060119_20221121060119_001.json.gz", outputStream);
                if(b){
                    System.out.println("已下载文件，本地地址："+localPath);
                }else{
                    System.out.println("文件下载失败");
                }

            }else{
                System.out.println("登录失败");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(ftpClient!=null){
                try {
                    ftpClient.logout();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
