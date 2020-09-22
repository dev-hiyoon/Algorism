package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DiskController {
    public static void main(String[] args) {
        // [[0, 3], [1, 9], [2, 6]]	9
        // A → B → C: 10ms(= (3 + 11 + 16) / 3)
        // A → C → B: 9ms(= (3 + 7 + 17) / 3)
        int[][] jobs = new int[][]{{0, 4}};
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
        printLog(jobs[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        while (true) {

            while (idx < jobs.length && jobs[idx][0] <= lastTime) {
                queue.add(jobs[idx++]);
            }

            if (queue.isEmpty() && idx < jobs.length) {
                answer += jobs[idx][1];
                lastTime = jobs[idx][0] + jobs[idx][1];
                printLog(jobs[idx]);
                idx++;
            } else if (!queue.isEmpty()) {
                int[] temp = queue.poll();
                answer += (lastTime - temp[0] + temp[1]);
                lastTime = (lastTime + temp[1]);
                printLog(temp);
            }

            if (queue.isEmpty() && idx >= jobs.length) {
                break;
            }
        }

        return answer / jobs.length;
    }

    private static void printLog(int[] job) {
        System.out.println(String.format("###### {%s, %s}", job[0], job[1]));
    }

}
