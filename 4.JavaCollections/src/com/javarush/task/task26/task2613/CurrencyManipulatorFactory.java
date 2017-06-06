package com.javarush.task.task26.task2613;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Aleksandr on 06.06.2017.
 */
public class CurrencyManipulatorFactory {

    private static Map<String, CurrencyManipulator> map = new HashMap<>();

    private static CurrencyManipulatorFactory ourInstance = new CurrencyManipulatorFactory();

    public static CurrencyManipulatorFactory getInstance() {
        return ourInstance;
    }

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if (map.containsKey(currencyCode)) {
            return map.get(currencyCode);
        }else {
            CurrencyManipulator currencyManipulator = new CurrencyManipulator(currencyCode);
            map.put(currencyCode, currencyManipulator);
            return currencyManipulator;
        }
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return map.values();
    }
}
