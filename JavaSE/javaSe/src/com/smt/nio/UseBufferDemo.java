package com.smt.nio;

import org.junit.Test;

import java.nio.IntBuffer;

/**
 * @author Smart-T
 *
 */
public class UseBufferDemo {

    static IntBuffer intBuffer = null;

    /**
     * 缓冲区的创建，获取一个实例对象，这里不使用构造器通过new来创建一个实例对象。
     */
    @Test
    public void testIntBufferAllocate(){
        //通过allocate创建缓冲区。
        intBuffer = IntBuffer.allocate(20);
        //简单输出Buffer中主要属性
//        System.out.println("-----------------创建缓冲区后---------------------");
//        System.out.println("position-->" + intBuffer.position());
//        System.out.println("capacity-->" + intBuffer.capacity());
//        System.out.println("limit-->" + intBuffer.limit());

        //写入数据到缓冲区
        for (int i = 0 ; i < 15 ; i ++){
            //将数据存入缓冲区
            intBuffer.put(i);
        }
//        System.out.println("-----------------添加数据后---------------------");
//        System.out.println("position-->" + intBuffer.position());
//        System.out.println("capacity-->" + intBuffer.capacity());
//        System.out.println("limit-->" + intBuffer.limit());

        //翻转由写状态转换为读状态
        intBuffer.flip();
//        System.out.println("-----------------Flip状态改变后---------------------");
//        System.out.println("position-->" + intBuffer.position());
//        System.out.println("capacity-->" + intBuffer.capacity());
//        System.out.println("limit-->" + intBuffer.limit());

        //从缓存中读取数据
        System.out.println("读取测试");
        for (int i = 0 ; i < intBuffer.limit()/2 ; i ++ ){
            System.out.print(intBuffer.get()+"、");
        }
//        System.out.println("\n-----------------读取limit的1/2后的状态---------------------");
//        System.out.println("position-->" + intBuffer.position());
//        System.out.println("capacity-->" + intBuffer.capacity());
//        System.out.println("limit-->" + intBuffer.limit());

        for (int i = 0 ; i < intBuffer.limit()/2+1 ; i ++)
            System.out.print(intBuffer.get()+"、");
//        System.out.println("\n-----------------读取limit最后的1/2后的状态---------------------");
//        System.out.println("position-->" + intBuffer.position());
//        System.out.println("capacity-->" + intBuffer.capacity());
//        System.out.println("limit-->" + intBuffer.limit());

        //读完之后不能立即进入写模式需要使用以下之一进入写模式，注意使用下面的方法会清空之前缓冲区中的数据。
        //清空缓存区
//        intBuffer.clear();
        //压缩缓存区
//        intBuffer.compact();

        //倒带，重复读取一次
        //使用倒带表示position置为0，limit保持不变，mark标记被清除之前保留的mark无法使用
        intBuffer.rewind();
//        System.out.println("-----------------使用rewind倒带后的状态---------------------");
//        System.out.println("position-->" + intBuffer.position());
//        System.out.println("capacity-->" + intBuffer.capacity());
//        System.out.println("limit-->" + intBuffer.limit());
        System.out.println();
        for (int i = 0 ; i < 5 ; i ++){
            //添加mark标记保存当前position值
            if (i == 2) intBuffer.mark();
            System.out.print(intBuffer.get()+"、");
        }

        //将之前的mark的属性值恢复到position中
        System.out.println();
        intBuffer.reset();
        for (int i = 0 ; i < 5 ; i ++ ){
            System.out.print(intBuffer.get() + "、");
        }

        //清空缓存区进入写模式
        intBuffer.clear();

    }


}
