package com.javarush.task.task39.task3905;

public class PhotoPaint {
    public boolean paintFill(Color[][] image, int r, int c, Color desiredColor) {

        int x = r;
        int y = c;

        if (x < 0) return false;
        if (y < 0) return false;
        if (y >= image.length) return false;
        if (x >= image[0].length) return false;

        if (image[y][x] == desiredColor) return false;

        Color currentColor = image[y][x];

        paintFill(image, y , x, desiredColor, currentColor);

        return true;
    }

    public void paintFill(Color[][] image, int y, int x, Color desiredColor, Color currentColor) {

        if (x < 0) return;
        if (y < 0) return;
        if (y >= image.length) return;
        if (x >= image[0].length) return;

        if (image[y][x] != currentColor){
            return;
        }else {
            image[y][x] = desiredColor;
        }

        paintFill(image, y - 1, x, desiredColor, currentColor);
        paintFill(image, y + 1, x, desiredColor, currentColor);
        paintFill(image, y, x - 1, desiredColor, currentColor);
        paintFill(image, y, x + 1, desiredColor, currentColor);

    }
}
