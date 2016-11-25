package com.nuc.gu.test.redis;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
/**
 * Redis与Java连接的一些操作
 * @author GU
 *
 */
public class RedisTest {

	public static void main(String[] args) {
		connectToRedis();
		stringAtRedis();
		listAtRedis();
		keysAtRedis();
	}
	//连接本地的 Redis 服务
	public static void connectToRedis(){
		//new一个jedis对象 主机地址为本机
	    Jedis jedis = new Jedis("localhost");
	    System.out.println("Connection to server sucessfully");
	    //查看服务是否运行
	    System.out.println("Server is running: "+jedis.ping());
	}
	//Redis Java String(字符串) 实例
	public static void stringAtRedis(){
		//连接本地Redis
		Jedis jedis = new Jedis("localhost");
		//设置redis字符串数据
		jedis.set("runnoobkey", "runnoobvalue");
		//获取存储的数据并输出
		System.out.println("获得的数据：" + jedis.get("runnoobkey"));
	}
	//Redis Java List(列表) 实例
	public static void listAtRedis(){
		//连接本地Redis
		Jedis jedis = new Jedis("localhost");
		//存储数据到列表中
		jedis.lpush("redis-list", "Redis");
		jedis.lpush("redis-list", "Mongodb");
		jedis.lpush("redis-list", "Mysql");
		//获取存储的数据并输出
		List<String> list = jedis.lrange("redis-list", 0, 2);
		for (int i=0;i<list.size();i++) {
			System.out.println("List中的元素"+i+":"+list.get(i));
		}
	}
	//Redis Java Keys 实例
	public static void keysAtRedis(){
		//连接本地Redis
		Jedis jedis = new Jedis("localhost");
		//获取存储的数据并输出
		Set<String> keys = jedis.keys("*");
		System.out.println("Redis中的key值有:");
		for (String key : keys) {
			System.out.print(key+";");
		}
	}
}
