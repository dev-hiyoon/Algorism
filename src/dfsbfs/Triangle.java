package dfsbfs;

import java.util.Arrays;

public class Triangle {

    public static void main(String[] args) {

        int[] A = {10, 2, 5, 1, 8, 20};
        int result = solution(A);
        System.out.println(result);
    }

    private static int cnt = 0;

    public static int solution(int[] A) {

        combination(A, 3, 0, new boolean[A.length], new int[3]);
        return cnt;
    }

    private static void combination(int[] nums, int r, int start, boolean[] visit, int[] results) {
        if (r == 0) {
            System.out.println(Arrays.toString(results));
            int[] newArray = Arrays.copyOf(results, 3);
            Arrays.sort(newArray);

            if ((newArray[0] + newArray[1] > newArray[2]) &&
                    (newArray[1] + newArray[2] > newArray[0]) &&
                    (newArray[2] + newArray[0] > newArray[1])) {
                cnt++;
            }


            return;
        }

        for (int i = start; i < nums.length; i++) {
            visit[i] = true;
            results[r - 1] = nums[i];
            combination(nums, r - 1, i + 1, visit, results);
            visit[i] = false;
        }
    }
}