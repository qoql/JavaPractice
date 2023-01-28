package com.example.JavaPractice.decompressUtils;

import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class decompressUtils {
    public static void main(String[] args) throws IOException {
        String localPath = "C:\\Users\\40346\\Desktop\\test\\test\\";
        File file = new File("X86_JS_SuYan_CM_CIM_CMP-JS_Manager_V2.5.0_20221121060119_20221121060119_001.json.gz");
        File file1 = new File("file.zip");
//        decompressGZ(file,localPath);
        deZIP(file1,localPath);
    }

    public static void decompressGZ(File file,String localPath) throws IOException {
        GZIPInputStream gzipInputStream = null;
        OutputStream outputStream = null;
        try {
            if(file.getName().endsWith("gz")){
                gzipInputStream = new GZIPInputStream(new FileInputStream(localPath+file.getName()));
                String deFileName = file.getName().replace(".gz","");
                outputStream = new FileOutputStream(localPath+deFileName);
                byte[] bytes = new byte[1024];
                int len;
                while ((len=gzipInputStream.read(bytes))>0){
                    outputStream.write(bytes,0,len);
                }
                outputStream.flush();
            }else{
                System.out.println("不是.gz文件结尾的压缩包");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(gzipInputStream!=null){
                try {
                    gzipInputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(outputStream!=null){
                try {
                    outputStream.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void deZIP(File file,String localPath){
        ZipInputStream zipInputStream = null;
        OutputStream outputStream = null;
        try {
            if(file.getName().endsWith("zip")){
                zipInputStream = new ZipInputStream(new FileInputStream(localPath+file.getName()));
                ZipEntry zipEntry = null;
                while ((zipEntry=zipInputStream.getNextEntry())!=null){
                    String lastFileName = zipEntry.getName();
                    outputStream = new FileOutputStream(localPath+lastFileName);
                    byte[] bytes = new byte[1024];
                    int len;
                    while((len=zipInputStream.read(bytes))>0){
                        outputStream.write(bytes,0,len);
                    }
                }
                System.out.println(1);
            }else {
                System.out.println("不是zip结尾的文件");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(zipInputStream!=null){
                try {
                    zipInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }




    }



}
