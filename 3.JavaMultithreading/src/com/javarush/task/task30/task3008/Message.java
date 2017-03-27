package com.javarush.task.task30.task3008;

import java.io.Serializable;

/**
 * Created by Aleksandr on 23.03.2017.
 *
 * Message – класс, отвечающий за пересылаемые сообщения
 */
public class Message implements Serializable {

    private final MessageType type; // поле типа MessageType type, которое будет содержать тип сообщения
    private final String data; // Константное поле типа String data, которое будет содержать данные сообщения

    public Message(MessageType type) {
        this.type = type;
        this.data = null;
    }

    public Message(MessageType type, String data) {
        this.type = type;
        this.data = data;
    }

    public MessageType getType() {
        return type;
    }

    public String getData() {
        return data;
    }
}
