package com.tianyi.system.cache;

import com.tianyi.system.util.JedisUtil;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.SerializationUtils;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : LiYong
 * @program : RedisCache
 * @description : cache 实例
 * @date : 2019/9/12 11:22
 */
@Component
public class RedisCache<K, V> implements Cache<K, V> {

    @Autowired
    private JedisUtil jedisUtil;

    // 缓存前缀
    private final String CACHE_PREFIX = "sys-cache";

    private byte[] getKey(K k) {
        if (k instanceof String) {
            return (CACHE_PREFIX + k).getBytes();
        }
        return SerializationUtils.serialize(k);
    }

    @Override
    public V get(K k) throws CacheException {
        byte[] value = jedisUtil.get(getKey(k));
        if (value != null) {
            return (V) SerializationUtils.deserialize(value);
        }
        return null;
    }

    @Override
    public V put(K k, V v) throws CacheException {
        byte[] key = getKey(k);
        byte[] value = SerializationUtils.serialize(v);
        jedisUtil.set(key, value);
        jedisUtil.expire(key, 600);
        return v;
    }

    @Override
    public V remove(K k) throws CacheException {
        byte[] key = getKey(k);
        byte[] value = jedisUtil.get(key);
        jedisUtil.del(key);
        if (value != null) {
            return (V) SerializationUtils.deserialize(value);
        }
        return null;
    }

    @Override
    public void clear() throws CacheException {

    }

    @Override
    public int size() {
        return jedisUtil.size();
    }

    @Override
    public Set<K> keys() {
        Set<byte[]> keys = jedisUtil.keys(CACHE_PREFIX);
        Set<K> kSet = new HashSet<>();
        if (keys != null && !keys.isEmpty()) {
            for (byte[] key : keys) {
                kSet.add((K) SerializationUtils.deserialize(key));
            }
        }
        return kSet;
    }

    @Override
    public Collection<V> values() {
        Set<byte[]> keys = jedisUtil.keys(CACHE_PREFIX);
        Set<V> kSet = new HashSet<>();
        if (CollectionUtils.isEmpty(keys)){
            return kSet;
        }
        for (byte[] key : keys) {
            V v = (V) SerializationUtils.deserialize(jedisUtil.get(key));
            kSet.add(v);
        }
        return kSet;
    }
}
