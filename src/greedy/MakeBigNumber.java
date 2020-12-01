package greedy;

import java.util.Arrays;
import java.util.HashSet;

public class MakeBigNumber {

    /**
     * 큰 수 만들기
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 문제 설명
         * 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
         *
         * 예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다. 이 중 가장 큰 숫자는 94 입니다.
         *
         * 문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다. number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록 solution 함수를 완성하세요.
         *
         * 제한 조건
         * number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
         * k는 1 이상 number의 자릿수 미만인 자연수입니다.
         * 입출력 예
         * number	    k	    return
         * 1924	        2	    94
         * 1231234	    3	    3234
         * 4177252841	4	    775841
         *
         */

        String number = "87654321";
        int k = 3;
        String result = solution(number, k);
        System.out.println(result);
    }

    public static String solution(String number, int k) {
        String answer = "";
        int[] arrNumbers = number.chars().map(x -> x - '0').toArray();
        int[] temp = new int[number.length() - k];
        HashSet<Integer> results = new HashSet<>();
        getMax(0, 0, temp, arrNumbers, results);

        int max = 0;
        for (Integer value : results) {
            max = max < value ? value : max;
        }
        
        return String.valueOf(max);
    }

    public static void getMax(int depth, int start, int[] temp, int[] arrNumbers, HashSet<Integer> results) {
        if (depth == temp.length) {
            String value = Arrays.toString(temp).replaceAll("\\[|\\]|,|\\s", "");
            if (value != null && !value.equals("")) {
                results.add(Integer.valueOf(Arrays.toString(temp).replaceAll("\\[|\\]|,|\\s", "")));
            }
            return;
        }

        for (int i = start; i < arrNumbers.length; i++) {
                temp[depth] = arrNumbers[i];
                getMax(depth + 1, i + 1, temp, arrNumbers, results);
        }
    }
}
