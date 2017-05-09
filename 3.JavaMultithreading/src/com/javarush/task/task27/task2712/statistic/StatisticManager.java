package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.ad.Advertisement;
import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Dish;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

/**
 * Created by a.zinov on 17.04.2017.
 */
public class StatisticManager {

    private static StatisticManager ourInstance = new StatisticManager();

    private StatisticStorage statisticStorage = new StatisticStorage();

    private Set<Cook> cooks = new HashSet<>();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }

    private class StatisticStorage {

        Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        public StatisticStorage() {
            for (EventType type : EventType.values()) {
                storage.put(type, new ArrayList<EventDataRow>());
            }

            List<EventDataRow> list = new ArrayList<>();
            list.add(new VideoSelectedEventDataRow(new ArrayList<Advertisement>(), 501, 104));
            list.add(new VideoSelectedEventDataRow(new ArrayList<Advertisement>(), 801, 1027));
            list.add(new VideoSelectedEventDataRow(new ArrayList<Advertisement>(), 10, 15));
            list.add(new VideoSelectedEventDataRow(new ArrayList<Advertisement>(), 5600, 1034));
            list.add(new VideoSelectedEventDataRow(new ArrayList<Advertisement>(), 860, 101));
            int n = 9;
            for (int i = 0; i < list.size(); i++){
                if(i%2==0)
                    ++n;
                VideoSelectedEventDataRow vs = (VideoSelectedEventDataRow)list.get(i);
                vs.setCurrentDate(new Date(
                        new Date().getYear(),
                        new Date().getMonth(),
                        n));
            }
            for (EventDataRow eventDataRow : list)
                put(eventDataRow);

            //Для статистики по работе повара
            list.clear();
            list.add(new CookedOrderEventDataRow("Tablet", "Ivanov", 1160, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Petrov", 985, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Sidorov", 820, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Ershov", 253, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Ivanov", 360, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Ivanov", 1160, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Petrov", 985, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Sidorov", 820, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Ershov", 253, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Ivanov", 360, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Ivanov", 1160, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Petrov", 985, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Sidorov", 820, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Ershov", 253, new ArrayList<Dish>()));
            list.add(new CookedOrderEventDataRow("Tablet", "Ivanov", 360, new ArrayList<Dish>()));
            n = 9;
            for (int i = 0; i < list.size(); i++){
                if(i%5==0)
                    ++n;
                CookedOrderEventDataRow co = (CookedOrderEventDataRow) list.get(i);
                co.setCurrentDate(new Date(
                        new Date().getYear(),
                        new Date().getMonth(),
                        n));
            }
            for (EventDataRow event : list)
                put(event);
            //Конец тестовых данных
        }

        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

        public List<EventDataRow> getStorage(EventType eventType) {
            return storage.get(eventType);
        }
    }

    public void register(Cook cook) {
        cooks.add(cook);
    }

    public Map<Date, Double> getTotalAdvertismentAmount() {

        List<EventDataRow> list = statisticStorage.getStorage(EventType.SELECTED_VIDEOS);
        Map<Date, Double> results = new TreeMap<Date, Double>(Collections.reverseOrder());
        for (EventDataRow vsedr : list){
            VideoSelectedEventDataRow video = (VideoSelectedEventDataRow) vsedr;
            Date key = dateWithoutTime(video.getDate());
            if (results.containsKey(key)) results.put(key, (Double) results.get(key) + 0.01d * video.getAmount());
            else results.put(key, video.getAmount() * 0.01d);
        }
        return results;
    }



    private Date dateWithoutTime(Date date) {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}
