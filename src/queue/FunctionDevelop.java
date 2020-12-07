package queue;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class FunctionDevelop {

    public static void main(String[] args) {

        //
        // case1. [93, 30, 55]	[1, 30, 5]	=> [2, 1]
        // case2. [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	=> [1, 3, 2]

        int[] progresses = new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds = new int[]{1, 1, 1, 1, 1, 1};
        int[] results = solution2(progresses, speeds); // {4, 3, 1, 1, 0}
        for (int result : results) {
            System.out.println(result);
        }
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        boolean isClear = false;
        Queue progressQueue = new LinkedList();
        for (int progress : progresses) {
            progressQueue.add(progress);
        }
        Queue resultQueue = new LinkedList();
        while (!isClear) {
            int queueCnt = progressQueue.size();
            boolean isContinue = true;
            for (int i = progresses.length - queueCnt; i < progresses.length; i++) {
                progresses[i] += speeds[i];

                if (i == progresses.length - queueCnt && progresses[i] < 100) {
                    isContinue = false;
                } else {
                    if (isContinue && progresses[i] >= 100) {
                        progressQueue.poll();
                    } else {
                        isContinue = false;
                    }
                }
            }

            if (queueCnt != progressQueue.size()) {
                resultQueue.add(queueCnt - progressQueue.size());
            }

            if (progressQueue.size() < 1) {
                isClear = true;
            }
        }

        answer = new int[resultQueue.size()];
        while (resultQueue.size() > 0) {
            answer[answer.length - resultQueue.size()] = (int) resultQueue.poll();
        }

        return answer;
    }

    public static int[] solution2(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> queue = new LinkedList();
        for (int progress: progresses) {
            queue.add(progress);
        }

        Queue<Integer> resultQueue = new LinkedList<>();

        while (queue.size() > 0) {
            boolean isCompleted = false;
            int queueSize = queue.size();
            int startIdx = progresses.length - queue.size();
            for (int i = startIdx; i < progresses.length; i++) {
                progresses[i] += speeds[i];
                if (i == startIdx && progresses[i] >= 100) {
                    isCompleted = true;
                    queue.poll();
                } else if (isCompleted && progresses[i] >= 100) {
                    queue.poll();
                } else {
                    isCompleted = false;
                }
            }

            if (queueSize != queue.size()) {
                resultQueue.add(queueSize - queue.size());
            }
        }

        answer = new int[resultQueue.size()];
        while (resultQueue.size() > 0) {
            answer[answer.length - resultQueue.size()] = (int) resultQueue.poll();
        }
        return answer;
    }


}
