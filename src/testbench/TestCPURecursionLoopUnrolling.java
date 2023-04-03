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
        TimeUnit timeUnit = TimeUnit.nanoseconds;
        IBenchmark bench = new CPURecursionLoopUnrolling();
        CPURecursionLoopUnrolling res = new CPURecursionLoopUnrolling();
        double end;

        bench.initialise(10000000);
        timer.start();
        bench.run(false);
        end = timer.stop() / Math.pow(10, 6);
        //log.write(((CPURecursionLoopUnrolling) bench).getResultR());
        //log.write("Score:",(int) (1000000 / end));

        timer.start();
        bench.run(true,10);
        end = timer.stop() / Math.pow(10, 6);
        //log.write(((CPURecursionLoopUnrolling) bench).getResultU());
        log.write("Score:",(int) (10000000 / end));
    }
}
