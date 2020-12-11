package queuestack;

public class StockPrice {

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 2, 3};
        int[] results = solution(prices); // {4, 3, 1, 1, 0}
        for (int result : results) {
            System.out.println(result);
        }
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i] += 1;
                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }

        return answer;
    }

}
