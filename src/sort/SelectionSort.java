package sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] datas = {1, 5, 6, 2, 4, 7, 3, 8, 9, 10};
        int temp = 0;

        for (int i = 1; i < datas.length; i++) {
            for (int j = datas.length - i; j > 0; j--) {
                if (datas[j] < datas[j - 1]) {
                    temp = datas[j - 1];
                    datas[j - 1] = datas[j];
                    datas[j] = temp;
                }
            }
        }

        Arrays.stream(datas).forEach(
                x -> System.out.println(x));
    }
}
