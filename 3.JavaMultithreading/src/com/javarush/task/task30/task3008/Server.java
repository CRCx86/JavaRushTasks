package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Aleksandr on 23.03.2017.
 */
public class Server
{
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();
    public static void main(String[] args) throws IOException {
        int port = ConsoleHelper.readInt();


        try(ServerSocket serverSocket = new ServerSocket(port))
        {
            ConsoleHelper.writeMessage("Сервер запущен.");
            for (int i = 0;;i++)
            {
                Handler handler = new Handler(serverSocket.accept());
                handler.start();
            }
        }
        catch (Exception e)
        {
            ConsoleHelper.writeMessage("Ошибка сокета.");
        }
    }

    public static void sendBroadcastMessage(Message message)
    {
        try
        {
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
                pair.getValue().send(message);
            }
        }
        catch (IOException e)
        {
            ConsoleHelper.writeMessage("Не могу отправить сообщение.");
        }
    }

    private static class Handler extends Thread
    {
        private Socket socket;

        public Handler(Socket socket)
        {
            this.socket = socket;
        }

        public void run()
        {
            ConsoleHelper.writeMessage("Established new connection with remote address " + socket.getRemoteSocketAddress());
            String clientName = null;

            try (Connection connection = new Connection(socket))
            {
                ConsoleHelper.writeMessage("Connection with port " + connection.getRemoteSocketAddress());

                clientName = serverHandshake(connection);

                sendBroadcastMessage(new Message(MessageType.USER_ADDED, clientName));

                sendListOfUsers(connection, clientName);

                serverMainLoop(connection, clientName);

            }
            catch (IOException | ClassNotFoundException e)
            {
                ConsoleHelper.writeMessage("An error occurred while communicating with the remote address");
            }
            finally
            {
                if (clientName != null) {
                    connectionMap.remove(clientName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clientName));
                    ConsoleHelper.writeMessage(String.format("Connection with remote address (%s) is closed.", socket.getRemoteSocketAddress()));
                }
            }


        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String name = null;
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message message = connection.receive();
                if (message.getType() == MessageType.USER_NAME) {
                    name = message.getData();

                    if (!name.isEmpty() && !connectionMap.containsKey(name)) {
                        connectionMap.put(name, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return name;
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName)throws IOException
        {
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet())
            {
                String name = pair.getKey();
                if (!name.equals(userName))
                {
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true)
            {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT)
                {
                    String message1 = userName + ": " + message.getData();

                    Message message2 = new Message(MessageType.TEXT, message1);
                    sendBroadcastMessage(message2);
                }
                else
                {
                    ConsoleHelper.writeMessage("Error.");
                }
            }
        }

    }
}
