package com.javarush.task.task30.task3008;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Created by Aleksandr on 23.03.2017.
 *
 *
 * Connection – класс соединения между клиентом и сервером
 *
 *
 */
public class Connection implements Closeable {

    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        this.out = new ObjectOutputStream(socket.getOutputStream());
        this.in = new ObjectInputStream(socket.getInputStream());
    }

    /* должен записывать(сериализовать) сообщение message в ObjectOutputStream. Этот метод будет
    * вызываться из нескольких потоков.
    * запись в объект
    * ObjectOutputStream возможна только одним потоком в определенный момент
    * времени, остальные желающие ждут завершения записи. При этом другие методы
    * класса Connection не должны быть заблокированы.
    */
    public void send(Message message) throws IOException {

        synchronized (out) {
            out.writeObject(message);
            out.flush();
        }
    }

    /*
    * Метод Message receive() throws IOException, ClassNotFoundException. Он должен читать
    * (десериализовать) данные из ObjectInputStream. Операция чтения
    * не может быть одновременно вызвана несколькими потоками, при этом вызов других
    * методов класса Connection не блокировать.
    */
    public Message receive() throws IOException, ClassNotFoundException {

        synchronized (in) {
            return (Message) in.readObject();
        }

    }

    /*
    * Метод SocketAddress getRemoteSocketAddress(), возвращающий удаленный адрес
    * сокетного соединения.
    */

    public SocketAddress getRemoteSocketAddress(){

        return socket.getRemoteSocketAddress();

    }

//    Метод void close() throws IOException, закрывает все ресурсы класса.

    @Override
    public void close() throws IOException {
        socket.close();
        out.close();
        in.close();
    }
}
