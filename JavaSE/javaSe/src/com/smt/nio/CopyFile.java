package com.smt.nio;

import com.smt.util.StreamCloseUtil;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFile {

    public static void main(String[] args) {

        nioFileCopy("F:\\高级工具集\\CentOS-8-x86_64-1905-dvd1.iso","E:/CentOS8.iso");
    }

    public static void nioFileCopy(String resourcePath , String destPath){
        //源文件
        File resourceFile = new File(resourcePath);

        //复制的文件
        File destFile = new File(destPath);

        try {
            if (!destFile.exists()) destFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long startTime = System.currentTimeMillis();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inFileChannel = null;
        FileChannel outFileChannel = null;

        try {
            fis = new FileInputStream(resourceFile);

            fos = new FileOutputStream(destFile);

            inFileChannel = fis.getChannel();

            outFileChannel = fos.getChannel();

            int length = -1;

            //创建缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(2048);

            while ((length = inFileChannel.read(buffer)) != -1){
                //转换缓冲区为读模式
                buffer.flip();

                int outLength = 0;

                //写入管道
                //transferFrom可以进一步提升效率
                while ((outLength = outFileChannel.write(buffer)) != 0){
                    System.out.println("Read Byte Out :" + outLength + "bytes");
                }

                //转换为写模式
                buffer.clear();
            }

            //刷新
            outFileChannel.force(true);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            StreamCloseUtil.closeAll(outFileChannel,fos,inFileChannel,fis);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Use Time : " + (endTime - startTime));

    }
}
