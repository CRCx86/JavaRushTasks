package com.javarush.task.task32.task3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

/**
 * Created by a.zinov on 10.04.2017.
 */
public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {

        String endString = f.getName().toUpperCase();

        if (endString.endsWith(".HTML") || endString.endsWith(".HTM") || f.isDirectory())
            return true;
        else
            return false;
    }

    @Override
    public String getDescription() {
        return "HTML и HTM файлы";
    }
}
