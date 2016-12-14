package com.lcl.hw.framework.utils;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Created by Rain on 2016/12/13 19:40.
 */
public class EasyShardedJedisPool extends ShardedJedisPool {
    public EasyShardedJedisPool(JedisPoolConfig jedisPoolConfig, RedisServersInfo redisServersInfo) {
        super(jedisPoolConfig, redisServersInfo.getShardInfoList());
    }
}
