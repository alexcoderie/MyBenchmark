package logging;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
public class FileLogger{
    private File file;
    private PrintWriter writer;

    public FileLogger(String filename) {
        try {
            file = new File(filename);
            writer = new PrintWriter(file);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void write(String value) {
        writer.println(value);
    }

    public void write(long value) {
        writer.println(value);
    }
    public void write(Object ... value) {
        writer.println(value);
    }

    public void close() {writer.close();}
}
