package com.smt.nio;

import org.junit.Test;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class UseChannelDemo {

    private final static String FILE_PATH = "E:/JetBrains/IDEA/JavaSE/javaSe/src/com/smt/nio/document";

    /**
     * 文件管道操作
     */
    @Test
    public void fileChannel() throws IOException {
        //常规的方式
        FileInputStream fileInputStream = new FileInputStream(new File(FILE_PATH));
        FileChannel inChannel = fileInputStream.getChannel();

        FileOutputStream outputStream = new FileOutputStream("aaa");
        FileChannel outChannel = outputStream.getChannel();

        //文件随机访问类
        RandomAccessFile file = new RandomAccessFile(FILE_PATH,"rw");
        FileChannel inchannel = file.getChannel();

        //获取一个字节缓冲区。
        ByteBuffer allocate = ByteBuffer.allocate(2048);
        int len = -1;

        //读取文件数据
        while ((len = inchannel.read(allocate)) != -1){
            //做一些其他的事情

            //如果写入缓冲区后需要读取缓冲区数据则需要反转
            allocate.flip();
            int outLen = 0 ;
            while ((outLen = outChannel.read(allocate)) != 0){
                //做一些其他的事情
                System.out.println("写入的字节数：" + outLen);
            }
        }

        //后续处理
        //关闭相应的通道
        inchannel.close();
        outChannel.close();
        // ....

        //强制刷新到磁盘
        outChannel.force(true);

    }

    /**
     * 套接字管道
     *  ServerSocketChannel与SocketChannel都支持阻塞与非阻塞两种模式。可通过以下方式设置
     *      field.configureBlocking(true/false)true表示阻塞，反之非阻塞.默认阻塞
     *   在阻塞模式下连接、读、写都与OIO差不多都是同步的。
     */
    public void socketChannel() throws IOException, InterruptedException {
        //获取一个套接字传输管道
        SocketChannel socketChannel = SocketChannel.open();

        //设置为非阻塞模式
        socketChannel.configureBlocking(false);

        //对服务器的IP&端口发起连接
        socketChannel.connect(new InetSocketAddress("127.0.0.1",80));

        //非阻塞情况下，与服务器的连接还没有真正建立就方法就返回了。因此才需要不断自旋，检查当前是否连接到主机
        while (! socketChannel.finishConnect()){
            //做点其他什么事。个人觉得没有连接什么都做不了
            Thread.sleep(3000);
        }

        /******************************ServerSocketChannel**************************************/
        //新连接事件到来，先通过事件，获取服务器监听通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        SocketChannel serverChannel = serverSocketChannel.accept();
        serverChannel.configureBlocking(false);

        //数据的读写，前提是可以读去，写入
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //读取时由于是异步操作因此需要取得返回值看看是否读取到了数据如果时-1表示没有数据
        int read = socketChannel.read(buffer);

        //写入
        buffer.flip();

        socketChannel.write(buffer);

        //后续步骤
        //终止方法向对方发送一个标识符（-1）
        socketChannel.shutdownOutput();

        //关闭套接字连接
        socketChannel.close();

    }

    /**
     * 数据包管道(UDP)
     *  默认的是阻塞管道
     */
    public void datagramChannel() throws IOException{
        //数据报管道创建
        DatagramChannel datagramChannel = DatagramChannel.open();

        //设置非阻塞
        datagramChannel.configureBlocking(false);

        //监听端口的绑定
        datagramChannel.bind(new InetSocketAddress(10086));

        //设置缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        //接受数据到缓冲区
        SocketAddress receive = datagramChannel.receive(buffer);

        //缓冲区I/O转换为读模式
        buffer.flip();

        //数据报的发送
        datagramChannel.send(buffer , new InetSocketAddress("localhost",10087));

        //清空缓冲区转换写模式
        buffer.clear();

        //关闭流
        datagramChannel.close();

    }

}
