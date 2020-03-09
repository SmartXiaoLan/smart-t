package cn.smart;

import cn.smart.jedisdao.JedisDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

public class TestJedisSpring {

    public static void main(String[] args) {
//        testJedisSingle();
        testJedisCluster();
    }

    /**
     * 测试单机版Jedis
     */
    public static void testJedisSingle(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-Jedis.xml");
        JedisDao jedisDao = context.getBean("jedisDaoImplSingle", JedisDao.class);
        String set = jedisDao.set("spring", "hello");
        System.out.println(set);
        System.out.println(jedisDao.get("spring"));
        context.close();
    }

    /**
     * 测试集群版Jedis
     */
    public static void testJedisCluster(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext-Jedis.xml");
        JedisDao jedisDao = context.getBean("jedisDaoImplCluster", JedisDao.class);
        String set = jedisDao.set("smart", UUID.randomUUID().toString().replaceAll("-",""));
        System.out.println(set);
        System.out.println(jedisDao.get("smart"));
        context.close();
    }

}
