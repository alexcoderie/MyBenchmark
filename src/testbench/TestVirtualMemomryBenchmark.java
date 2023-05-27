package testbench;

import bench.IBenchmark;
import bench.virtual_memory.VirtualMemoryBenchmark;
import logging.ConsoleLogger;
import logging.ILogging;
import timing.ITimer;
import timing.Timer;

public class TestVirtualMemomryBenchmark {
    public static void main(String[] args) {
        ILogging log = new ConsoleLogger();
        IBenchmark bench = new VirtualMemoryBenchmark();
        ITimer timer = new Timer();

        long filesize = 1L * 1024 * 1024 * 1024;
        int buffersize = 4 * 1024;

        bench.run(filesize, buffersize);
        log.write(((VirtualMemoryBenchmark) bench).getResult());

    }
}
