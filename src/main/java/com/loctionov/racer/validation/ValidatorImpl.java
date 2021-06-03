package com.loctionov.racer.validation;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ValidatorImpl implements Validator<String> {

    @Override
    public void validationFilePath(String pathOfFile, String message) {
        if (pathOfFile == null) {
            throw new IllegalArgumentException(message);
        }

        if (pathOfFile.isEmpty()) {
            throw new IllegalArgumentException(message);
        }

        if (!Files.exists(Paths.get(pathOfFile).toAbsolutePath())) {
            throw new IllegalArgumentException(message);
        }
    }
}
