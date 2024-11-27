package calculator;

import firstprevious.FirstPrevious;
import secondprevious.SecondPrevious;

public class Calculator {
    public static long calculateFibonacci(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        long n1 = 0;   // F(0)
        long n2 = 1;   // F(1)

        for (int i = 2; i <= n; i++) {
            long current = FirstPrevious.getFirstPrevious(n1, n2);
            n1 = SecondPrevious.getSecondPrevious(n1, n2);
            n2 = current;
        }
        return n2;
    }
}
