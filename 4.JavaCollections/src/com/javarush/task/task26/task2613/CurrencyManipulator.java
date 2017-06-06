package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.*;

/**
 * Created by Aleksandr on 06.06.2017.
 */
public class CurrencyManipulator {

    private String currencyCode;
    private Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
        denominations = new HashMap<>();
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        }else {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount() {

        int sum = 0;

        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
            sum += entry.getKey() * entry.getValue();
        }

        return sum;
    }

    public boolean hasMoney() {
        return getTotalAmount() == 0 ? false : true;
    }

    public boolean isAmountAvailable(int expectedAmount) {
        if (expectedAmount <= getTotalAmount())
            return true;
        else {
            return false;
        }
    }

    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {

        Map<Integer, Integer> treeMap = new TreeMap<>(Comparator.reverseOrder());

        SortedMap<Integer, Integer> sortedMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        sortedMap.putAll(denominations);

        for (Iterator<Map.Entry<Integer, Integer>> iterator = sortedMap.entrySet().iterator();
             iterator.hasNext();){

            Map.Entry<Integer, Integer> entry = iterator.next();

            Integer amountDenomination = entry.getKey() * entry.getValue();

            int value = entry.getValue();

            for (int i = 0; i < value; i++) {

                expectedAmount -= entry.getKey();
                amountDenomination-= entry.getKey();

                if (treeMap.containsKey(entry.getKey())) {
                    treeMap.put(entry.getKey(),  treeMap.get(entry.getKey()) + 1);
                    sortedMap.put(entry.getKey(), sortedMap.get(entry.getKey()) - 1);
                }else {
                    treeMap.put(entry.getKey(), 1);
                    sortedMap.put(entry.getKey(), sortedMap.get(entry.getKey()) - 1);
                }

                if (expectedAmount < 0) {
                    expectedAmount += entry.getKey();
                    amountDenomination += entry.getKey();
                    treeMap.put(entry.getKey(), treeMap.get(entry.getKey()) - 1);
                    sortedMap.put(entry.getKey(), sortedMap.get(entry.getKey()) + 1);
                    break;
                }

                if (amountDenomination == 0)
                    iterator.remove();

                if (expectedAmount == 0)
                    break;

            }

        }

        for (Iterator<Map.Entry<Integer, Integer>> iterator = treeMap.entrySet().iterator(); iterator.hasNext();) {

            Map.Entry<Integer, Integer> entry = iterator.next();

            if (entry.getValue() == 0)
                iterator.remove();
        }

        if (expectedAmount == 0) {
            denominations.clear();
            denominations.putAll(sortedMap);
            return treeMap;
        }
        else
            throw new NotEnoughMoneyException();

    }
}
