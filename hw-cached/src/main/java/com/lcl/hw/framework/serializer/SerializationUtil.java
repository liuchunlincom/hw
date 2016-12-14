package com.lcl.hw.framework.serializer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * Created by Rain on 2016/12/13 20:07.
 */
@Component
public class SerializationUtil {
    @Resource(
            name = "stringRedisSerializer"
    )
    private RedisSerializer keySerializer;
    @Resource(
            name = "jdkRedisSerializer"
    )
    private RedisSerializer valueSerializer;

    public SerializationUtil() {
    }

    public byte[] rawKey(Object key) {
        return this.keySerializer == null && key instanceof byte[]?(byte[])((byte[])key):this.keySerializer.serialize(key);
    }

    public byte[] rawValue(Object value) {
        return this.valueSerializer == null && value instanceof byte[]?(byte[])((byte[])value):this.valueSerializer.serialize(value);
    }

    public byte[][] rawValues(Object... values) {
        byte[][] rawValues = new byte[values.length][];
        int i = 0;
        Object[] var4 = values;
        int var5 = values.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            Object value = var4[var6];
            rawValues[i++] = this.rawValue(value);
        }

        return rawValues;
    }

    public <T extends Collection<?>> T deserializeValues(Collection<byte[]> rawValues, Class<T> type, RedisSerializer<?> redisSerializer) {
        if(rawValues == null) {
            return null;
        } else {
            Object values = List.class.isAssignableFrom(type)?new ArrayList(rawValues.size()):new LinkedHashSet(rawValues.size());
            Iterator var5 = rawValues.iterator();

            while(var5.hasNext()) {
                byte[] bs = (byte[])var5.next();
                ((Collection)values).add(redisSerializer.deserialize(bs));
            }

            return (T)values;
        }
    }

    public <T> Set<T> deserialize(Set<byte[]> rawValues) {
        return (Set)this.deserializeValues(rawValues, Set.class, this.valueSerializer);
    }

    public <T> List<T> deserialize(List<byte[]> rawValues) {
        return (List)this.deserializeValues(rawValues, List.class, this.valueSerializer);
    }

    public <T> Collection<T> deserialize(Collection<byte[]> rawValues) {
        return this.deserializeValues(rawValues, List.class, this.valueSerializer);
    }
}

