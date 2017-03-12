package com.javarush.task.task36.task3608.model;

/**
 * Created by Aleksandr on 12.03.2017.
 */
public interface Model {

    public ModelData getModelData();

    public void loadUsers();

    public void loadDeletedUsers();

    public void loadUserById(long userId);

    public void deleteUserById(long l);

    void changeUserData(String name, long id, int level);
}
