package com.lcl.hw.framework.config;

import com.lcl.hw.framework.utils.RedisServersInfo;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisCluster;

/**
 * Created by Rain on 2016/12/13 20:11.
 */
@Configuration
@Conditional({JedisClusterCondition.class})
public class JedisClusterConfig {
    @Autowired
    private RedisServersInfo redisServersInfo;
    @Autowired
    private GenericObjectPoolConfig jedisPoolConfig;
    @Value("${redis_timeout}")
    private int timeout;
    @Value("${redis_max_redirections}")
    private int maxRedirections;

    public JedisClusterConfig() {
    }

    @Bean
    public JedisCluster getJedisCluster() {
        return new JedisCluster(this.redisServersInfo.getClusterServersSet(), this.timeout, this.maxRedirections, this.jedisPoolConfig);
    }
}
