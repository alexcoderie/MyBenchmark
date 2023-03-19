package bench.cpu;

import bench.IBenchmark;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class CPUDigitsOfPi implements IBenchmark {
    private int n;
    private static final BigDecimal ONE  = new BigDecimal("1");
    private static final BigDecimal TWO  = new BigDecimal("2");
    private static final BigDecimal FOUR = new BigDecimal("4");
    private static final BigDecimal ACC  = new BigDecimal("1E-10000");

    public static BigDecimal sqrt(BigDecimal value, int scale) {
        BigDecimal x0 = new BigDecimal("0");
        BigDecimal x1 = new BigDecimal(Math.sqrt(value.doubleValue()));

        while (!x0.equals(x1)) {
            x0 = x1;
            x1 = value.divide(x0, scale, RoundingMode.HALF_UP);
            x1 = x1.add(x0);
            x1 = x1.divide(TWO, scale, RoundingMode.HALF_UP);
        }

        return x1;
    }
    @Override
    public void run() {
        BigDecimal a = ONE;
        BigDecimal b = ONE.divide(sqrt(TWO, n), n, RoundingMode.HALF_UP);
        BigDecimal t = ONE.divide(FOUR);
        BigDecimal p = ONE;
        BigDecimal oldA;

        while(a.subtract(b).abs().compareTo(ACC) > 0) {
            oldA = a;

            a = oldA.add(b).divide(TWO, n, RoundingMode.HALF_UP);
            b = sqrt(oldA.multiply(b), n);
            t = t.subtract(p.multiply(oldA.subtract(a).multiply(oldA.subtract(a))));
            p = p.multiply(TWO);
        }

        a.add(b).multiply(a.add(b)).divide(FOUR.multiply(t), n, RoundingMode.HALF_UP);
    }


    @Override
    public void run(Object... params) {

    }

    @Override
    public void initialise(Object... params) {
        this.n = (Integer) params[0];
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
            BigDecimal a = ONE;
            BigDecimal b = ONE.divide(sqrt(TWO, n), n, RoundingMode.HALF_UP);
            BigDecimal t = ONE.divide(FOUR);
            BigDecimal p = ONE;
            BigDecimal oldA;

            while (a.subtract(b).abs().compareTo(ACC) > 0) {
                oldA = a;

                a = oldA.add(b).divide(TWO, n, RoundingMode.HALF_UP);
                b = sqrt(oldA.multiply(b), n);
                t = t.subtract(p.multiply(oldA.subtract(a).multiply(oldA.subtract(a))));
                p = p.multiply(TWO);
            }

            a.add(b).multiply(a.add(b)).divide(FOUR.multiply(t), n, RoundingMode.HALF_UP);
        }
    }
}
