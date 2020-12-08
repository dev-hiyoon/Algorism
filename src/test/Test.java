package test;

public class Test {
    public static void main(String[] args) {
        for (int i = 1; i < 20; i++) {
            String result = solution(i);
            System.out.println("10진수: " + i + ", 3진수: " + result);
        }
    }

    public static String solution(int n) {
        String answer = "";
        int[] array = {1, 2, 4};
        int[] rArray = {4, 1, 2};
        StringBuilder builder = new StringBuilder();
        int q = n;
        builder.insert(0, rArray[q % 3]);
        q = (q - 1) / 3;
        while (q > 0) {
            builder.insert(0, rArray[q % 3]);
            if (q < 3) {
                break;
            }

            q /= 3;
        }

        return builder.toString();
    }
}
