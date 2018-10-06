package com.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;

public class RedisMain {

	// 使用logback
	public static final Logger LOGGER = LoggerFactory.getLogger(RedisMain.class);

	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		String response = jedis.ping();
		System.out.println(response);

		LOGGER.debug(response);
		LOGGER.warn(response);
		LOGGER.error(response);
		LOGGER.info(response);
		LOGGER.trace(response);
		// LOGGER.fatal(response);

	}

}
