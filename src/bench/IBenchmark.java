package bench;

public interface IBenchmark {
    void run();
    void run(Object ... params);
    void initialise(Object ... params);
    void clean();
    void cancel();
    void warmUp();
}
