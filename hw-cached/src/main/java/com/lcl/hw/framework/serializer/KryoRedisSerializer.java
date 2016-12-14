package com.lcl.hw.framework.serializer;

import org.springframework.stereotype.Component;

/**
 * Created by Rain on 2016/12/13 20:06.
 */
@Component
public class KryoRedisSerializer implements RedisSerializer<Object> {
    public KryoRedisSerializer() {
    }

    public byte[] serialize(Object t) {
        throw new UnsupportedOperationException("Unsupported method");
    }

    public Object deserialize(byte[] bytes) {
        throw new UnsupportedOperationException("Unsupported method");
    }
}
