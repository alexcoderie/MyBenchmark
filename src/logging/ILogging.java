package logging;

public interface ILogging {
    void write(long value);
    void write(String value);
    void write(Object ... value);
    void close();

    void writeTime(String s, double time, TimeUnit timeUnit);
}
