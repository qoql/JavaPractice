package com.example.JavaPractice.ftpUtils;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class Sftp {
    Logger logger= LoggerFactory.getLogger(this.getClass());

    public void connectSftp(String path){
        String username = "user1";
        String host = "10.198.1.143";
        int port = 22;
        String password = "123456";
        JSch jSch = new JSch();
        ChannelSftp sftp = null;
        try {
            Session session = jSch.getSession(username, host, port);
            session.setPassword(password);
            session.setTimeout(60*1000);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking","no");
            session.setConfig(config);
            logger.info("开始连接会话");
            session.connect();
            Channel channel = session.openChannel("sftp");
            channel.connect();
            sftp = (ChannelSftp) channel;
            logger.info("连接sftp成功");
            sftp.cd(path);
            sftp.get("/path","/path");
        }catch (Exception e){
            logger.error("发生错误：",e);
        }


    }


    public static void main(String[] args) {
        Sftp sftp = new Sftp();
//        sftp.connectSftp();
    }
}
