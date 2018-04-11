package _3_PrimePalindrome;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

// working 2.5 secs
public class PrimePalindrome {
    private static final int HI = 100_000;
    private static final int LO = 10_000;

    private static Composition findPalindrome() {
        List<Long> primes = new ArrayList<>();
        boolean[] notPrime = new boolean[HI - LO];
        for (int i = 2; i < Math.sqrt(HI); i++) {
            if (!notPrime[i] && i < Math.sqrt(HI)) {
                for (int j = i * i; j < HI - LO; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        for (long i = 2; i < HI - LO; i++) {
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
        return max;
    }

    private static boolean isPalindrome(long number) {
        long reverse = 0;
        long value = number;
        while (value != 0) {
            long remainder = value % 10;
            value /= 10;
            reverse = reverse * 10 + remainder;
        }
        return number == reverse;
    }

    public static void main(String[] args) {
        System.out.printf("Starting solution...%n");
        long startTime = System.currentTimeMillis();
        Composition answer = findPalindrome();
        System.out.printf("Solution is: %s = %s * %s%n",
                answer.value, answer.multiplier1, answer.multiplier2);
        long currentTime = System.currentTimeMillis();
        double workTime = currentTime - startTime;
        System.out.printf("Time elapsed: %s seconds", workTime / 1_000 );
    }

    private static class Composition {
        long value;
        long multiplier1;
        long multiplier2;
        Composition(long value, long multiplier1, long multiplier2){
            this.value = value;
            this.multiplier1 = multiplier1;
            this.multiplier2 = multiplier2;
        }
    }
}
