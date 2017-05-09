package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by a.zinov on 13.04.2017.
 */
public class AdvertisementStorage {

    private static AdvertisementStorage ourInstance = new AdvertisementStorage();

    private final List<Advertisement> videos = new ArrayList();

    public static AdvertisementStorage getInstance() {
        return ourInstance;
    }

    private AdvertisementStorage() {

        Object someContent = new Object();
        add(new Advertisement(someContent, "First Video",  5000, 100, 3 * 60)); // 3 min
        add(new Advertisement(someContent, "Second Video", 100, 10, 2 * 60)); //15 min
        add(new Advertisement(someContent, "Third Video", 400, 2, 1 * 60)); //10 min
        add(new Advertisement(someContent, "Fourth Video", 500, 1, 1 * 60)); //10 min
        add(new Advertisement(someContent, "Fifth Video", 500, 1, 1 * 60)); //10 min
        add(new Advertisement(someContent, "Sixth Video", 10, 5, 1 * 60)); //10 min
        add(new Advertisement(someContent, "Seventh Video", 1500, 3, 1 * 60)); //10 min
        add(new Advertisement(someContent, "Eighth Video", 10000, 10, 1 * 60)); //10 min

    }

    public List<Advertisement> list() {
        return videos;
    }

    public void add(Advertisement advertisement) {
        videos.add(advertisement);
    }

}
