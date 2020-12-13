package nf;

public class Test2 {

    public static void main(String[] args) {
        int[] A = {0, 1, 8, 8, 7};
        int result = solution(A);
        System.out.println(result);
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8

        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0 && A[i] / 10 == 0) {
                max = Math.max(max, A[i]);
            }
        }

        return max;
    }
}
