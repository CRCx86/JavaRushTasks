package com.javarush.task.task31.task3106;

import java.io.*;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        if(args.length > 0) {
            File resultFileName = new File(args[0]);
            String[] fileNameParts = new String[args.length - 1];

            for (int i = 0; i < args.length - 1; i++) {
                fileNameParts[i] = args[i + 1];
            }

            Arrays.sort(fileNameParts);

            Vector<FileInputStream> v = new Vector<FileInputStream>(fileNameParts.length);
            for (int x = 0; x < fileNameParts.length; x++)
                v.add(new FileInputStream(fileNameParts[x]));

            Enumeration<FileInputStream> e = v.elements();

            SequenceInputStream sequenceInputStream = new SequenceInputStream(e);

            ZipInputStream is = new ZipInputStream(sequenceInputStream);
            try {
                for(ZipEntry entry = null; (entry = is.getNextEntry()) != null; ) {
                    OutputStream os = new BufferedOutputStream(new FileOutputStream(resultFileName));
                    try {
                        final int bufferSize = 1024;
                        byte[] buffer = new byte[bufferSize];
                        for(int readBytes = -1; (readBytes = is.read(buffer, 0, bufferSize)) > -1; ) {
                            os.write(buffer, 0, readBytes);
                        }
                        os.flush();
                    } finally {
                        os.close();
                    }
                }
            } finally {
                is.close();
            }
        }

    }
}
