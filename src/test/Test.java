package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Test {

    public static void main(String[] args) {

        int[][] board = {{0, 0, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        int result = solution(board);
        System.out.println(result);
    }

    public static int solution(int[][] board) {
        int answer = 0;
        int[] array = new int[board[0].length];
        for (int i = 0; i < board.length; i++) {
            int max = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (i == 0) {
                    array[j] = board[i][j];
                } else if (board[i][j] == 0) {
                    array[j] = 0;
                } else {
                    array[j] += board[i][j];
                    max = Math.max(max, array[j]);
                }
            }

            if (answer < max) {
                int cnt = 0;
                for (int j = 0; j < array.length; j++) {
                    if (max == array[j]) {
                        cnt++;
                    }
                }

                if (cnt <= max) {
                    answer = cnt;
                }
            }
        }

        return answer * answer;
    }
}