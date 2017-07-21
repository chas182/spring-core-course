package by.vabramov.spring.core.course.v6;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class FileEventLogger implements EventLogger {
    private String fileName;
    private File file;

    public FileEventLogger(String fileName) {
        this.fileName = fileName;
    }

    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(file, event.toString() + "\n", Charset.forName("utf-8"), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void init() throws IOException {
        this.file = new File(fileName);
        if (file.createNewFile() && !file.canWrite()) {
            throw new IOException("File " + fileName + " is closed for writing.");
        }
    }

}
