package com.tiiaan.tbm.metaj.websocket;

import org.springframework.stereotype.Component;

import javax.websocket.Session;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

@Component
public class SessionCache {

    private final Map<String, Session> sessionMap = new ConcurrentHashMap<>();

    public void set(String id, Session session) {
        sessionMap.put(id, session);
    }

    public void remove(String id) {
        sessionMap.remove(id);
    }

    public Session get(String id) {
        return sessionMap.get(id);
    }

}
