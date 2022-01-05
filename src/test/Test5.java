package test;

import java.util.Arrays;
import java.util.Collections;

public class Test5 {

    public static void main(String[] args) {
        Test5 t = new Test5();
        for (int i = 99999980; i <= 100000005; i++) {
            System.out.println("######### i: " + i + ", sorted: " + t.getInteger(i));
        }
    }

    private int getInteger(int N) {

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
