package order;

import java.util.Arrays;

public class KthNumber {

    public static void main(String[] args) {
        // [1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        int[] results = solution(array, commands);
        for (int result : results) {
            System.out.println(result);
        }
    }

    public static int[] solution(int[] array, int[][] commands) {
        int idxAnswer = 0;
        int[] answer = new int[commands.length];

        for (int[] command : commands) {
            int idx = 0;
            int[] temp = new int[command[1] - command[0] + 1];
            for (int i = command[0] - 1; i < command[1]; i++) {
                temp[idx] = array[i];
                idx++;
            }

            Arrays.sort(temp);
            answer[idxAnswer] = temp[command[2] - 1];
            idxAnswer++;
        }

        return answer;
    }
}
