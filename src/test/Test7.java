package test;

public class Test7 {
    public static void main(String[] args) {
        System.out.println("###################### result: " + getLongestLength(new int[]{3, 2, 3, 2, 3}));
        System.out.println("###################### result: " + getLongestLength(new int[]{7, 4, -2, 4, -2, -9}));
        System.out.println("###################### result: " + getLongestLength(new int[]{7, -5, -5, -5, 7, -1, 7}));
        System.out.println("###################### result: " + getLongestLength(new int[]{7, -1, -5, -5, 7, -5, 7}));
        System.out.println("###################### result: " + getLongestLength(new int[]{4, 3, 1, 5}));
        System.out.println("###################### result: " + getLongestLength(new int[]{4, 3, 1, 5, 1, 2, 1, 2, 1}));
    }

    private static int getLongestLength(int[] A) {

        int result = 2;
        if (A.length <= 2) {
            return A.length;
        }

        int[] arrTemp = new int[2];
        arrTemp[0] = A[0];
        arrTemp[1] = A[1];
        int temp = 2;
        int skip = 0;
        for (int i = 2; i < A.length; i++) {
            if (skip > 0) {
                skip--;
                if (arrTemp[i % 2] == A[i]) {
                    temp++;
                }

                arrTemp[i % 2] = A[i];
                continue;
            }

            if (arrTemp[i % 2] == A[i]) {
                temp++;
                if (result < temp) {
                    result = temp;
                }
            } else {
                arrTemp[i % 2] = A[i];
                skip = 1;
                temp = 2;
            }
        }

        return result;
    }
}
