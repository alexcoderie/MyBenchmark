package bench.cpu;

import bench.IBenchmark;

import java.util.Random;

public class CPUFixedPoint implements IBenchmark {
    private int size;
    private int[] num = new int[] {0, 1, 2, 3};
    private int[] res = {};

    private void integerArithmeticTest(int size) {
        int j = 1, k = 1, l = 1;
        try {
            for (int i = 0; i < size; i++) {
                j = num[1] * (k - j) * (l - k);
                k = num[3] * k - (l - j) * k;
                l = (l - k) * (num[2] + j);
                res[l - 2] = j + k + l;
                res[k - 2] = j * k * l;
            }
        } catch (IndexOutOfBoundsException e){}
    }
    private void branchingTest(int size) {
        int j = 1;
        for(int i = 0; i < size; i++) {
            if (j == 1) {
                j = num[2];
            } else {
                j = num[3];
            }if (j > 2) {
                j = num[0];
            } else {
                j = num[1];
            }
            if (j < 1) {
                j = num[1];
            } else {
                j = num[0];
            }
        }
    }

    private void assignmentTest(int size) {
        int[] a = new int[size];
        int[] b = new int[size];
        int[] c = new int[size];
        Random rd = new Random();

        for (int i = 0; i < a.length; i++) {
            a[i] = rd.nextInt();
        }

        for (int i = 0; i < b.length; i++) {
            b[i] = rd.nextInt();
        }
        try {
            for (int i = 0; i < c.length; i++) {
                c[i] = a[b[i]];
            }
        } catch (IndexOutOfBoundsException e) { }
    }
    @Override
    public void run() {

    }

    @Override
    public void run(Object... params) {
        int method = (Integer) params[0];

        switch(method) {
            case 1:
                integerArithmeticTest(size);
                break;
            case 2:
                branchingTest(size);
                break;
            case 3:
                assignmentTest(size);
                break;
            default:
                throw new IllegalArgumentException("Method doesn't exist!");
        }
    }

    @Override
    public void initialise(Object... params) {
        size = (Integer) params[0];
    }

    @Override
    public void clean() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public void warmUp() {
        for(int i = 0; i < 1000; i++) {
            integerArithmeticTest(100);
            branchingTest(100);
            assignmentTest(100);
        }
    }
}
