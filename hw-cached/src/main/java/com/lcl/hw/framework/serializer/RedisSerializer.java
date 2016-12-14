package com.lcl.hw.framework.serializer;

/**
 * Created by Rain on 2016/12/13 20:06.
 */
public interface RedisSerializer<T> {
    byte[] serialize(T var1);

    T deserialize(byte[] var1);
}
