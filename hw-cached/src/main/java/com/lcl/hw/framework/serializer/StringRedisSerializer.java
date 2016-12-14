package com.lcl.hw.framework.serializer;

import org.springframework.stereotype.Component;

/**
 * Created by Rain on 2016/12/13 20:08.
 */
@Component
public class StringRedisSerializer implements RedisSerializer<String> {
    public StringRedisSerializer() {
    }

    public String deserialize(byte[] bytes) {
        return bytes == null?null:new String(bytes);
    }

    public byte[] serialize(String string) {
        return string == null?null:string.getBytes();
    }
}
