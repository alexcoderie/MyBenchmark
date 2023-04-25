package testbench;

import bench.DemoBenchmark;
import bench.IBenchmark;
import bench.cpu.CPUThreadedRoots;
import logging.ConsoleLogger;
import logging.ILogging;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class TestCPUThreadedRoots {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILogging log = new ConsoleLogger();
        IBenchmark bench = new CPUThreadedRoots();

        int workload = 200000000;
        bench.initialise(workload);
        bench.warmUp();

        for(int i = 1; i <= 64; i *= 2) {
            timer.start();
            bench.run(i);
            log.writeTime("Finished in: ", timer.stop(), TimeUnit.seconds);
            log.write("Score", (int)((double)workload/(timer.stop()*i)*1000000));
        }
    }
}
