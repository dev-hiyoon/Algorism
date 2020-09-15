package heap;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MoreSpicy {

    public static void main(String[] args) {
        // 섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        // [1, 2, 3, 9, 10, 12]	7	2
        int[] scoville = new int[]{1, 2, 3};
        int K = 11;
        int result = solution(scoville, K);
        System.out.println(result);
    }

    public static int solution(int[] scoville, int K) {
//        int answer = 0;
//        int idx = 0;
//        Arrays.sort(scoville);
//
//        while (true) {
//            if (scoville.length < 2) {
//                answer = -1;
//                break;
//            }
//
//            int newScoville = scoville[0] + scoville[1] * 2;
//            answer++;
//            if (newScoville >= K && scoville[2] >= K) {
//                break;
//            } else {
//
//                if (newScoville <= K) {
//                    scoville[0] = newScoville;
//                    for (int i = 2; i < scoville.length; i++) {
//                        scoville[i - 1] = scoville[i];
//                    }
//
//                    scoville[scoville.length - 1] = Integer.MAX_VALUE;
//                } else {
//                    for (int i = 2; i < scoville.length; i++) {
//                        scoville[i - 2] = scoville[i];
//                    }
//
//                    scoville[scoville.length - 2] = newScoville;
//                    scoville[scoville.length - 1] = Integer.MAX_VALUE;
//                }
//
//                Arrays.sort(scoville);
//            }
//        }
//
//        return answer;





        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }

        while (true) {
            if (queue.size() < 2) {
                answer = -1;
                break;
            }

            int newScoville = queue.poll() + (queue.poll() * 2);
            answer++;

            if (queue.size() < 1) {
                if (newScoville < K) {
                    answer = -1;
                    break;
                } else {
                    break;
                }
            } else if (newScoville >= K && queue.peek().intValue() >= K) {
                break;
            } else {
                queue.add(newScoville);
            }
        }

        return answer;
    }
}
