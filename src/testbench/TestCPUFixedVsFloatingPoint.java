package testbench;

import bench.IBenchmark;
import bench.cpu.CPUFixedVsFloatingPoint;
import bench.cpu.NumberRepresentation;
import logging.ConsoleLogger;
import logging.ILogging;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class TestCPUFixedVsFloatingPoint {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILogging log = new ConsoleLogger();
        TimeUnit timeUnit = TimeUnit.milliseconds;

        IBenchmark bench = new CPUFixedVsFloatingPoint();
        bench.initialise(1000000);
        bench.warmUp();

        timer.start();
        bench.run(NumberRepresentation.FIXED);
        log.writeTime("Finished in: ", timer.stop(), timeUnit);
        log.write("Result is: ", ((CPUFixedVsFloatingPoint) bench).getResult());

        timer.start();
        bench.run(NumberRepresentation.FLOATING);
        log.writeTime("Finished in: ", timer.stop(), timeUnit);
        log.write("Result is: ", ((CPUFixedVsFloatingPoint) bench).getResult());
    }
}
