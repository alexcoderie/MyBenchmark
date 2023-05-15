package bench.hdd;

import java.io.IOException;

import bench.IBenchmark;

public class HDDWriteSpeed implements IBenchmark {

    @Override
    public void initialise(Object... params) {
    }

    @Override
    public void warmUp() {
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException(
                "Method not implemented. Use run(Object) instead");
    }

    @Override
    public void run(Object... options) {
        FileWriter writer = new FileWriter();
        // either "fs" - fixed size, or "fb" - fixed buffer
        String option = (String) options[0];
        // true/false whether the written files should be deleted at the end
        Boolean clean = (Boolean) options[1];

        String prefix = "D:\\info\\Anul 2\\Semestrul 2\\CO\\MyBenchmark\\junk\\";
        String suffix = ".dat";
        int minIndex = 0;
        int maxIndex = 8;
        long fileSize =  256 * 1024 * 1024; // 256, 512 MB, 1GB // type Long!
        int bufferSize = 4 * 1024; // 4 KB

        try {
            if (option.equals("fs"))
                writer.streamWriteFixedFileSize(prefix, suffix, minIndex,
                        maxIndex, fileSize, clean);
            else if (option.equals("fb"))
                writer.streamWriteFixedBufferSize(prefix, suffix, minIndex,
                        maxIndex, bufferSize, clean);
            else
                throw new IllegalArgumentException("Argument "
                        + options[0].toString() + " is undefined");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void clean() {
        // clean temp files here?
    }

    @Override
    public void cancel() {

    }

    public String getResult() {
        return null; // or MBps
    }
}
