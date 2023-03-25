package bench.cpu;

import bench.IBenchmark;

public class CPUFixedVsFloatingPoint implements IBenchmark {
    private int size;
    private int result;
    @Override

    public void run() {

    }

    @Override
    public void run(Object... params) {
        result = 0;

        switch((NumberRepresentation) params[0]) {
            case FLOATING:
                for(int i = 0; i < size; i++)
                    result = (int) ((float) i / 256);
                break;
            case FIXED:
                for(int i = 0; i < size; i++)
                    result = i / 256;
                break;
            default:
                break;
        }
    }

    @Override
    public void initialise(Object... params) {
        size = (Integer)params[0];
    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void warmUp() {
        for(int i = 0; i < size; i++) {
            result = (int) ((float) i / 256);
            result = i / 256;
        }
    }

    public String getResult() {
        return String.valueOf(result);
    }
}
