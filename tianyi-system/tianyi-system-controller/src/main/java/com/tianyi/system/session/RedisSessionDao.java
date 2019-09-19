package com.tianyi.system.session;

import com.tianyi.system.util.JedisUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.SerializationUtils;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : LiYong
 * @program : RedisSessionDao
 * @description : 自定义sessionDao
 * @date : 2019/9/11 21:32
 */
public class RedisSessionDao extends AbstractSessionDAO {

    @Autowired
    private JedisUtil jedisUtil;

    // 给key加上一个前缀
    private final String SHIRO_SESSION_PREFIX = "sys-session";

    // 获取key的字节数组
    private byte[] getKey(String key) {
        return (SHIRO_SESSION_PREFIX + key).getBytes();
    }


    private void saveSession(Session session) {
        if (session != null && session.getId() != null) {
            // 获取key和value
            byte[] key = getKey(session.getId().toString());
            byte[] value = SerializationUtils.serialize(session);  // 序列化session对象
            // 存到缓存中
            jedisUtil.set(key, value);
            jedisUtil.expire(key, 600);  // 超时时间、秒
        }
    }

    @Override
    protected Serializable doCreate(Session session) {
        // 获取sessionId
        Serializable sessionId = generateSessionId(session);
        // 捆绑sessionId 和 session
        assignSessionId(session,sessionId);
        saveSession(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        if (sessionId == null) {
            return null;
        }
        // 获取key
        byte[] key = getKey(sessionId.toString());
        byte[] value = jedisUtil.get(key);  // 通过key获取value
        return (Session) SerializationUtils.deserialize(value);  // 反序列化为对象
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        saveSession(session);
    }

    @Override
    public void delete(Session session) {
        if (session == null || session.getId() == null) {
            return;
        }
        byte[] key = getKey(session.getId().toString());
        jedisUtil.del(key);
    }

    /**
     * 获取存活的session
     *
     * @return session集合
     */
    @Override
    public Collection<Session> getActiveSessions() {
        // 根据前缀获取所有的key
        Set<byte[]> keys = jedisUtil.keys(SHIRO_SESSION_PREFIX);
        Set<Session> sessions = new HashSet<>();
        if (CollectionUtils.isEmpty(keys)) {
            return sessions;
        }
        for (byte[] key : keys) {
            Session session = (Session) SerializationUtils.deserialize(jedisUtil.get(key));
            sessions.add(session);
        }
        return sessions;
    }
}
