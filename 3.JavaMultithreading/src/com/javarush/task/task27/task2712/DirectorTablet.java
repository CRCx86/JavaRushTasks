package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by a.zinov on 18.04.2017.
 */
public class DirectorTablet {

    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public void printAdvertisementProfit() {

        Map<Date, Double> advresults = StatisticManager.getInstance().getTotalAdvertismentAmount();
        double sum = 0;
        for (Map.Entry<Date, Double> dt : advresults.entrySet()) {
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f", simpleDateFormat.format(dt.getKey()), dt.getValue()));
            sum += (Double) dt.getValue();
        }
        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", sum));

    }

    public void printCookWorkloading() {



    }

    public void printActiveVideoSet() {

    }

    public void printArchivedVideoSet() {

    }

}
