package bench.cpu;

import bench.IBenchmark;

public class CPUThreadedRoots implements IBenchmark {
    private int size;
    private double result;
    public boolean running = false;

    class SquareRootTask implements Runnable {
        private int from, to;
        private final double precision = 1e-4;
        double result = 0.0;

        public SquareRootTask(int from, int to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public void run() {
            for(int i = from; i < to && running; i++) {
                result += getNewtonian(i);
            }
        }

        private double getNewtonian(double x) {
            double s = x;

            while(Math.abs(s*s - x) > precision)
                s = (x / s + s) / 2;
            return s;
        }
    }

    public String getResult()
    {
        return String.valueOf(result);
    }

    @Override
    public void run() {
        //
    }

    @Override
    public void run(Object... params) {
        int nThreads = (Integer) params[0];

        Thread[] threads = new Thread[nThreads];
        final int jobPerThread = size/nThreads;
        running = true;

        for(int i = 0; i < nThreads; ++i)
        {
            if(threads[i] == null)
            {
                threads[i] = new Thread(new SquareRootTask(jobPerThread * i + 1, jobPerThread * (i + 1) + 1));
                threads[i].start();
            }
        }

        for(int i = 0; i < nThreads; ++i)
        {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        getResult();
        running = false;
    }

    @Override
    public void initialise(Object... params) {
        this.size = (Integer) params[0];
    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {
        running = false;
    }

    @Override
    public void warmUp() {
        int cores = Runtime.getRuntime().availableProcessors();
        run(64);
        System.out.println("Number of cores " + cores);
    }
}
