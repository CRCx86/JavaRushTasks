package com.javarush.task.task28.task2805;

/**
 * Created by a.zinov on 20.03.2017.
 */
public class MyThread extends Thread {

    static int priority = 0;
    int currentPriority = 0;
    ThreadGroup threadGroup;

    public MyThread() {
        getPriorityThread();
        setPriority(currentPriority);

    }

    public MyThread(Runnable target) {
        super(target);
        getPriorityThread();
        setPriority(currentPriority);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        threadGroup = group;
        getPriorityThread();
        setPriority(currentPriority);
    }

    public MyThread(String name) {
        super(name);
        getPriorityThread();
        setPriority(currentPriority);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        threadGroup = group;
        getPriorityThread();
        setPriority(currentPriority);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        getPriorityThread();
        setPriority(currentPriority);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        threadGroup = group;
        getPriorityThread();
        setPriority(currentPriority);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        threadGroup = group;
        getPriorityThread();
        setPriority(currentPriority);
    }

    public void getPriorityThread() {

        if (priority >= Thread.MAX_PRIORITY) {
            priority = 0;
            currentPriority = priority;
        }
        if (threadGroup != null) {
            if (priority > threadGroup.getMaxPriority() && currentPriority < Thread.MAX_PRIORITY) {
                currentPriority = threadGroup.getMaxPriority();
            }
        }
        priority++;
        currentPriority = priority;

    }
}
