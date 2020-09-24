package heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class DoublePriorityQueue {

    public static void main(String[] args) {
        // [I 16,D 1] -> [0,0]
        // [I 7,I 5,I -5,D -1] -> [7,5]
        // ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]
        String[] operations = new String[]{"I 1", "I 2", "I 3", "I 4", "I 5", "I 6", "I 7", "I 8", "I 9", "I 10", "D 1", "D -1", "D 1", "D -1", "I 1", "I 2", "I 3", "I 4", "I 5", "I 6", "I 7", "I 8", "I 9", "I 10", "D 1", "D -1", "D 1", "D -1"};
        int[] results = solution(operations);
        for (int result : results) {
            System.out.println(result);
        }
    }

    public static int[] solution(String[] operations) {
        int[] answer = new int[]{0, 0};
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < operations.length; i++) {
            String operation = operations[i];
            if (operation.contains("I")) {
                queue.add(Integer.valueOf(operation.split(" ")[1]));
            } else if (operation.contains("D")) {
                if (operation.split(" ")[1].equals("1")) {
                    if (queue.size() > 1) {
                        Object[] result = queue.toArray();
                        Arrays.sort(result);
                        queue.clear();
                        for (int j = 0; j < result.length - 1; j++) {
                            queue.add((int) result[j]);
                        }
                    } else {
                        queue.poll();
                    }
                } else {
                    queue.poll();
                }
            }
        }

        if (!queue.isEmpty()) {
            Object[] result = queue.toArray();
            Arrays.sort(result);
            answer = new int[]{(int) result[result.length - 1], (int) result[0]};
        }

        return answer;
    }


}
