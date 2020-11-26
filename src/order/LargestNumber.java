package order;

import java.util.*;

public class LargestNumber {

    public static void main(String[] args) {

        // [6, 10, 2] => 6 2 10
        // [3, 30, 34, 5, 9] => 9 5 34 3 30

        int[] array = new int[]{0, 0, 0};
        String reuslt = solution(array);
        System.out.println(reuslt);
    }

    public static String solution(int[] numbers) {
        String[] arrStr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arrStr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arrStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println(String.format("o1: %s, o2: %s", o1, o2));
                return String.format("%s%s", o1, o2).compareTo(String.format("%s%s", o2, o1));
            }
        });

        return arrStr[0].equals("0") ? "0" : String.join("", arrStr);
    }
}
