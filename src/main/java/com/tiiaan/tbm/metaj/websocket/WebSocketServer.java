package com.tiiaan.tbm.metaj.websocket;

import com.tiiaan.tbm.metaj.holder.UserHolder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

import java.util.concurrent.Future;

/**
 * @author tiiaan Email:tiiaan.w@gmail.com
 * @version 0.0
 * description
 */

@Slf4j
@Controller
@ServerEndpoint(value = "/websocket")
public class WebSocketServer {

    @Resource
    private SessionCache sessionCache;


    @OnOpen
    public void onOpen(Session session) {
        //Long id = UserHolder.getUser().getId();
        String id = session.getId();
        sessionCache.set(id, session);
        log.info("[{}] open websocket", id);
    }


    @OnClose
    public void onCLose(Session session) {
        String id = session.getId();
        sessionCache.remove(id);
        log.info("[{}] close websocket", id);
    }


    @OnMessage
    public void onMessage(Session session, String message) {
        log.info("receive form [{}] [{}]", session.getId(), message);
    }


    public void send(String id, String message) {
        Session session = sessionCache.get(id);
        //RemoteEndpoint.Async asyncRemote = session.getAsyncRemote();
        //Future<Void> future = asyncRemote.sendText(message);
        RemoteEndpoint.Basic basicRemote = session.getBasicRemote();
        try {
            basicRemote.sendText(message);
        } catch (IOException e) {
            log.error("websocket send msg error", e);
        }
    }


    @OnError
    public void onError(Session session, Throwable throwable) {
        try {
            session.close();
        } catch (IOException e) {
            log.error("websocket close session error", e);
        }
        log.error("websocket error", throwable);
    }

}
