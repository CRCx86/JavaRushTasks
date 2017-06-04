package com.javarush.task.task28.task2810;

import com.javarush.task.task28.task2810.model.*;
import com.javarush.task.task28.task2810.view.HtmlView;
import com.javarush.task.task28.task2810.view.View;

import java.io.IOException;

/**
 * Created by Aleksandr on 30.05.2017.
 */
public class Aggregator {

    public static void main(String[] args) throws IOException {

        HtmlView view = new HtmlView();
        Provider[] provider = new Provider[]{new Provider(new HHStrategy()), new Provider(new MoikrugStrategy())};
        Model model = new Model(view, provider);
        Controller controller = new Controller(model);
        view.setController(controller);

        view.userCitySelectEmulationMethod();
        
    }

}
