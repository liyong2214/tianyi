package com.tianyi.trade.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * 产生和释放jedis
 * @Author: Hens
 * @Date: 2019/8/30 17:43
 */
public class JedisUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(JedisUtil.class);

    private static JedisPool jedisPool;

    static{
        InputStream inputStream = JedisUtil.class.getClassLoader().getResourceAsStream("jedis.properties");
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            jedisPoolConfig.setMaxIdle(Integer.valueOf(properties.getProperty("maxIdle")));
            jedisPoolConfig.setMaxTotal(Integer.valueOf(properties.getProperty("maxTotal")));
            jedisPool = new JedisPool(jedisPoolConfig,properties.getProperty("host"),Integer.valueOf(properties.getProperty("port")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

    public static void release(Jedis jedis){
        jedis.close();
    }

    public static void returnSource(Jedis jedis,boolean isBroken){
        if(jedis == null) {
            return;
        }
        jedis.close();
    }
    /**
     * 通过key查询value
     * @param key
     * @param redisIndex
     * @return String
     */
    public static String set(String key,int redisIndex){
        Jedis jedis = null;
        String result = null;
        boolean isBroken = false;
        try {
            jedis = getJedis();
            jedis.select(redisIndex);
            result = jedis.get(key);
        }catch (Exception e){
            isBroken = true;
            LOGGER.error("Set key error : [{}]",e);
            throw e;
        }finally {
            returnSource(jedis,isBroken);
        }
        return result;
    }

    /**
     * 删除指定key缓存
     * @param key
     * @param redisIndex
     */
    public static void delete(String key, int redisIndex){
        Jedis jedis = getJedis();
        boolean isBroken = false;
        try {
            jedis.select(redisIndex);
            Long del = jedis.del(key);
        }catch (Exception e){
            isBroken = true;
            LOGGER.error("Delete key error : [{}]", e);
            throw e;
        }finally {
            returnSource(jedis,isBroken);
        }
    }

    /**
     * 添加限时缓存
     * @param key
     * @param value
     * @param redisIndex
     * @param expireTime
     */
    public static void set(String key, String value, int redisIndex, int expireTime) {
        Jedis jedis = getJedis();
        boolean isBroken = false;
        try {
            jedis.select(redisIndex);
            jedis.set(key, value);
            if (expireTime > 0) {
                jedis.expire(key, expireTime);
            } else {
                jedis.expire(key, 60);
            }
        }catch (Exception e){
            isBroken = true;
            LOGGER.error("Set key error : [{}]",e);
            throw e;
        }finally {
            returnSource(jedis,isBroken);
        }
    }

    /**
     * 设置 byte[]
     * @param key
     * @param value
     */
    public synchronized static void set(byte[] key, byte[] value) {
        try {
            Jedis jedis = getJedis();
            jedis.set(key, value);
            jedis.close();
        } catch (Exception e) {
            LOGGER.error("Set key error : [{}]",e);
        }
    }

    /**
     * 设置 String 过期时间
     * @param key
     * @param value
     * @param seconds 以秒为单位
     */
    public synchronized static void set(String key, String value, int seconds) {
        try {
            value = StringUtils.isBlank(value) ? "" : value;
            Jedis jedis = getJedis();
            jedis.setex(key, seconds, value);
            jedis.close();
        } catch (Exception e) {
            LOGGER.error("Set keyex error : [{}]",e);
        }
    }

    /**
     * 设置 byte[] 过期时间
     * @param key
     * @param value
     * @param seconds 以秒为单位
     */
    public synchronized static void set(byte[] key, byte[] value, int seconds) {
        try {
            Jedis jedis = getJedis();
            jedis.set(key, value);
            jedis.expire(key, seconds);
            jedis.close();
        } catch (Exception e) {
            LOGGER.error("Set keyex error : [{}]",e);
        }
    }

    /**
     * 获取String值
     * @param key
     * @return value
     */
    public synchronized static String get(String key) {
        Jedis jedis = getJedis();
        if (null == jedis) {
            return null;
        }
        String value = jedis.get(key);
        jedis.close();
        return value;
    }

    /**
     * 获取byte[]值
     * @param key
     * @return value
     */
    public synchronized static byte[] get(byte[] key) {
        Jedis jedis = getJedis();
        if (null == jedis) {
            return null;
        }
        byte[] value = jedis.get(key);
        jedis.close();
        return value;
    }

    /**
     * 删除值
     * @param key
     */
    public synchronized static void remove(String key) {
        try {
            Jedis jedis = getJedis();
            jedis.del(key);
            jedis.close();
        } catch (Exception e) {
            LOGGER.error("Remove keyex error : [{}]", e);
        }
    }

    /**
     * 删除值
     * @param key
     */
    public synchronized static void remove(byte[] key) {
        try {
            Jedis jedis = getJedis();
            jedis.del(key);
            jedis.close();
        } catch (Exception e) {
            LOGGER.error("Remove keyex error : [{}]", e);
        }
    }

    /**
     * lpush 添加 list
     * @param key
     * @param key
     */
    public synchronized static void lpush(String key, String... strings) {
        try {
            Jedis jedis = JedisUtil.getJedis();
            jedis.lpush(key, strings);
            jedis.close();
        } catch (Exception e) {
            LOGGER.error("lpush error :[{}] ", e);
        }
    }

    /**
     * rpush list
     * @param key
     * @param strings
     */
    public synchronized static void rpush(String key, String... strings) {
        try {
            Jedis jedis = JedisUtil.getJedis();
            jedis.rpush(key, strings);
            jedis.close();
        } catch (Exception e) {
            LOGGER.error("lpush error :[{}] ", e);
        }
    }

    /**
     * lrem 移除元素 list
     * @param key
     * @param count
     * @param value
     */
    public synchronized static void lrem(String key, long count, String value) {
        try {
            Jedis jedis = JedisUtil.getJedis();
            jedis.lrem(key, count, value);
            jedis.close();
        } catch (Exception e) {
            LOGGER.error("lpush error :[{}] ", e);
        }
    }

    /**
     * 统计总数
     * @param key
     * @return
     */
    public synchronized static Long llen(String key){
        try {
            Jedis jedis = JedisUtil.getJedis();
            Long total = jedis.llen(key);
            jedis.close();
            return total;
        }catch (Exception e){
            LOGGER.error("llen erro:[{}]", e);
        }
        return 0L;
    }

    /**
     * lrange 范围查询元素
     * @param key
     * @param start 开始下标
     * @param end 结束下标
     */
    public synchronized static List<String> lrange(String key, Long start, Long end){
        try {
            Jedis jedis = JedisUtil.getJedis();
            List<String> lrange = jedis.lrange(key, start, end);
            jedis.close();
            return lrange;
        }catch (Exception e){
            LOGGER.error("lrange error:[{}]", e);
        }
        return null;
    }

    /**
     * sadd set
     * @param key
     * @param value
     * @param seconds
     */
    public synchronized static void sadd(String key, String value, int seconds) {
        try {
            Jedis jedis = JedisUtil.getJedis();
            jedis.sadd(key, value);
            jedis.expire(key, seconds);
            jedis.close();
        } catch (Exception e) {
            LOGGER.error("sadd error :[{}] ", e);
        }
    }

    /**
     * hset
     * @param key
     * @param field
     * @param value
     * @param seconds
     */
    public synchronized static void hset(String key,String field, String value, int seconds){
        try {
            Jedis jedis = JedisUtil.getJedis();
            jedis.hset(key, field, value);
            jedis.expire(key, seconds);
            jedis.close();
        }catch (Exception e){
            LOGGER.error("hset error:[{}]", e);
        }
    }

    /**
     * hget 获取hash中的值
     * @param key
     * @param fields
     * @return
     */
    public synchronized static List<String> hmget(String key, String... fields){
        try {
            Jedis jedis = JedisUtil.getJedis();
            List<String> hmget = jedis.hmget(key, fields);
            jedis.close();
            return hmget;
        }catch (Exception e){
            LOGGER.error("hset error:[{}]", e);
        }
        return null;
    }

    /**
     * zadd 添加scoredset
     * @param key
     * @param scoreMembers
     */
    public synchronized static void zadd(String key, Map<String, Double> scoreMembers){
        try {
            Jedis jedis = JedisUtil.getJedis();
            jedis.zadd(key, scoreMembers);
            jedis.close();
        }catch (Exception e){
            LOGGER.error("zadd error:[{}]", e);
        }
    }

    /**
     * zrange
     * @param key
     * @param start
     * @param end
     * @return
     */
    public synchronized static Set<String> zrange(String key, long start, long end){
        try {
            Jedis jedis = JedisUtil.getJedis();
            Set<String> zrange = jedis.zrange(key, start, end);
            jedis.close();
            return zrange;
        }catch (Exception e){
            LOGGER.error("zrange error:[{}]", e);
        }
        return null;
    }

    /**
     * zcard
     * @param key
     * @return
     */
    public synchronized static Long zcard(String key){
        try {
            Jedis jedis = JedisUtil.getJedis();
            Long zcard = jedis.zcard(key);
            jedis.close();
            return zcard;
        }catch (Exception e){
            LOGGER.error("zcard error:[{}]", e);
        }
        return null;

    }

    /**
     * incr 增加
     * @param key
     * @return value
     */
    public synchronized static Long incr(String key) {
        Jedis jedis = getJedis();
        if (null == jedis) {
            return null;
        }
        long value = jedis.incr(key);
        jedis.close();
        return value;
    }

    /**
     * decr 减少
     * @param key
     * @return value
     */
    public synchronized static Long decr(String key) {
        Jedis jedis = getJedis();
        if (null == jedis) {
            return null;
        }
        long value = jedis.decr(key);
        jedis.close();
        return value;
    }
}
