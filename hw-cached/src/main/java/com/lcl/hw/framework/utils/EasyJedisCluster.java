package com.lcl.hw.framework.utils;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.JedisCluster;

/**
 * Created by Rain on 2016/12/13 19:40.
 */
public class EasyJedisCluster extends JedisCluster {
    public EasyJedisCluster(RedisServersInfo jedisClusterNode, int timeout, int maxRedirections, GenericObjectPoolConfig poolConfig) {
        super(jedisClusterNode.getClusterServersSet(), timeout, maxRedirections, poolConfig);
    }
}
