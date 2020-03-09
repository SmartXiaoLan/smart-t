package cn.smart.jedisdao;

public interface JedisDao {

    String set(String key, String value);

    String get(String key);

    Long hset(String hkey, String key, String value);

    String hget(String hkey, String key);


}
