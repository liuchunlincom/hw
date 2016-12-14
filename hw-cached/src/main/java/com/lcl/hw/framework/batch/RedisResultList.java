package com.lcl.hw.framework.batch;

import com.lcl.hw.framework.serializer.RedisSerializer;
import com.lcl.hw.framework.utils.KeyUtils;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Response;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rain on 2016/12/13 20:17.
 */
@Component
public class RedisResultList<T> extends ArrayList<T> {
    @Resource(
            name = "jdkRedisSerializer"
    )
    private RedisSerializer valueSerializer;
    @Resource
    private KeyUtils keyUtils;

    public RedisResultList() {
    }

    public boolean add(T value) {
        return super.add(value);
    }

    public T get(int index) {
        if(this.isEmpty()) {
            return null;
        } else {
            Response response = (Response)super.get(index);
            if(response == null) {
                return null;
            } else {
                Object obj = response.get();
                if(obj instanceof String) {
                    return (T) obj;
                } else if(obj instanceof byte[]) {
                    return (T) this.valueSerializer.deserialize((byte[])((byte[])obj));
                } else if(!(obj instanceof List)) {
                    return (T) obj;
                } else {
                    ArrayList ret = new ArrayList();
                    int total = ((List)obj).size();

                    for(int i = 0; i < total; ++i) {
                        ret.add(this.valueSerializer.deserialize((byte[])((byte[])((List)obj).get(i))));
                    }

                    return (T) ret;
                }
            }
        }
    }
}

