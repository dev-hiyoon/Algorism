package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FarthestNode {

    public static void main(String[] args) {

        int n = 6;
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int result = solution(n, edge);
        System.out.println(result);
    }

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] visit = new boolean[n + 1];
        boolean[][] connect = new boolean[n + 1][n + 1];
        for (int i = 0; i < edge.length; i++) {
            connect[edge[i][0]][edge[i][1]] = connect[edge[i][1]][edge[i][0]] = true;
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> nextNodes = new ArrayList<>();
        queue.add(1);
        visit[0] = visit[1] = true;
        while (true) {
            answer = queue.size();
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int j = 1; j <= n; j++) {
                    if (!visit[j] && connect[node][j]) {
                        nextNodes.add(j);
                        visit[j] = true;
                    }
                }
            }
            if (nextNodes.isEmpty()) {
                break;
            }
            queue.addAll(nextNodes);
            nextNodes.clear();
        }
        return answer;
    }
}