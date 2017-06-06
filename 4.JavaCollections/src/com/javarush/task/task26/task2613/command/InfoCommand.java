package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;

import java.io.IOException;
import java.util.ResourceBundle;

/**
 * Created by Aleksandr on 06.06.2017.
 */
class InfoCommand implements Command {

    private ResourceBundle res = ResourceBundle
            .getBundle(CashMachine.RESOURCE_PATH + "info_en");

    @Override
    public void execute() {

        ConsoleHelper.writeMessage(res.getString("before"));

        boolean hasMoney = false;

        for (CurrencyManipulator manipulator : CurrencyManipulatorFactory.getAllCurrencyManipulators()) {

            if (manipulator.hasMoney()) {
                ConsoleHelper.writeMessage(manipulator.getCurrencyCode() + " - " + manipulator.getTotalAmount());
                hasMoney = true;
            }
        }

        if (!hasMoney){
            ConsoleHelper.writeMessage(res.getString("no.money"));
        }

    }
}
