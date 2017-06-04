package com.javarush.task.task28.task2810.model;

import com.javarush.task.task28.task2810.view.View;
import com.javarush.task.task28.task2810.vo.Vacancy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksandr on 03.06.2017.
 */
public class Model {

    private View view;
    private Provider[] providers;

    public Model(View view, Provider[] providers) {
        this.view = view;
        this.providers = providers;

        if (view == null || providers == null || providers.length == 0) {
            throw new IllegalArgumentException();
        }
    }

    public void selectCity(String city) throws IOException {

        List<Vacancy> vacancies = new ArrayList<>();

        for (Provider provider : providers) {

            for (Vacancy vacancy : provider.getJavaVacancies(city)) {
                vacancies.add(vacancy);
            }
            
        }

        view.update(vacancies);
    }
}
