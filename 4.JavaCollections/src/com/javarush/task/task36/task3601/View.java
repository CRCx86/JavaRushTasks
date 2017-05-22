package com.javarush.task.task36.task3601;

import java.util.List;

/**
 * Created by a.zinov on 18.05.2017.
 */
public class View {

    public void fireEventShowData() {
        System.out.println(new Controller().onDataListShow());
    }


}
