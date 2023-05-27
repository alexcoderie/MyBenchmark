package testbench;

import bench.IBenchmark;
import bench.hdd.HDDRandomAccess;
import bench.hdd.HDDWriteSpeed;
import logging.ConsoleLogger;
import logging.ILogging;
import timing.ITimer;
import timing.Timer;

public class TestHDDRandomAccess {
    public static void main(String[] args) {
        IBenchmark bench = new HDDRandomAccess();
        ITimer timer = new Timer();
        ILogging log = new ConsoleLogger();
        bench.initialise((long) 1024 * 1024 * 1024 * 5);
        bench.run("r","fs", 512);
        log.write(((HDDRandomAccess) bench).getResult());
        bench.run("r","fs", 4 * 1024);
        log.write(((HDDRandomAccess) bench).getResult());
        bench.run("r","fs", 64 * 1024);
        log.write(((HDDRandomAccess) bench).getResult());
        bench.run("r","fs", 1 * 1024 * 1024);
        log.write(((HDDRandomAccess) bench).getResult());
        bench.run("r", "ft", 512);
        log.write(((HDDRandomAccess) bench).getResult());
        bench.run("r", "ft", 4 * 1024);
        log.write(((HDDRandomAccess) bench).getResult());
        bench.run("r", "ft", 64 * 1024);
        log.write(((HDDRandomAccess) bench).getResult());
        bench.run("r", "ft", 1 * 1024 * 1024);
        log.write(((HDDRandomAccess) bench).getResult());
    }
}
