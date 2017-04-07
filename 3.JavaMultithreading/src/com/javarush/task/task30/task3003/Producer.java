package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

/**
 * Created by Aleksandr on 02.04.2017.
 */
public class Producer implements Runnable {

    private TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {

        this.queue = queue;
    }

    @Override
    public void run() {

            try {

                if (Thread.currentThread().isInterrupted())
                    return;

                for (int i = 1; i <= 9; i++) {
                    ShareItem shareItem = new ShareItem("ShareItem-" + i, i);
                    System.out.format("Элемент 'ShareItem-%d' добавлен%n", i);
                    queue.offer(shareItem);
                    Thread.sleep(100);
                    if (queue.hasWaitingConsumer()) {
                        System.out.format("Consumer в ожидании!\n");
                    }
                }
            } catch (InterruptedException e) {

            }
    }

}
