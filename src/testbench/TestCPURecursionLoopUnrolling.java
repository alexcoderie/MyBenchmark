package testbench;

import bench.IBenchmark;
import bench.cpu.CPUFixedPoint;
import bench.cpu.CPURecursionLoopUnrolling;
import logging.ConsoleLogger;
import logging.ILogging;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class TestCPURecursionLoopUnrolling {
    public static void main(String[] args) {
        ITimer timer = new Timer();
        ILogging log = new ConsoleLogger();
        TimeUnit timeUnit = TimeUnit.milliseconds;
        IBenchmark bench = new CPURecursionLoopUnrolling();
        CPURecursionLoopUnrolling res = new CPURecursionLoopUnrolling();

        bench.initialise(1000000);
        bench.run(false);
        log.write(((CPURecursionLoopUnrolling) bench).getResultR());
        bench.run(true,10);
        log.write(((CPURecursionLoopUnrolling) bench).getResultU());
    }
}
