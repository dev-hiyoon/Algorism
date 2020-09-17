package heap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DiskController {
    public static void main(String[] args) {
        // [[0, 3], [1, 9], [2, 6]]	9
        // A → B → C: 10ms(= (3 + 11 + 16) / 3)
        // A → C → B: 9ms(= (3 + 7 + 17) / 3)
        int[][] jobs = new int[][]{{0, 3}, {1, 9}, {2, 6}, {4, 3}};
        int result = solution(jobs);
        System.out.println(result);
    }

    public static int solution(int[][] jobs) {
        int answer = 0;
        int lastTime = 0;
        int idx = 1;
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        answer = jobs[0][1];
        lastTime = jobs[0][0] + jobs[0][1];
        int[][] temp = null;
        while (idx < jobs.length) {
            int maxIdx = 0;
            for (int i = idx; i < jobs.length; i++) {
                if (jobs[i][0] > lastTime) {
                    break;
                } else {
                    maxIdx++;
                }
            }

            if (maxIdx > 0) {
                temp = Arrays.copyOfRange(jobs, idx, idx + maxIdx);
                Arrays.sort(temp, (o1, o2) -> o1[1] - o2[1]);
                for (int i = 0; i < temp.length; i++) {
                    answer += (lastTime - temp[i][0] + temp[i][1]);
                    lastTime = (lastTime + temp[i][1]);
                    break;
                }

                idx++;
            } else {
                answer += jobs[idx][1];
                lastTime = jobs[idx][0] + jobs[idx][1];
                idx++;
            }
        }

        return answer / jobs.length;
    }
}
