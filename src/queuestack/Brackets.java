package queuestack;

import java.util.LinkedList;
import java.util.Queue;

public class Brackets {
    public static void main(String[] args) {
        /**
         * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:
         *
         * S is empty;
         * S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
         * S has the form "VW" where V and W are properly nested strings.
         * For example, the string "{[()()]}" is properly nested but "([)()]" is not.
         *
         * Write a function:         *
         * class Solution { public int solution(String S); }         *
         * that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.         *
         * For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function
         * should return 0, as explained above.
         *
         * Write an efficient algorithm for the following assumptions:
         *
         * N is an integer within the range [0..200,000];
         * string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
         */

        int result = solution("{[()()]}");
        System.out.println(result);
    }

    public static int solution(String S) {
        // write your code in Java SE 8
        if (S == null || S.equals("")) {
            return 1;
        }

        if (S.length() % 2 != 0) {
            return 0;
        }

        Queue<String> queue1 = new LinkedList<>();
        Queue<String> queue2 = new LinkedList<>();
        for (int i = 0; i < S.length(); i++) {
            if (i < S.length() / 2) {
                queue1.add(String.valueOf(S.charAt(i)));
            } else {
                queue2.add(String.valueOf(S.charAt(S.length() - (i - S.length() / 2) - 1)));
            }
        }

        int result = 1;
        for (int i = 0; i < S.length() / 2; i++) {
            String s1 = queue1.poll();
            String s2 = queue2.poll();
            if (!getPair(s1).equals(s2)) {
                String s3 = queue1.poll();
                String s4 = queue2.poll();
                if (!getPair(s1).equals(s3) || !getPair(s2).equals(s4)) {
                    result = 0;
                    break;
                }
            }
        }

        return result;
    }

    private static String getPair(String s) {
        String[] arr1 = {"(", "{", "["};
        String[] arr2 = {")", "}", "]"};
        for (int i = 0; i < arr1.length; i++) {
            if (s.equals(arr1[i])) {
                return arr2[i];
            } else if (s.equals(arr2[i])) {
                return arr1[i];
            }
        }

        return null;
    }
}
