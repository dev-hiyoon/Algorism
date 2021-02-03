package search;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(searchBinaryTree(1, arr));
    }

    private static int searchBinaryTree(int searchVal, int[] datas) {
        int result = -1;
        int sttIdx = 0;
        int midIdx = -1;
        int endIdx = datas.length - 1;

        while (sttIdx < endIdx) {
            midIdx = (sttIdx + endIdx) / 2; // ex) 10 / 2 = 5;
            if (searchVal > datas[midIdx]) {
                sttIdx = midIdx + 1;
            } else if (searchVal < datas[midIdx]) {
                endIdx = midIdx - 1;
            } else {
                result = midIdx;
                break;
            }

            if (endIdx - sttIdx <= 2) {
                if (datas[endIdx] == searchVal) {
                    result = endIdx;
                } else {
                    result = sttIdx;
                }

                break;
            }
        }


        return result;
    }
}
