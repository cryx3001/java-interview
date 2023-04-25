package collection;

import java.util.List;
import java.util.stream.Collectors;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {

    // Power method, just in case we're not allowed to use Math.pow
    public static double power(double i, double n) {
        if (n == 0)
            return 1;

        double res = 1;
        // i^(n//2)
        for (double j = 1; j <= n / 2; j++)
            res *= i;
        res *= res; // i^(n//2) * i^(n//2)
        if (n % 2 == 1)
            res *= i; // i^(n//2) * i^(n//2) * i
        return res;
    }

    /**
     * operation : x -> ((x * 2) + 3) ^ 5
     */
    public static List<Double> compute1(List<Integer> input) {
        return input
                .stream()
                .map(x -> power(x * 2 + 3, 5))
                .collect(Collectors.toList());
    }

    /**
     * operation : abc -> AbcAbc
     */
    public static List<String> compute2(List<String> input) {
        return input
                .stream()
                .map(x -> {
                    if (x.length() == 0)
                        return "";
                    String res = x.substring(0,1).toUpperCase() + x.substring(1);
                    return res + res;
                })
                .collect(Collectors.toList());
    }
}
