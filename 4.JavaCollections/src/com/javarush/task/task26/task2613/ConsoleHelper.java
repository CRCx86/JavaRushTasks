package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Aleksandr on 06.06.2017.
 */
public class ConsoleHelper {

    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle
            .getBundle(CashMachine.class.getPackage().getName() + ".resources." + "common_en");

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {

        String result = "";

        try {
            result =  bis.readLine();
            if (result.equalsIgnoreCase("EXIT")) {
                ConsoleHelper.writeMessage(res.getString("the.end"));
                throw new InterruptOperationException();
            }
        }catch (IOException e) {
        }

        return result;
    }

    public static String askCurrencyCode() throws InterruptOperationException {

        while (true) {
            writeMessage(res.getString("choose.currency.code"));
            String currency = readString();
            if (currency.length() == 3)
                return currency.toUpperCase();
            else {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {

        while (true) {
            try {
                writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));

                String[] string = readString().split( " ");
                Integer nominal = Integer.parseInt(string[0]);
                Integer quantity = Integer.parseInt(string[1]);

                if (string.length == 2 && nominal > 0 && quantity > 0) {
                    return string;
                }else {
                    ConsoleHelper.writeMessage(res.getString("invalid.data"));
                }
            }catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static Operation askOperation() throws InterruptOperationException {

        while (true) {

            String string = readString();
            if (checkWithRegExp(string)) {
                ConsoleHelper.writeMessage(res.getString("choose.operation"));
                Operation operation = Operation
                        .getAllowableOperationByOrdinal(Integer.parseInt(string));
                return operation;
            }

        }

    }

    public static boolean checkWithRegExp(String Name)
    {
        Pattern p = Pattern.compile("^[1-4]$");
        Matcher m = p.matcher(Name);
        return m.matches();
    }

    public static void printExitMessage() {
        ConsoleHelper.writeMessage("Bay!");
    }
}
