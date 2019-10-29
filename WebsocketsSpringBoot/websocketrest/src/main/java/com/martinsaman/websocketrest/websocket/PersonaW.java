package com.martinsaman.websocketrest.websocket;

import java.util.concurrent.ConcurrentHashMap;

import com.martinsaman.websocketrest.clients.PersonaCl;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class PersonaW extends TextWebSocketHandler {

    ConcurrentHashMap<String, WebSocketSession> sesiones = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession sesion) throws Exception {
        sesiones.put(sesion.getId(), sesion);
        System.out.println("Sesion agregada: " + sesion.getId());
    }

    @Override
    public void handleTextMessage(WebSocketSession sesion, TextMessage message) throws Exception {
        String payload = message.getPayload(); // convertir

        if (!payload.isEmpty()) {
            broadcast();
        }

    }

    @Override
    public void afterConnectionClosed(WebSocketSession sesion, CloseStatus status) {
        sesiones.remove(sesion.getId());
    }

    public void broadcast() throws Exception {

        TextMessage textMessage = new TextMessage(PersonaCl.getAllPersona());
        for (ConcurrentHashMap.Entry<String, WebSocketSession> s : sesiones.entrySet()) {
            s.getValue().sendMessage(textMessage);
        }
    }

}