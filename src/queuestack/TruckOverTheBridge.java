package queuestack;

import java.util.LinkedList;
import java.util.Queue;

public class TruckOverTheBridge {

    public static void main(String[] args) {

        //
        // case1. 2	    10	[7,4,5,6]	                    8
        // case2. 100	100	[10]	                        101
        // case3. 100	100	[10,10,10,10,10,10,10,10,10,10]	110

        int bridge_length = 3;
        int weight = 10;
        int[] truck_weights = new int[]{5, 5, 3, 5, 5};
        int result = solution(bridge_length, weight, truck_weights);
        System.out.println(result);
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int curWeight = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < bridge_length; i++) {
            queue.add(0);
        }

        for (int i = 0; i < truck_weights.length; i++) {
            if (curWeight + truck_weights[i] <= weight) {
                curWeight -= queue.poll().intValue();
                answer++;
                queue.add(truck_weights[i]);
                curWeight += truck_weights[i];
            } else {
                while (curWeight + truck_weights[i] > weight) {
                    curWeight -= queue.poll().intValue();
                    answer++;
                }

                int cnt = bridge_length - queue.size() - 1;
                for (int j = 0; j < cnt; j++) {
                    queue.add(0);
                }

                curWeight += truck_weights[i];
                queue.add(truck_weights[i]);
            }

            if (i == truck_weights.length - 1) {
                answer += bridge_length;
                break;
            }
        }

        return answer;
    }
}
