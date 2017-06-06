package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Aleksandr on 06.06.2017.
 */
class DepositCommand implements Command {

    private ResourceBundle res = ResourceBundle
            .getBundle(CashMachine.RESOURCE_PATH + "deposit_en");

    @Override
    public void execute() throws InterruptOperationException {

        ConsoleHelper.writeMessage(res.getString("before"));

        String currencyCode = ConsoleHelper.askCurrencyCode();
        String[] strings = ConsoleHelper.getValidTwoDigits(currencyCode);

        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory
                .getManipulatorByCurrencyCode(currencyCode);

        try {
            currencyManipulator.addAmount(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]));
            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), Integer.parseInt(strings[0]), strings[1]));
        }catch (NumberFormatException e) {
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }

    }
}
