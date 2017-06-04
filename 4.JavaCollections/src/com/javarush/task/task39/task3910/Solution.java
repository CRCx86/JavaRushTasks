package com.javarush.task.task39.task3910;

/* 
isPowerOfThree
*/
public class Solution {
    public static void main(String[] args) {

        isPowerOfThree(28);

    }

    public static boolean isPowerOfThree(int n) {

        if (n == 0)
            return false;

            while (n % 3 == 0) {
                n /= 3;
            }

            if (n == 1) {
                return true;
            }else {
                return false;
            }


//        if ((Math.log(n) / Math.log(3)) % 3 == 0) {
//            return true;
//        }
//        return false;

//        while (n > 0) {
//            n -= 3;
//        }
//
//        return n == 0 ? true : false;
    }
}
