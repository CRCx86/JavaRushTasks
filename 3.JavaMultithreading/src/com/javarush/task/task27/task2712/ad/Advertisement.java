package com.javarush.task.task27.task2712.ad;

/**
 * Created by a.zinov on 13.04.2017.
 */
public class Advertisement {

    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;

    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;                             // видео
        this.name = name;                                   // имя/название
        this.initialAmount = initialAmount;                 // начальная сумма, стоимость рекламы в копейках
        this.hits = hits;                                   // количество оплаченных показов
        this.duration = duration;                           // продолжительность в секундах

        this.amountPerOneDisplaying = initialAmount / hits; // стоимость одного показа рекламного объявления
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public int getHits() {
        return hits;
    }

    public long getInitialAmount() {
        return initialAmount;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void revalidate() throws UnsupportedOperationException {
        if (hits > 0) {
            hits--;
        }else {
            throw new NoVideoAvailableException();
        }
    }
}
