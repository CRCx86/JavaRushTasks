package com.javarush.task.task30.task3004;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by Aleksandr on 01.04.2017.
 */
public class BinaryRepresentationTask extends RecursiveTask<String> {

    private int x;

    public BinaryRepresentationTask(int i) {
        this.x = i;
    }

    @Override
    protected String compute() {

        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            BinaryRepresentationTask binaryRepresentationTask = new BinaryRepresentationTask(a);
            binaryRepresentationTask.fork();

            return new BinaryRepresentationTask(b).compute() + binaryRepresentationTask.join();
        }
        return result;

    }
}
