package com.javarush.task.task06.task0605;


import java.io.*;

/* 
Контролируем массу тела
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        double weight = Double.parseDouble(bis.readLine());
        double height = Double.parseDouble(bis.readLine());

        Body.massIndex(weight, height);
    }

    public static class Body {
        public static void massIndex(double weight, double height) {
            //напишите тут ваш код
            double IMT = weight / (height * height);

            if (IMT < 18.5) {
                System.out.println("Недовес: меньше чем 18.5");
            }else if (IMT >= 18.5 && IMT <= 24.9) {
                System.out.println("Нормальный: между 18.5 и 24.9");
            }else if (IMT >= 25 && IMT <=29.9) {
                System.out.println("Избыточный вес: между 25 и 29.9");
            }else if (IMT >= 30) {
                System.out.println("Ожирение: 30 или больше");
            }
        }
    }
}
