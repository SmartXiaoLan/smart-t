package com.smt.nio;


import java.nio.*;
import java.nio.channels.DatagramChannel;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;


public class BaseClass {

    /**********************************Buffer缓冲区********************************************/

    //NIO根类。抽象类。
    private Buffer b;

    //缓冲区类
    //Buffer类是抽象类。以下是Java中基本数据类型。主要用于IO传输Java基本数据类型。
    private ByteBuffer bb ;

    private ShortBuffer sb ;

    private IntBuffer ib ;

    private LongBuffer lb ;

    private FloatBuffer fb ;

    private DoubleBuffer db ;

    private CharBuffer cb ;

    //专门用于 *内存映射* 的一种ByteBuffer类型。Bytebuffer使用的更多。
    private MappedByteBuffer mbb ;

    /**********************************Channel通道********************************************/
    //文件操作通道
    private FileChannel fileChannel ;

    //套接字通道.用于TCP连接
    private SocketChannel socketChannel;

    //服务端套接字监听通道，允许监听TCP连接请求，为每一个监听到的请求，创建一个SocketChannel.
    private ServerSocketChannel serverSocketChannel;

    //数据报通道，用于UDP网络链接。
    private DatagramChannel datagramChannel;


    //下的方法会介绍一些API内容

    //Buffer
    public void buffer(){
        //Buffer中一些比较重要的成员属性
        //capacity:容量
        /*
         *  该属性表示内部容量的大小，一旦初始化，不可改变。
         */
        this.b.capacity();

        //position:读写位置
        this.b.position();
        //该方法为翻转方法，由写状态转为读状态的limit变化
        //如 写-->limit 61，读从0开始 --> limit 0。
        this.b.flip();

        //limit:读写最大限制
        this.b.limit();

        //mark:即标记.用于记录当前Position值，用于后续调用。
        this.b.mark();

    }

    public void example(){
        //对应Buffer使用详见项目中的TestDemo.java。
    }

}
