package com.javarush.task.task32.task3208;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
RMI-2
*/
public class Solution {
    public static Registry registry;

    //pretend we start rmi client as CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.say();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    //pretend we start rmi server as SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {

        Remote stub = null;

        @Override
        public void run() {
            //напишите тут ваш код

            try {
                registry = LocateRegistry.createRegistry(2099);

                final Cat cat = new Cat("Amigo1");
                final Dog dog = new Dog("Amigo2");

                stub = UnicastRemoteObject.exportObject(cat, 0);
                registry.bind("Amigo1", stub);

                stub = UnicastRemoteObject.exportObject(dog, 0);
                registry.bind("Amigo2", stub);

            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (AlreadyBoundException e) {
                e.printStackTrace();
            }
        }
    });

    public static void main(String[] args) throws InterruptedException {
        //start rmi server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        //start client
        CLIENT_THREAD.start();
    }
}