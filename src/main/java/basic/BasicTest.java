package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use Math.pow for power method
 */
public class BasicTest {

    /**
     * return i ^ n for positive Integer, None otherwise
     * alse return None in case of errors
     */
    public static Option<Integer> power(Integer i, Integer n) {
        if (i < 0 || n < 0)
            return Option.none();
        if (n == 0)
            return Option.of(1);
        if (i == 0)
            return Option.of(0); // So we don't have to take care of divisions by zero

        int res = 1;
        for (int j = 1; j <= n; j++)
        {
            if (res > Integer.MAX_VALUE / i) // ==> res * i > Integer.MAX_VALUE ==> Overflow!
                return Option.none();
            res *= i;
        }
        return Option.of(res);
    }
}