package com.javarush.task.task30.task3008;

/**
 * Created by Aleksandr on 23.03.2017.
 * MessageType – enum, который отвечает за тип сообщений пересылаемых между
 клиентом и сервером
 */
public enum MessageType {

    NAME_REQUEST, // NAME_REQUEST – запрос имени
    USER_NAME, // USER_NAME – имя пользователя
    NAME_ACCEPTED, // NAME_ACCEPTED – имя принято
    TEXT, // TEXT – текстовое сообщение
    USER_ADDED, // USER_ADDED – пользователь добавлен
    USER_REMOVED // USER_REMOVED – пользователь удален

}
