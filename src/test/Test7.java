package test;

public class Test7 {
    public static void main(String[] args) {
        System.out.println("###################### result: " + getLongestLength(new int[]{3, 2, 3, 2, 3}));
        System.out.println("###################### result: " + getLongestLength(new int[]{7, 4, -2, 4, -2, -9}));
        System.out.println("###################### result: " + getLongestLength(new int[]{7, -5, -5, -5, 7, -1, 7}));
    }

    private static int getLongestLength(int[] N) {

        int result = 0;
        if (N.length <= 2) {
            return N.length;
        }

        int[] arrTemp = new int[2];
        arrTemp[0] = N[0];
        arrTemp[1] = N[1];
        int temp = 2;
        int skip = 0;
        for (int i = 2; i < N.length; i++) {
            if (skip > 0) {
                skip--;
                if (arrTemp[i % 2] == N[i]) {
                    temp++;
                }

                arrTemp[i % 2] = N[i];
                continue;
            }

            if (arrTemp[i % 2] == N[i]) {
                temp++;
                if (result < temp) {
                    result = temp;
                }
            } else {
                arrTemp[i % 2] = N[i];
                skip = 1;
                temp = 2;
            }
        }

        return result;
    }
}
