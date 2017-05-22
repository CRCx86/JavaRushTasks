package com.javarush.task.task36.task3604;

/* 
Разбираемся в красно-черном дереве
*/
public class Solution {
    public static void main(String[] args) {

        RedBlackTree redBlackTree = new RedBlackTree();

        int[] ints = new int[]{1, 3, 2, 10, 17, 0, 109, 6};

        for (int i = 0; i < ints.length; i++) {
            redBlackTree.insert(ints[i]);
        }

    }
}
