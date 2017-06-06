package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.CurrencyManipulator;
import com.javarush.task.task26.task2613.CurrencyManipulatorFactory;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.Comparator;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

/**
 * Created by Aleksandr on 06.06.2017.
 */
class WithdrawCommand implements Command {

    private ResourceBundle res = ResourceBundle
            .getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");

    @Override
    public void execute() throws InterruptOperationException {

        ConsoleHelper.writeMessage(res.getString("before"));

        String currencyCode = ConsoleHelper.askCurrencyCode();

        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory
                .getManipulatorByCurrencyCode(currencyCode);

        while (true) {

            ConsoleHelper.writeMessage(res.getString("specify.amount"));
            Integer amount = 0;
            try {
                amount = Integer.parseInt(ConsoleHelper.readString());

                if (amount > 0) {

                    if (currencyManipulator.isAmountAvailable(amount)){

                        Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());

                        try {

                            map = currencyManipulator.withdrawAmount(amount);

                            int key = 0;
                            int value = 0;
                            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                                ConsoleHelper.writeMessage("\t" + entry.getKey() + " - " + entry.getValue());
                                key += entry.getKey();
                                value += entry.getValue();
                            }



                            break;
                        }catch (NotEnoughMoneyException e) {
                            ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
                        }

                    }else {
                        ConsoleHelper.writeMessage(res.getString("not.enough.money"));
                    }
                }else {
                    ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
                }
            }catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(String.format(res.getString("success.format"), amount, currencyCode));
            }

        }
    }
}
