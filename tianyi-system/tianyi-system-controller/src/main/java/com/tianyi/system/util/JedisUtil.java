package com.tianyi.system.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Set;

/**
 * @author : LiYong
 * @program : JedisUtil
 * @description : jedis工具
 * @date : 2019/9/11 21:34
 */
@Component
public class JedisUtil {

    // 连接池
    @Autowired
    private JedisPool jedisPool;

    // 获取jedis连接
    public Jedis getResouce() {
        return jedisPool.getResource();
    }

    // 释放资源
    public void release(Jedis jedis) {
        jedis.close();
    }

    // 示例

    /*{
        for (int i = 1; i <= 100; i += 1) {
            // 初始化CommentId索引 SortSet
            RedisClient.zadd("topicId", i, "commentId" + i);
            // 初始化Comment数据 Hash
            RedisClient.hset("Comment_Key", "commentId" + i, "comment content "+ i +" .......");
        }
        // 倒序取 从0条开始取 5条 Id 数据
        Set<String> sets = RedisClient.zrevrangebyscore("topicId", "100", "1", 0, 10);
        String[] items = new String[]{};
        System.out.println(sets.toString());
        // 根据id取comment数据
        List<String> list = RedisClient.hmget("Comment_Key", sets.toArray(items));
        for (String str : list) {
            System.out.println(str);
        }

    }*/


    /**
     * 添加到缓存
     *
     * @param key   key
     * @param value value
     */
    public void set(byte[] key, byte[] value) {
        try (Jedis jedis = getResouce()) {
            jedis.set(key, value);
        }
    }

    // 字符串
    public void set(String key, String value) {
        try (Jedis jedis = getResouce()) {
            jedis.set(key, value);
        }
    }

    // 字符串+索引
    public void set(String key, String value, int index) {
        try (Jedis jedis = getResouce()) {
            jedis.select(index);
            jedis.set(key, value);
        }
    }

    /**
     * 设置某个key的超时时间
     *
     * @param key     key
     * @param seconds 时间/秒
     */
    public void expire(byte[] key, int seconds) {
        try (Jedis jedis = getResouce()) {
            jedis.expire(key, seconds);
        }
    }

    public void expire(String key, int seconds) {
        try (Jedis jedis = getResouce()) {
            jedis.expire(key, seconds);
        }
    }

    public void expire(String key, int seconds, int index) {
        try (Jedis jedis = getResouce()) {
            jedis.select(index);
            jedis.expire(key, seconds);
        }
    }

    /**
     * 通过key获取值
     *
     * @param key key
     * @return value
     */
    public byte[] get(byte[] key) {
        try (Jedis jedis = getResouce()) {
            return jedis.get(key);
        }
    }

    public String get(String key) {
        try (Jedis jedis = getResouce()) {
            return jedis.get(key);
        }
    }

    public String get(String key, int index) {
        try (Jedis jedis = getResouce()) {
            jedis.select(index);
            return jedis.get(key);
        }
    }

    /**
     * 删除key
     *
     * @param key key
     */
    public void del(byte[] key) {
        try (Jedis jedis = getResouce()) {
            jedis.del(key);
        }
    }

    public void del(String key) {
        try (Jedis jedis = getResouce()) {
            jedis.del(key);
        }
    }

    public void del(String key, int index) {
        try (Jedis jedis = getResouce()) {
            jedis.select(index);
            jedis.del(key);
        }
    }

    /**
     * 获取所有的可用的值
     *
     * @param shiro_session_prefix 前缀
     * @return set集合
     */
    public Set<byte[]> keys(String shiro_session_prefix) {
        try (Jedis jedis = getResouce()) {
            return jedis.keys((shiro_session_prefix + "*").getBytes());
        }
    }

    public Set<String> getKeys(String str_prefix) {
        try (Jedis jedis = getResouce()) {
            return jedis.keys((str_prefix + "*"));
        }
    }

    public int size() {
        try (Jedis jedis = getResouce()) {
            return Math.toIntExact(jedis.dbSize());
        }
    }

    /*##############################################我是分割线###########################################################*/

    /**
     * hash 类型
     *
     * @param key   key
     * @param field field
     * @param value value
     * @return result
     */
    public Long heset(String key, String field, String value) {
        try (Jedis jedis = getResouce()) {
            return jedis.hset(key, field, value);
        }
    }

    public Long heset(String key, String field, String value, int index) {
        try (Jedis jedis = getResouce()) {
            jedis.select(index);
            return jedis.hset(key, field, value);
        }
    }

    // 获取数据
    public String hget(String key, String field) {
        try (Jedis jedis = getResouce()) {
            return jedis.hget(key, field);
        }
    }

    public String hget(String key, String field, int index) {
        try (Jedis jedis = getResouce()) {
            jedis.select(index);
            return jedis.hget(key, field);
        }
    }

