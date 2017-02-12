package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код

        int a,b,c;
        Scanner scan= new Scanner(System.in);
        a=scan.nextInt();
        b=scan.nextInt();
        c=scan.nextInt();

        if(a==b && b ==c){
            return;
        }
        else if(a==b && b!=c){
            System.out.println(3);
        }
        else if(a!=b && b ==c ){
            System.out.println(1);
        }
        else if(a!=b && a==c)System.out.println(2);
    }
}
