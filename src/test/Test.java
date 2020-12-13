package test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {

        long result = solution(new int[]{1, 3, 6, 4, 1, 2});
        System.out.println(result);
    }


    public static int solution(int[] A) {

        Arrays.sort(A);
        if (A[A.length - 1] < 0) {
            return 1;
        }

        int result = 0;
        int min = 1;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == min) {
                min++;
            } else {
                if (A[i] < min) {
                } else {
                    break;
                }
            }

            result = min;
        }

        return result;
    }
}