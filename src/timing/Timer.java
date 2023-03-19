package timing;

public class Timer implements ITimer{
    private long startTime;
    private long savedTime;
    private long totalTime;
    private long endTime;
    @Override
    public void start() {
        totalTime = 0;
        savedTime = 0;
        startTime = System.nanoTime();
    }

    @Override
    public long stop() {
        endTime = System.nanoTime();
        totalTime = savedTime + endTime - startTime;
        return totalTime;
    }

    @Override
    public void resume() {
        startTime = System.nanoTime();
    }

    @Override
    public long pause() {
        endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;
        savedTime += elapsedTime;
        return elapsedTime;
    }
}
