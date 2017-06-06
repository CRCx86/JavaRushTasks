package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.IOException;

/**
 * Created by Aleksandr on 06.06.2017.
 */
interface Command {

    void execute() throws InterruptOperationException;

}
