package com.loctionov.racer.datareader;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderDataFilesImpl implements ReaderDateFiles {
    private static final Logger LOGGER = LogManager.getLogger(ReaderDataFilesImpl.class);

    @Override
    public List<String> getReadDateOfFiles(String pathDate) {
        try (Stream<String> stream = Files.lines(Paths.get(pathDate).toAbsolutePath())) {
            return stream.collect(Collectors.toList());
        } catch (IOException e) {
            LOGGER.error("File not exist!");

            throw new IllegalArgumentException("The file is missing from the directory or the file name is incorrect!");
        }
    }
}
