package redisDemo;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
* @类名    jedisTest.java
* @author   Lrz
* @日期:  2019年7月18日
* @描述
*/

public class jedisTest {
	@Test
	public void test() {
		Jedis jedis = new Jedis("hadoop01", 6379);	
		jedis.auth("123456");
		String v1 = jedis.get("k1");
		System.out.println(v1);
		jedis.close();
	}
	@Test
	public void test1() {
		GenericObjectPoolConfig poolConfig = new JedisPoolConfig();
		
		JedisPool jedisPool = new JedisPool(poolConfig, "hadoop01", 6379);
		Jedis jedis = jedisPool.getResource();
		jedis.auth("123456");
		jedis.set("k2", "world");
		System.out.println(jedis.get("k1")+jedis.get("k2"));
                System.out.println(jedis.get("k1")+jedis.get("k2"));
		jedis.close();
	}
}
