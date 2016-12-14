package com.lcl.hw.framework.batch;

import com.lcl.hw.framework.serializer.RedisSerializer;
import com.lcl.hw.framework.utils.KeyUtils;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Response;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * Created by Rain on 2016/12/13 20:18.
 */
@Component
public class RedisResultMap<K, V> extends HashMap<K, V> {
    @Resource(
            name = "jdkRedisSerializer"
    )
    private RedisSerializer valueSerializer;
    @Resource
    private KeyUtils keyUtils;

    public RedisResultMap() {
    }

    public V put(K key, V value) {
        return super.put(key, value);
    }

    public V get(Object key) {
        if(this.isEmpty()) {
            return null;
        } else {
            Response response = (Response)super.get(this.keyUtils.getKey((String)key));
            if(response == null) {
                return null;
            } else {
                Object obj = response.get();
                return (V) (obj instanceof String?obj:(obj instanceof byte[]?this.valueSerializer.deserialize((byte[])((byte[])obj)):obj));
            }
        }
    }
}

