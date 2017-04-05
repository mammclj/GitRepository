package com.mmm.test;

import org.apache.log4j.Logger;

import com.mmm.utils.redis.RedisUtil;

import redis.clients.jedis.Jedis;

public class TestRedis {

	private static Logger logger = Logger.getLogger(TestRedis.class);
	
	public static void main(String[] args) {
		// 连接本地的 Redis 服务
		Jedis jedis = RedisUtil.getJedis();
		logger.info("Connection to server sucessfully");
		// 查看服务是否运行
		logger.info("Server is running: " + jedis.ping());
		// 设置 redis 字符串数据
		jedis.set("runoobkey", "Redis tutorial");
		// 获取存储的数据并输出
		logger.info("Stored string in redis:: " + jedis.get("runoobkey"));
	}

}
