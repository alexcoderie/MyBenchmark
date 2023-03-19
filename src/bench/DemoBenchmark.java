package bench;

import java.util.Random;

public class DemoBenchmark implements IBenchmark{
    private int n;
    private int[] array;

    @Override
    // Implementation of Bubble Sort
    public void run() {
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (array[j] > array[j + 1]) {
                    // swap arr[j+1] and arr[j]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
    }

    @Override
    public void run(Object... params) {

    }

    @Override
    public void initialise(Object... params) {
        Random random = new Random();
        this.n = (Integer) params[0];
        this.array = new int[n];

        for(int i = 0; i < n; i++) {
            array[i] = random.nextInt(1000);
        }
    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void warmUp() {

    }
}