    /**
     * Redis Hmget 命令用于返回哈希表中，一个或多个给定字段的值
     * 如果字段不存在于哈希表，那么返回一个 nil 值
     *
     * @param key    key
     * @param fields fields
     * @return List<String>
     */
    public List<String> hmget(String key, String... fields) {
        try (Jedis jedis = getResouce()) {
            return jedis.hmget(key, fields);
        }
    }

    public List<String> hmget(String key, int index, String... fields) {
        try (Jedis jedis = getResouce()) {
            jedis.select(index);
            return jedis.hmget(key, fields);
        }
    }

    public Long incr(String key) {
        try (Jedis jedis = getResouce()) {
            return jedis.incr(key);
        }
    }

    public Long incr(String key, int index) {
        try (Jedis jedis = getResouce()) {
            jedis.select(index);
            return jedis.incr(key);
        }
    }

    public Long decr(String key) {
        try (Jedis jedis = getResouce()) {
            return jedis.decr(key);
        }
    }

    public Long decr(String key, int index) {
        try (Jedis jedis = getResouce()) {
            jedis.select(index);
            return jedis.decr(key);
        }
    }

    public Long ttl(String key) {
        try (Jedis jedis = getResouce()) {
            return jedis.ttl(key);
        }
    }

    public Long hdel(String key, String... fields) {
        try (Jedis jedis = getResouce()) {
            return jedis.hdel(key, fields);
        }
    }

    public Long rpush(String key, String... strings) {
        try (Jedis jedis = getResouce()) {
            return jedis.rpush(key, strings);
        }
    }

    /**
     * Redis Lrange 返回列表中指定区间内的元素，区间以偏移量 START 和 END 指定。
     * 其中 0 表示列表的第一个元素， 1 表示列表的第二个元素，以此类推。
     * 你也可以使用负数下标，以 -1 表示列表的最后一个元素， -2 表示列表的倒数第二个元素，以此类推。
     *
     * @param key   key
     * @param start start
     * @param end   end
     * @return list
     */
    public List<String> lrange(String key, int start, int end) {
        try (Jedis jedis = getResouce()) {
            return jedis.lrange(key, start, end);
        }
    }

    public List<String> lrange(String key, int start, int end, int index) {
        try (Jedis jedis = getResouce()) {
            jedis.select(index);
            return jedis.lrange(key, start, end);
        }
    }

    /**
     * 从列表头部开始移除connt个匹配的值，如果count为零，所有匹配的元素都被删除
     * 如果count是负数，内容从尾部开始删除
     *
     * @param key   key
     * @param count count
     * @param value value
     * @return result
     */
    public Long lrem(String key, long count, String value) {
        try (Jedis jedis = getResouce()) {
            return jedis.lrem(key, count, value);
        }
    }

    public Long lrem(String key, long count, String value, int index) {
        try (Jedis jedis = getResouce()) {
            jedis.select(index);
            return jedis.lrem(key, count, value);
        }
    }

    /**
     * Redis Zadd 命令用于将一个或多个成员元素及其分数值加入到有序集当中。
     * 如果某个成员已经是有序集的成员，那么更新这个成员的分数值，并通过重新插入这个成员元素，来保证该成员在正确的位置上。
     * 分数值可以是整数值或双精度浮点数。
     * 如果有序集合 key 不存在，则创建一个空的有序集并执行 ZADD 操作。
     * 当 key 存在但不是有序集类型时，返回一个错误。
     *
     * @param key    key
     * @param score  score
     * @param member member
     * @return 被成功添加的新成员的数量，不包括那些被更新的、已经存在的成员。
     */
    public Long zadd(String key, double score, String member) {
        try (Jedis jedis = getResouce()) {
            return jedis.zadd(key, score, member);
        }
    }

    public Long zadd(String key, double score, String member, int index) {
        try (Jedis jedis = getResouce()) {
            jedis.select(index);
            return jedis.zadd(key, score, member);
        }
    }

    /**
     * Redis Zrevrangebyscore 返回有序集中指定分数区间内的所有的成员。有序集成员按分数值递减(从大到小)的次序排列。
     * 具有相同分数值的成员按字典序的逆序(reverse lexicographical order )排列。
     * 除了成员按分数值递减的次序排列这一点外， ZREVRANGEBYSCORE 命令的其他方面和 ZRANGEBYSCORE 命令一样。
     *
     * @param key    key
     * @param max    max
     * @param min    min
     * @param offset offset
     * @param count  count
     * @return 指定区间内，带有分数值(可选)的有序集成员的列表。
     */
    public Set<String> zrevrangeByScore(String key, String max, String min, int offset, int count) {
        try (Jedis jedis = getResouce()) {
            return jedis.zrevrangeByScore(key, max, min, offset, count);
        }
    }

    public Set<String> zrevrangeByScore(String key, String max, String min, int offset, int count, int index) {
        try (Jedis jedis = getResouce()) {
            jedis.select(index);
            return jedis.zrevrangeByScore(key, max, min, offset, count);
        }
    }
}
