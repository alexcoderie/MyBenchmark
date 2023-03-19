package logging;

import java.util.Scanner;

public class ConsoleLogger implements ILogging{


    @Override
    public void write(long value) {
        System.out.println(value);
    }

    @Override
    public void write(String value) {
        System.out.println(value);
    }

    @Override
    public void write(Object... value) {
        for(Object val: value){
            System.out.print(val + " ");
        }
        System.out.print("\n");
    }

    @Override
    public void close() { }

    public void writeTime(String string, double value, TimeUnit unit) {
        /**Scanner input = new Scanner(System.in);
        System.out.println("Enter the measure you want your time to be printed in");
        unit = TimeUnit.valueOf(input.nextLine());**/

        switch(unit) {
            case Milliseconds:
                value = (value / Math.pow(10, 6));
                System.out.println(string + value + " milliseconds");
                break;
            case milliseconds:
                value = (value / Math.pow(10, 6));
                System.out.println(string + value + " milliseconds");
                break;
            case ms:
                value = value / Math.pow(10, 6);
                System.out.println(string + value + " milliseconds");
                break;
            case seconds:
                value = (value / Math.pow(10, 9));
                System.out.println(string + value + " seconds");
                break;
            case sec:
                value = (value / Math.pow(10, 9));
                System.out.println(string + value + " seconds");
                break;
            case nanoseconds:
                System.out.println(string + (long) value + " nanoseconds");
        }
    }
}
