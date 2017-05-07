package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize = -1;
    private int maxSize = -1;
    private List<Path> foundFiles;

    public SearchFileVisitor() {
        foundFiles = new ArrayList<>();
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        boolean nameFilter = true;
        boolean partFilter = true;
        boolean maxFilter = true;
        boolean minFilter = true;

        if (Files.isDirectory(file))
            return FileVisitResult.CONTINUE;

        if (partOfName != null && !partOfName.equals(""))
            if(!String.valueOf(file.getFileName()).contains(partOfName))
                nameFilter = false;

        if(maxSize > -1 && Files.size(file) >= maxSize)
            maxFilter = false;

        if (minSize > -1 && Files.size(file) <= minSize)
            minFilter = false;

        if (partOfContent != null) {
            String s = new String(Files.readAllBytes(file));
            if (!s.contains(partOfContent)) {
                partFilter = false;
            }
        }

        if (nameFilter && partFilter && maxFilter && minFilter)
            foundFiles.add(file);

        return FileVisitResult.CONTINUE;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
