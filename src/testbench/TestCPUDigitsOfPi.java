package testbench;

import bench.DemoBenchmark;
import bench.IBenchmark;
import bench.cpu.CPUDigitsOfPi;
import logging.ConsoleLogger;
import logging.ILogging;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class TestCPUDigitsOfPi {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILogging log = new ConsoleLogger();
        IBenchmark bench = new CPUDigitsOfPi();
        TimeUnit timeUnit = TimeUnit.milliseconds;

        // 50 digits
        bench.initialise(50);
        bench.warmUp();

        timer.start();
        bench.run();
        log.writeTime("Finished in: ", timer.stop(), timeUnit);

        // 100 digits
        bench.initialise(100);
        //bench.warmUp();

        timer.start();
        bench.run();
        log.writeTime("Finished in: ", timer.stop(), timeUnit);

        // 1000 digits
        bench.initialise(1000);
        //bench.warmUp();

        timer.start();
        bench.run();
        log.writeTime("Finished in: ", timer.stop(), timeUnit);

        // 10 000 digits
        bench.initialise(10000);
        //bench.warmUp();

        timer.start();
        bench.run();
        log.writeTime("Finished in: ", timer.stop(), timeUnit);

        // 50 000 digits
        bench.initialise(50000);
        //bench.warmUp();

        timer.start();
        bench.run();
        log.writeTime("Finished in: ", timer.stop(), timeUnit);

        // 100 000 digits
        bench.initialise(100000);
        //bench.warmUp();

        timer.start();
        bench.run();
        log.writeTime("Finished in: ", timer.stop(), timeUnit);
    }
}
