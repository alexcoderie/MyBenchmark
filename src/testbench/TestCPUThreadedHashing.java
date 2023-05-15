package testbench;

import bench.IBenchmark;
import bench.cpu.CPUDictionaryHashing;
import bench.cpu.CPUThreadedHashing;
import logging.ConsoleLogger;
import logging.ILogging;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class TestCPUThreadedHashing {
    public static void main(String[] args) {
        IBenchmark bench = new CPUThreadedHashing();
        ITimer timer = new Timer();
        ILogging log = new ConsoleLogger();
        TimeUnit timeUnit = TimeUnit.milliseconds;

        timer.start();
        bench.run(10, 8,31834033);
        System.out.println(((CPUThreadedHashing) bench).getResult());
        log.writeTime("Finished in: ", timer.stop(), timeUnit);
        // 1018655712 is "break"
        // 317266982 is "direct"
    }
}
