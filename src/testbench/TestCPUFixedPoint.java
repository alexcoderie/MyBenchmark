package testbench;

import bench.IBenchmark;
import bench.cpu.CPUFixedPoint;
import logging.ConsoleLogger;
import logging.ILogging;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class TestCPUFixedPoint {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILogging log = new ConsoleLogger();
        TimeUnit timeUnit = TimeUnit.milliseconds;
        IBenchmark bench = new CPUFixedPoint();
        double end;
        int mops;
        bench.initialise(10000000);
        //bench.warmUp();

        timer.start();
        bench.run(1);
        end = timer.stop();
        log.writeTime("Finished in: ", end, timeUnit);
        end = (end / Math.pow(10, 9));
        log.write("Number of MOPS", (int) (29.0 * 10000000 / end / 1e6 ));

        timer.start();
        bench.run(2);
        end = timer.stop();
        log.writeTime("Finished in: ", end, timeUnit);
        end = (end / Math.pow(10, 9));
        log.write("Number of MOPS", (int) (17.0 * 10000000 / end / 1e6 ));

        timer.start();
        bench.run(3);
        end = timer.stop();
        log.writeTime("Finished in: ", end, timeUnit);
        end = (end / Math.pow(10, 9));
        log.write("Number of MOPS", (int) (12.0 * 10000000 / end / 1e6 ));
    }
}
