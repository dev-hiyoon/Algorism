package test;

import java.util.Arrays;
import java.util.Collections;

public class test5 {

    public static void main(String[] args) {

    }

    private static int getInteger(int N) {

        if (N <= 10) {
            return N;
        }

        String strN = String.valueOf(N);
        Integer[] arrN = new Integer[strN.length()];
        for (int i = 0; i < strN.length(); i++) {
            arrN[i] = strN.charAt(i) - '0';
        }

        Arrays.sort(arrN, Collections.reverseOrder());
        Integer result = Integer.valueOf(Arrays.toString(arrN).replaceAll("[^0-9]", ""));
        if (result > 100000000) {
            result = -1;
        }

        return result;
    }
}
