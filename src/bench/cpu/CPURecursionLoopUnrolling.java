package bench.cpu;

import bench.IBenchmark;
import logging.ConsoleLogger;
import logging.ILogging;

public class CPURecursionLoopUnrolling implements IBenchmark {
    ILogging log = new ConsoleLogger();
    private long size;
    private long rSum;
    private long rStart;
    private int rCounter;
    private long uSum;
    private long uStart;
    private int uCounter;
    static boolean isPrime(long n)
    {
        if(n <= 1)
            return false;

        for(int i = 2; i < n; i++)
            if(n %i == 0)
                return false;
        return true;
    }
    private long recursive(long start, long size, int counter) {
        long localStart = start;
        long localSize = size;
        int localCounter = counter;
        try {
            if(localStart >= localSize)
                return rSum;

            if (isPrime(localStart))
                rSum = localStart;
            return rSum + recursive(localStart + 1, localSize, localCounter + 1);

        } catch (StackOverflowError | NoClassDefFoundError e) {
            this.rStart = rSum;
            this.size = localSize;
            this.rCounter = localCounter;
            return rSum;
        }
    }

    public String getResultR() {
        return "Reached nr " + rStart + "/" + size + " after " + rCounter + " calls";
    }
    private long recursiveUnrolled(long start, int unrollLevel, long size, int counter) {
        long localStart = start;
        long localSize = size;
        int localCounter = counter;
        try {
            if(localStart >= localSize)
                return uSum;
            localSize = Math.min(localStart + unrollLevel, size);

            for (long i = localStart; i < localSize; i++) {
                if (isPrime(i)) {
                    uSum = i;
                }
                localCounter++;
            }

            return uSum + recursiveUnrolled(localSize, unrollLevel, size, localCounter);
        } catch (StackOverflowError | NoClassDefFoundError e) {
            this.uStart = localStart;
            this.uCounter = localCounter;
            return uSum;
        }
    }
    public String getResultU() {
        return "Reached nr " + uStart + "/" + size + " after " + uCounter + " calls";
    }
    @Override
    public void run(Object... params) {
        boolean unrollUsage = (boolean) params[0];

        if(!unrollUsage) {
            recursive(1, size, 0);
        }
        else {
            int unrollFactor = (Integer) params[1];
            recursiveUnrolled(1, unrollFactor, size, 0);
        }
    }

    @Override
    public void run() {

    }

    @Override
    public void initialise(Object... params) {
        size = (Integer) params[0];
    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void warmUp() {

    }
}
