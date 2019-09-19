package com.tianyi.system.session;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.session.mgt.WebSessionKey;

import javax.servlet.ServletRequest;
import java.io.Serializable;

/**
 * @author : LiYong
 * @program : CustomeSessionManager
 * @description : 自定义sessionManager
 * @date : 2019/9/12 10:44
 */
public class CustomeSessionManager extends DefaultWebSessionManager {

    @Override
    protected Session retrieveSession(SessionKey sessionKey) throws UnknownSessionException {
        // sessionKey 里面存储着 request 对象
        Serializable sessionId = getSessionId(sessionKey);
        ServletRequest request = null;
        // 获取request
        if (sessionKey instanceof WebSessionKey) {
            request = ((WebSessionKey) sessionKey).getServletRequest();
        }
        // 如果request存在，就从request中获取session
        if (request != null && sessionId != null) {
            Session session = (Session) request.getAttribute(sessionId.toString());
            if (session != null) {
                return session;
            }
        }
        // 如果不存在就去获得session
        Session session = super.retrieveSession(sessionKey);
        if (request != null && sessionId != null) {
            request.setAttribute(sessionId.toString(), session);
        }
        return session;
    }
}
