package dynamicprograming;

public class FibonacciSequence {

    private static int[] arr;

    public static void main(String[] args) {
        int n = 100000;
        int result = solution(n);
        System.out.println(result);
    }

    public static int solution(int n) {
        arr = new int[n + 1];
        int answer = 0;
        for (int i = 0; i <= n; i++) {
            calculate(i);
        }

        return calculate(n);
    }

    private static int calculate(int n) {
        if (n == 0) {
            return arr[0] = 0;
        } else if (n == 1) {
            return arr[1] = 1;
        }

        if (arr[n] == 0) {
            arr[n] = (arr[n - 1] + arr[n - 2]) % 1234567;
        }

        return arr[n];
    }
}