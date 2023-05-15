package testbench;

import bench.IBenchmark;
import bench.hdd.HDDWriteSpeed;
import logging.ConsoleLogger;
import logging.ILogging;
import logging.TimeUnit;
import timing.ITimer;
import timing.Timer;

public class TestHDDWriteSpeed {
   public static void main(String[] args) {
      IBenchmark bench = new HDDWriteSpeed();
      ITimer timer = new Timer();
      ILogging log = new ConsoleLogger();
      TimeUnit timeUnit = TimeUnit.milliseconds;
      timer.start();
      bench.run("fb", false);
      log.writeTime("Finished in: ", timer.stop(), timeUnit);
   }
}
