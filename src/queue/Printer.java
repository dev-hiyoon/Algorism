package queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    public static void main(String[] args) {

//        [2, 1, 3, 2]	2	1
//        [1, 1, 9, 1, 1, 1]	0	5
        int[] priorities = new int[]{2, 1, 3, 2};
        int location = 2;
        int result = solution(priorities, location);
        System.out.println(result);
    }

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        int curLocation = location;
        int[] sortPriorities = Arrays.copyOf(priorities, priorities.length);
        Arrays.sort(sortPriorities);
        int maxIdx = sortPriorities.length - 1;
        int maxVal = sortPriorities[maxIdx];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
        }

        while (true) {
            if (queue.peek().intValue() == maxVal && curLocation == 0) {
                answer++;
                break;
            } else if (queue.peek().intValue() == maxVal) {
                queue.poll();
                answer++;
                maxVal = sortPriorities[--maxIdx];
                if (curLocation > 0) {
                    curLocation--;
                } else {
                    curLocation = queue.size() - 1;
                }
            } else {
                int val = queue.poll().intValue();
                queue.add(val);
                if (curLocation > 0) {
                    curLocation--;
                } else {
                    curLocation = queue.size() - 1;
                }
            }
        }


        return answer;
    }
}
