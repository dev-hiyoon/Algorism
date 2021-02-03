package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test4 {

    public static void main(String[] args) {
        int[][] datas = {{1, 4}, {2, 5}, {7, 8}, {9, 10}};
        List<int[]> results = new ArrayList<>();

        // sort
        Arrays.sort(datas, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // combine
        int minIdx = datas[0][0];
        int maxIdx = datas[0][1];
        for (int i = 1; i < datas.length; i++) {
            if (minIdx <= datas[i][0] && maxIdx >= datas[i][0]) {
                maxIdx = datas[i][1];
            } else {
                results.add(new int[]{minIdx, maxIdx});
                minIdx = datas[i][0];
                maxIdx = datas[i][1];
            }

            if (i == datas.length - 1) {
                results.add(new int[]{minIdx, maxIdx});
            }
        }

        results.stream().forEach(x -> System.out.println("idx0: " + x[0] + ", idx1: " + x[1]));
    }
}
