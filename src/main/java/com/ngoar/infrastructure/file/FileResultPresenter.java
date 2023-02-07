package com.ngoar.infrastructure.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.ngoar.domain.infrastructure.ResultPresenter;
import lombok.extern.slf4j.Slf4j;

import static com.ngoar.infrastructure.file.FileInputProvider.RESOURCE_DIR;

@Slf4j
public class FileResultPresenter implements ResultPresenter {

    public static final String OUTPUT_FILE = "Output.txt";

    @Override
    public void provideResult(Integer result) {

        try {
            Files.writeString(Path.of(RESOURCE_DIR + OUTPUT_FILE), result.toString());
        } catch (IOException e) {
            throw new IllegalArgumentException(
                String.format("File %s cannot be written to the %s directory", OUTPUT_FILE, RESOURCE_DIR));
        }
        log.info("Result was successfully written to {} file of {} directory%n", OUTPUT_FILE, RESOURCE_DIR);
    }

}
