package com.javarush.task.task39.task3913;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;

public class Solution {
    public static void main(String[] args) throws IOException, ParseException {
        LogParser logParser = new LogParser(Paths.get("c:/logs/"));
//        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));
//        System.out.println(logParser.getNumberOfUniqueIPs(null, null));
//        System.out.println(logParser.getUniqueIPs(null, new Date()));
//        System.out.println(logParser.getIPsForUser("Amigo", null, new Date()));
//        System.out.println(logParser.getIPsForEvent(Event.DONE_TASK, null, new Date()));
//        System.out.println(logParser.getIPsForStatus(Status.ERROR, null, new Date()));
        //System.out.println(logParser.execute("get ip for user = \"Eduard Petrovich Morozko\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
        System.out.println(logParser.execute("get ip for event = \"LOGIN\" and date between \"30.08.2012 16:08:13\" and \"03.01.2014 23:59:59\""));
        System.out.println(logParser.execute("get ip for event = \"DOWNLOAD_PLUGIN\" and date between \"30.08.2012 16:08:13\" and \"03.01.2014 23:59:59\""));
        System.out.println(logParser.execute("get ip for event = \"WRITE_MESSAGE\" and date between \"30.08.2012 16:08:13\" and \"03.01.2014 23:59:59\""));
        System.out.println(logParser.execute("get ip for event = \"SOLVE_TASK\" and date between \"30.08.2012 16:08:13\" and \"03.01.2014 23:59:59\""));
        System.out.println(logParser.execute("get ip for event = \"DONE_TASK\" and date between \"30.08.2012 16:08:13\" and \"03.01.2014 23:59:59\""));

        //System.out.println(logParser.execute("get ip for status = \"OK\" and date between \"11.12.2013 0:00:00\" and \"03.01.2014 23:59:59\""));
    }
}