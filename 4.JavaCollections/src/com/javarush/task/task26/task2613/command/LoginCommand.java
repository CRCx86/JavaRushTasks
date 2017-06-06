package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.CashMachine;
import com.javarush.task.task26.task2613.ConsoleHelper;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.ResourceBundle;

/**
 * Created by Aleksandr on 06.06.2017.
 */
public class LoginCommand implements Command {

    private ResourceBundle validCreditCards = ResourceBundle
            .getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
    private ResourceBundle res = ResourceBundle
            .getBundle(CashMachine.RESOURCE_PATH + "login_en");

    @Override
    public void execute() throws InterruptOperationException {

        ConsoleHelper.writeMessage(res.getString("before"));
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String cardsNumber = ConsoleHelper.readString();
            String pinCode = ConsoleHelper.readString();

            if (cardsNumber.length() == 12 && pinCode.length() == 4) {
                if (validCreditCards.containsKey(cardsNumber)) {
                    if (validCreditCards.getString(cardsNumber).equals(pinCode)) {
                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardsNumber));
                        break;
                    }else {
                        ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardsNumber));
                        ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                        continue;
                    }
                }else {
                    ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardsNumber));
                    ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                    continue;
                }
            }else {
                ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardsNumber));
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                continue;
            }

        }

    }



}
