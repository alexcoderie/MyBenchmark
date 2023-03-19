package testbench;

import bench.DemoBenchmark;
import bench.IBenchmark;
import logging.ConsoleLogger;
import logging.ILogging;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;


public class TestDemoBench {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILogging log = new ConsoleLogger();
        IBenchmark bench = new DemoBenchmark();
        final int workload = 100;

        bench.initialise(10000);
        timer.start();
        bench.run();
        //long time = timer.stop();

        //log.write("Finished in", time, "ns", "\n");

        bench.initialise(workload);
        TimeUnit timeUnit = TimeUnit.milliseconds;
        for(int i = 0; i < 12; ++i) {
            timer.resume();
            bench.run();
            long time = timer.pause();
            log.writeTime("Run " + i + ": ", time, timeUnit);
            ///log.write("Run " + i + ":", time, "\n");
        }

        log.writeTime("Finished in: ", timer.stop(), timeUnit);

        log.close();
        bench.clean();
    }
}