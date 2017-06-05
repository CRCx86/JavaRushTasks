package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {


        // РЕШАТЬ ЗАДАЧУ С Collections нельзя!




//        ArrayList<String> list = new ArrayList<String>();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        for (int i=0; i<10; i++)
//        {
//            list.add(reader.readLine());
//        }

//        Scanner scanner = new Scanner(System.in);
//        for (int i = 0; i < 10; i++) {
//            String s = scanner.nextLine();
//            list.add(s);
//        }

//        ArrayList<String> list1 = new ArrayList<>();
//        list1.addAll(list);
//
//        Collections.sort(list1, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length() - o2.length();
//            }
//        });
//
//        String lot = list1.get(0);
//        String long1 = list1.get(list1.size() - 1);
//
//        for (String s : list1) {
//            if (s.length() == lot.length()){
//                lot = s;
//                break;
//            }
//        }
//
//        for (String s : list1) {
//            if (s.length() == long1.length()) {
//                long1 = s;
//                break;
//            }
//        }
//
//        for (String s : list) {
//            if (s.equals(lot)){
//                System.out.println(s);
//                break;
//            }
//            if (s.equals(long1)) {
//                System.out.println(s);
//                break;
//            }
//        }

        ArrayList<String> list = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<10; i++)
        {
            String s = reader.readLine();
            list.add(s);
        }
        String adl = list.get(0);
        int jdl=0;
        for (int i=1; i<list.size(); i++) {
            if (adl.length() < list.get(i).length()) {
                adl = list.get(i);
                jdl = i;
            }
        }
        String acor = list.get(0);
        int jcor=0;
        for (int i=1; i<list.size(); i++) {
            if (acor.length() > list.get(i).length()) {
                acor = list.get(i);
                jcor = i;
            }
        }
        if (jdl<jcor) System.out.println(list.get(jdl));
        else
        {
            if (jdl>jcor)
                System.out.println(list.get(jcor));
        }
    }
}
