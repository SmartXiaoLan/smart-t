package cn.smart.jedisdao.impl;

import cn.smart.jedisdao.JedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisDaoImplSingle implements JedisDao {

    @Autowired
    private JedisPool jedisPool;

    @Override
    public String set(String key, String value) {
        Jedis jedis = this.jedisPool.getResource();
        return jedis.set(key, value);
    }

    @Override
    public String get(String key) {
        Jedis jedis = this.jedisPool.getResource();
        return jedis.get(key);
    }

    @Override
    public Long hset(String hkey, String key, String value) {
        Jedis jedis = this.jedisPool.getResource();
        return jedis.hset(hkey, key, value);
    }

    @Override
    public String hget(String hkey, String key) {
        Jedis jedis = this.jedisPool.getResource();
        return jedis.hget(hkey, key);
    }

    @Override
    public Long expire(String key, Integer seconds) {
        return this.jedisPool.getResource().expire(key,seconds);
    }

    @Override
    public Long del(String key) {
        return this.jedisPool.getResource().del(key);
    }
}
