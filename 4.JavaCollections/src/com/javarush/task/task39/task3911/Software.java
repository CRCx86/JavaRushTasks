package com.javarush.task.task39.task3911;

import java.util.*;

public class Software {
    int currentVersion;

    private Map<Integer, String> versionHistoryMap = new LinkedHashMap<>();

    public void addNewVersion(int version, String description) {
        if (version > currentVersion) {
            versionHistoryMap.put(version, description);
            currentVersion = version;
        }
    }

    public int getCurrentVersion() {
        return currentVersion;
    }

    public Map<Integer, String> getVersionHistoryMap() {
        return Collections.unmodifiableMap(versionHistoryMap);
    }

    public boolean rollback(int rollbackVersion) {

        if (rollbackVersion < currentVersion){

            if (versionHistoryMap.containsKey(rollbackVersion)){

                boolean isDone = false;
                for (Iterator<Map.Entry<Integer, String>> iterator = versionHistoryMap.entrySet().iterator(); iterator.hasNext();) {
                    Map.Entry<Integer, String> entry = iterator.next();
                    if (entry.getKey().equals(rollbackVersion)) {
                        currentVersion = rollbackVersion;
                        isDone = true;
                    }

                    if (entry.getKey() > rollbackVersion) {
                        iterator.remove();
                        isDone = true;
                    }

                }

                if (isDone)
                    return true;

            }else {
                return false;
            }

        }

        return false;
    }
}
