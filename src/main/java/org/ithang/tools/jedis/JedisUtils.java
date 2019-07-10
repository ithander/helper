package org.ithang.tools.jedis;

import org.ithang.tools.lang.SpringContextHolder;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisUtils {

   private static JedisPool jedisPool = SpringContextHolder.getBean("jedisPool");
    
    public static void set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        jedis.set(key, value);
    }
    
    public static String get(String key) {
        Jedis jedis = jedisPool.getResource();
        return jedis.get(key);
    }
	
}
