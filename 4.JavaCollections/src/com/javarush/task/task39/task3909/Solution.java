package com.javarush.task.task39.task3909;

/* 
Одно изменение
*/
public class Solution {
    public static void main(String[] args) {

    }

    public static boolean isOneEditAway(String first, String second) {

        if (first == null || second == null)
            return false;

        if (Math.abs(first.length() - second.length()) > 1)
            return false;

        if (first.equals("") && second.equals(""))
            return true;

        if (first.equals(second))
            return true;

        StringBuilder string1;
        StringBuilder string2;

        string1 = (first.length() >= second.length()) ? new StringBuilder(first) : new StringBuilder(second);
        string2 = (first.length() < second.length()) ? new StringBuilder(first) : new StringBuilder(second);

        for (int i = 0; i < string2.length(); i++) {
            int pos = string1.indexOf(String.valueOf(string2.charAt(i)));

            if (pos != -1)
                string1.deleteCharAt(pos);
        }

        if (string1.length() == 1)
            return true;


        return false;
    }
}
