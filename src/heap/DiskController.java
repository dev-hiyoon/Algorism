package heap;

import java.util.LinkedList;
import java.util.Queue;

public class DiskController {
    public static void main(String[] args) {
        // [[0, 3], [1, 9], [2, 6]]	9
        // A → B → C: 10ms(= (3 + 11 + 16) / 3)
        // A → C → B: 9ms(= (3 + 7 + 17) / 3)
        int[][] jobs = new int[][]{{0, 3}, {1, 9}, {2, 6}};
        int result = solution(jobs);
        System.out.println(result);
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        return answer;
    }
}
