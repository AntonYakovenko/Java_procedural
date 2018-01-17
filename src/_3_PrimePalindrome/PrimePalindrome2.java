package _3_PrimePalindrome;

import java.util.ArrayList;
import java.util.List;

// working 0.6 secs
public class PrimePalindrome2 {
    public static void main(String[] args) {
        System.out.printf("Starting solution...%n");
        long startTime = System.currentTimeMillis();
        final int LIMIT = 100_000;
        boolean[] notPrime = new boolean[LIMIT];
        List<Long> primes1 = new ArrayList<>();
        List<Long> primes3 = new ArrayList<>();
        List<Long> primes7 = new ArrayList<>();
        List<Long> primes9 = new ArrayList<>();
        for (int i = 2; i < LIMIT; i++) {
            if (!notPrime[i] && i <= Math.sqrt(LIMIT)) {
                for (int j = i * i; j < LIMIT; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        for (long i = 2; i < LIMIT; i++) {
            if (!notPrime[(int) i]) {
                if (i % 10 == 1) {
                    primes1.add(i);
                }
                if (i % 10 == 3) {
                    primes3.add(i);
                }
                if (i % 10 == 7) {
                    primes7.add(i);
                }
                if (i % 10 == 9) {
                    primes9.add(i);
                }
            }
        }

        List<Composition> mulPrimes = new ArrayList<>(addValues(primes1, primes9));
        mulPrimes.addAll(addValues(primes3, primes3));
        mulPrimes.addAll(addValues(primes7, primes7));

//        for (MultipliedNumber elem : mulPrimes) {
//            System.out.println(elem.value);
//        }
//        System.out.println(mulPrimes.size());
        Composition max = mulPrimes.get(mulPrimes.size() - 1);
        for (Composition elem : mulPrimes) {
            if (elem.value > max.value) {
                max = elem;
            }
        }
        System.out.printf("Solution is: %s = %s * %s%n", max.value, max.multiplier1, max.multiplier2);
        long currentTime = System.currentTimeMillis();
        long workTime = currentTime - startTime;
        System.out.printf("Time elapsed: %s seconds", (double) workTime / 1_000);
    }

    public static List<Composition> addValues(List<Long> list1, List<Long> list2) {
        List<Composition> result = new ArrayList<>();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = i; j < list2.size(); j++) {
                long num = list1.get(i) * list2.get(j);
                if (isPalindrome(num)) {
                    Composition numToAdd = new Composition(num, list1.get(i), list2.get(j));
                    result.add(numToAdd);
                }
            }
        }
        return result;
    }

    public static boolean isPalindrome(long number) {
        long reverse = 0;
        long value = number;
        while (value != 0) {
            long remainder = value % 10;
            value /= 10;
            reverse = reverse * 10 + remainder;
        }
        return number == reverse;
    }
}

