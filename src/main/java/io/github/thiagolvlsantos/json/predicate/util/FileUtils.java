package io.github.thiagolvlsantos.json.predicate.util;

import lombok.experimental.UtilityClass;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class FileUtils {

    public boolean write(File file, String content) throws IOException {
        boolean ok = prepare(file);
        Files.write(file.toPath(), String.valueOf(content).getBytes(), StandardOpenOption.CREATE,
                StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
        return ok;
    }

    public boolean prepare(File file) {
        File dir = file.getParentFile();
        if (dir.exists()) {
            return true;
        }
        return dir.mkdirs();
    }

    public boolean delete(File file) throws IOException {
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            for (File c : children) {
                delete(c);
            }
        }
        file.setWritable(true);
        Files.delete(file.toPath());
        return true;
    }
}