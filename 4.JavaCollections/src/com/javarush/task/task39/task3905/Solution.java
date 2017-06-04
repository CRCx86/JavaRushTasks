package com.javarush.task.task39.task3905;

/* 
Залей меня полностью
*/

public class Solution {
    public static void main(String[] args) {
        Color[][] picture = {
                {Color.BLUE, Color.GREEN, Color.BLUE, Color.BLUE},
                {Color.RED, Color.GREEN, Color.GREEN, Color.BLUE},
                {Color.YELLOW, Color.GREEN, Color.BLUE, Color.BLUE},
                {Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE},
        };
        System.out.print(new PhotoPaint().paintFill(picture, 2,1, Color.BLUE));
    }
}
