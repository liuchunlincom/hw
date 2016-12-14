package com.lcl.hw.framework.config;

import com.lcl.hw.framework.batch.RedisBatchClient;
import com.lcl.hw.framework.utils.RedisServersInfo;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.ShardedJedisPool;

/**
 * Created by Rain on 2016/12/13 20:13.
 */
@Configuration
@Conditional({ShardedJedisCondition.class})
public class ShardedJedisConfig {
    @Autowired
    private RedisServersInfo redisServersInfo;
    @Autowired
    private GenericObjectPoolConfig jedisPoolConfig;

    public ShardedJedisConfig() {
    }

    @Bean(
            name = {"shardedJedisPool"}
    )
    public ShardedJedisPool getShardedJedisPool() {
        return new ShardedJedisPool(this.jedisPoolConfig, this.redisServersInfo.getShardInfoList());
    }

    @Bean(
            name = {"cacheBatchClient"}
    )
    public RedisBatchClient getRedisBatchClient() {
        return new RedisBatchClient();
    }
}

