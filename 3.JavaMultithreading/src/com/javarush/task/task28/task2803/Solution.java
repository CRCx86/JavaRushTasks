package com.javarush.task.task28.task2803;

import java.util.concurrent.ThreadLocalRandom;

/* 
ThreadLocalRandom
*/
public class Solution {
    public static int getRandomIntegerBetweenNumbers(int from, int to) {

        int i = ThreadLocalRandom.current().nextInt(from, to);

        return i;
    }

    public static double getRandomDouble() {

        double d = ThreadLocalRandom.current().nextDouble();

        return d;
    }

    public static long getRandomLongBetween0AndN(long n) {

        long l = ThreadLocalRandom.current().nextLong(n);

        return l;
    }

    public static void main(String[] args) {
    }
}
