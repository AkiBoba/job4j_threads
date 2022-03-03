package ru.job4j.io;

import net.jcip.annotations.ThreadSafe;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@ThreadSafe
public final class SaveParsedFile {
    private final File file;

    public SaveParsedFile(File file) {
        this.file = file;
    }

    public synchronized void saveContent(String content) {
        try (OutputStream o = new FileOutputStream(file)) {
            for (int i = 0; i < content.length(); i += 1) {
                o.write(content.charAt(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
