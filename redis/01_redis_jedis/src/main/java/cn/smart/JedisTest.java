package cn.smart;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;

import java.util.HashSet;
import java.util.Set;

public class JedisTest {
    public static void main(String[] args) {
//        testJedisSingle();
//        testJedisPopl();
        testJedisCluster();
    }


    /**
     * 单机版Redis操作
     */
    public static void testJedisSingle(){
        //创建Jedis对象
        Jedis jedis = new Jedis("192.168.66.186",6379);
        //调用Jedis的API完成操作，Jedis的方法命名与操作Jedis的命令命名一致
        String result = jedis.set("key1", "Hello");
        System.out.println(result);
        String key1 = jedis.get("key1");
        System.out.println(key1);
        System.out.println();
        Long hset = jedis.hset("user", "username", "kevin");
        System.out.println(hset);
        System.out.println(jedis.hget("user","username"));
        //必要的
        jedis.close();
    }

    /**
     * 使用连接池操作
     */
    public static void testJedisPopl(){
        //创建连接池
        JedisPool jedisPool = new JedisPool("192.168.66.186",6379);
        Jedis jedis = jedisPool.getResource();
        String username = jedis.hget("user", "username");
        System.out.println(username);
        jedis.close();
    }

    /**
     * 对集群的操作
     */
    public static void testJedisCluster(){
        //创建HostAndPort对象:集群中的一个节点
        Set<HostAndPort> nodes = new HashSet<>();
        nodes.add(new HostAndPort("192.168.66.186",8001));
        nodes.add(new HostAndPort("192.168.66.186",8002));
        nodes.add(new HostAndPort("192.168.66.186",8003));
        nodes.add(new HostAndPort("192.168.66.186",8004));
        nodes.add(new HostAndPort("192.168.66.186",8005));
        nodes.add(new HostAndPort("192.168.66.186",8006));
        //创建操作集群的对象
        JedisCluster cluster = new JedisCluster(nodes);

        cluster.set("jedis","helloJedis");
        String result = cluster.get("jedis");
        System.out.println(result);
        cluster.close();
    }

}
