package order;

public class KthNumber {

    public static void main(String[] args) {
        // [1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
        int[] array = new int[]{0, 4};
        int[][] commands = new int[][]{{0, 4}};
        int[] results = solution(array, commands);
        for (int result : results) {
            System.out.println(result);
        }
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        return answer;
    }
}
