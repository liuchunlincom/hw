package com.lcl.hw.framework.batch;

import com.lcl.hw.framework.serializer.RedisSerializer;
import com.lcl.hw.framework.serializer.SerializationUtil;
import com.lcl.hw.framework.utils.AbstractCacheClient;
import com.lcl.hw.framework.utils.TimeoutUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Response;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPipeline;
import redis.clients.jedis.ShardedJedisPool;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Rain on 2016/12/13 19:32.
 */
public class RedisBatchClient extends AbstractCacheClient implements CacheBatchClient {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired(
            required = false
    )
    private ShardedJedisPool pool;
    @Resource(
            name = "stringRedisSerializer"
    )
    private RedisSerializer keySerializer;
    @Resource(
            name = "jdkRedisSerializer"
    )
    private RedisSerializer valueSerializer;
    @Resource
    private SerializationUtil serializerUtil;
    @Resource
    private TimeoutUtils timeoutUtils;
    @Resource
    private RedisResultMap redisResultMap;
    @Resource
    private RedisResultList redisResultList;
    private ShardedJedis shardedJedis;
    private ShardedJedisPipeline shardedJedisPipeline;

    public RedisBatchClient() {
    }

    public ShardedJedisPipeline getShardedJedisPipeline() {
        return this.shardedJedisPipeline;
    }

    public void setShardedJedisPipeline(ShardedJedisPipeline shardedJedisPipeline) {
        this.shardedJedisPipeline = shardedJedisPipeline;
    }

    public void startBatch() {
        this.shardedJedis = this.pool.getResource();
        this.setShardedJedisPipeline(this.shardedJedis.pipelined());
    }

    public void endBatch() {
        this.getShardedJedisPipeline().sync();
        if(this.shardedJedis != null) {
            this.shardedJedis.close();
        }

    }

    public void releaseResource() {
        if(this.shardedJedis != null) {
            this.shardedJedis.close();
        }

    }

    private <T> T syncAndReturnAll() {
        return (T) this.getShardedJedisPipeline().syncAndReturnAll();
    }

    public void init() {
    }

    public <T> void put(String key, T value) {
        this.getShardedJedisPipeline().set(this.keySerializer.serialize(this.getKey(key)), this.valueSerializer.serialize(value));
    }

    public <T> T get(String key) {
        Response response = this.getShardedJedisPipeline().get(this.keySerializer.serialize(this.getKey(key)));
        this.redisResultMap.put(this.getKey(key), response);
        return null;
    }

    public void delete(String key) {
        this.getShardedJedisPipeline().del(this.getKey(key));
    }

    public <T> T getFromMap(String mapKey, String key) {
        Response response = this.getShardedJedisPipeline().hget(this.getKey(mapKey), key);
        this.redisResultMap.put(this.getKey(mapKey) + "_" + key, response);
        return null;
    }

    public Set getMapKeys(String mapKey) {
        Response response = this.getShardedJedisPipeline().hkeys(this.getKey(mapKey));
        this.redisResultMap.put(this.getKey(mapKey), response);
        return null;
    }

    public <T> void setToMap(String mapKey, String key, T value) {
        this.getShardedJedisPipeline().hset(this.getKey(mapKey), key, (String)value);
    }

    public void deleteFromMap(String mapKey, String... keys) {
        this.getShardedJedisPipeline().hdel(this.getKey(mapKey), keys);
    }

    public <T> T getFromList(String listKey, long index) {
        byte[] rawKey = this.serializerUtil.rawKey(this.getKey(listKey));
        Response response = this.getShardedJedisPipeline().lindex(rawKey, index);
        this.redisResultList.add(response);
        return null;
    }

    public <T> T setToList(String listKey, long index, T value) {
        byte[] rawKey = this.serializerUtil.rawKey(this.getKey(listKey));
        byte[] rawValue = this.serializerUtil.rawValue(value);
        this.getShardedJedisPipeline().lset(rawKey, index, rawValue);
        return null;
    }

    public <T> Long deleteFromList(String listKey, long count, T value) {
        Response response = this.getShardedJedisPipeline().lrem(this.keySerializer.serialize(this.getKey(listKey)), count, this.valueSerializer.serialize(value));
        this.redisResultList.add(response);
        return null;
    }

    public Long getListLength(String listKey) {
        byte[] rawKey = this.serializerUtil.rawKey(this.getKey(listKey));
        Response response = this.getShardedJedisPipeline().llen(rawKey);
        this.redisResultList.add(response);
        return null;
    }

    public <T> List<T> subList(String listKey, long start, long end) {
        byte[] rawKey = this.serializerUtil.rawKey(this.getKey(listKey));
        Response response = this.getShardedJedisPipeline().lrange(rawKey, start, end);
        this.redisResultList.add(response);
        return null;
    }

    public <T> Long leftPush(String listKey, T... values) {
        byte[] rawKey = this.serializerUtil.rawKey(this.getKey(listKey));
        byte[][] rawValue = this.serializerUtil.rawValues(values);
        this.getShardedJedisPipeline().lpush(rawKey, rawValue);
        return null;
    }

    public <T> Long rightPush(String listKey, T... values) {
        byte[] rawKey = this.serializerUtil.rawKey(this.getKey(listKey));
        byte[][] rawValue = this.serializerUtil.rawValues(values);
        this.getShardedJedisPipeline().rpush(rawKey, rawValue);
        return null;
    }

    public <T> T leftPop(String listKey) {
        byte[] rawKey = this.serializerUtil.rawKey(this.getKey(listKey));
        Response response = this.getShardedJedisPipeline().lpop(rawKey);
        this.redisResultList.add(response);
        return null;
    }

    public <T> T leftPop(String listKey, int timeout) {
        throw new UnsupportedOperationException("Unsupported method");
    }

    public <T> T rightPop(String listKey) {
        byte[] rawKey = this.serializerUtil.rawKey(this.getKey(listKey));
        Response response = this.getShardedJedisPipeline().rpop(rawKey);
        this.redisResultList.add(response);
        return null;
    }

    public <T> T rightPop(String listKey, int timeout) {
        throw new UnsupportedOperationException("Unsupported method");
    }

    public Long expire(String key, long timeout, TimeUnit unit) {
        byte[] rawKey = this.serializerUtil.rawKey(this.getKey(key));
        TimeoutUtils var10000 = this.timeoutUtils;
        long rawTimeout = TimeoutUtils.toMillis(timeout, unit);
        this.getShardedJedisPipeline().pexpire(rawKey, rawTimeout);
        return null;
    }

    public Map getResultMap() {
        return this.redisResultMap;
    }

    public void setResultMap(Map resultMap) {
        this.redisResultMap = this.redisResultMap;
    }

    public void setResultList(List resultList) {
        this.redisResultList = (RedisResultList)resultList;
    }

    public List getResultList() {
        return this.redisResultList;
    }
}

