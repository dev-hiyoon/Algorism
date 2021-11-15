package test;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class Test4 {

    public static void main(String[] args) {
        int[] results = solution(26, new int[]{1, 4, 16}, new int[]{26, 10, 20});
        System.out.println(results);
        Arrays.stream(results).forEach(x -> System.out.println(x));
    }

    public static int[] solution(int N, int[] P, int[] Q) {
        // write your code in Java SE 8
        Set<Integer> primeNumbers = new LinkedHashSet<>();
        primeNumbers.add(2);
        primeNumbers.add(3);
        for (int i = 4; i <= N; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i != j && i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                primeNumbers.add(i);
            }
        }

        int[] arrNumber = new int[N];
        for (int i = 3; i < N; i++) {
            boolean isPrime = true;
            for (int j = 1; j <= Math.sqrt(N); j++) {
                if (i % j == 0 && !primeNumbers.contains(j)) {
                    isPrime = false;
                    break;
                }
            }

            arrNumber[i] = isPrime ? 1 : 0;
        }

        int[] results = new int[P.length];
        for (int i = 0; i < P.length; i++) {
            int cnt = 0;
            for (int j = P[i]; j <= Q[i]; j++) {
                if (arrNumber[j - 1] > 0) {
                    cnt++;
                }
            }

            results[i] = cnt;
        }

        return results;

    }
}
