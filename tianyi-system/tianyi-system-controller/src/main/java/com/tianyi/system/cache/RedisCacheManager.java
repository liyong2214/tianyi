package com.tianyi.system.cache;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author : LiYong
 * @program : RedisCacheManager
 * @description : redis缓存
 * @date : 2019/9/12 11:21
 */
public class RedisCacheManager implements CacheManager {

    @Autowired
    private RedisCache redisCache;

    @Override
    public <K, V> Cache<K, V> getCache(String s) throws CacheException {
        return redisCache;
    }
}
