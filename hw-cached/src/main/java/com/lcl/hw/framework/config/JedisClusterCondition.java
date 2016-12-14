package com.lcl.hw.framework.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

/**
 * Created by Rain on 2016/12/13 20:10.
 */
@Component
public class JedisClusterCondition implements Condition {
    public JedisClusterCondition() {
    }

    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String redis_server_mode = System.getProperty("redis_server_mode");
        String cache_provider = context.getEnvironment().getProperty("cache_provider");
        return "redis".equalsIgnoreCase(cache_provider) && !"0".equals(redis_server_mode);
    }
}
