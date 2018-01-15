package _3_PrimePalindrome;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

// working 2.7 secs
public class PrimePalindrome {
    public static void main(String[] args) {
        System.out.printf("Starting solution...%n");
        long startTime = System.currentTimeMillis();
        final int LIMIT = 100_000;
        List<Long> primes = new ArrayList<>();
        boolean[] notPrime = new boolean[LIMIT];
        for (int i = 2; i < LIMIT; i++) {
            if (!notPrime[i] && i < Math.sqrt(LIMIT)) {
                for (int j = i * i; j < LIMIT; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        for (long i = 2; i < LIMIT; i++) {
            if (!notPrime[(int)i]) {
                primes.add(i);
            }
        }
        List<Composition> mulPrimes = new ArrayList<>();
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i; j < primes.size(); j++) {
                long num = primes.get(i) * primes.get(j);
                if (isPalindrome(num)) {
                    mulPrimes.add(new Composition(num, primes.get(i), primes.get(j)));
                }
            }
        }
        Composition max = mulPrimes.get(0);
        for (Composition elem : mulPrimes) {
            if (elem.value > max.value) {
                max = elem;
            }
        }
        System.out.printf("Solution is: %s = %s * %s%n", max.value, max.multiplier1, max.multiplier2);
        long currentTime = System.currentTimeMillis();
        double workTime = currentTime - startTime;
        System.out.printf("Time elapsed: %s seconds", workTime / 1_000 );
    }

    public static boolean isPalindrome(long number) {
        long reverse = 0;
        long value = number;
        while (value != 0) {
            long remainder = value % 10;
            value /= 10;
            reverse = reverse * 10 + remainder;     // Attention!
        }
        return number == reverse;
    }
}
