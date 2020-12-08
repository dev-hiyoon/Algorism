package bruteforce;

import java.util.Arrays;
import java.util.HashSet;

public class FindPrimeNumbers {

    /**
     * 소수 찾기
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 문제 설명
         * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
         *
         * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록
         * solution 함수를 완성해주세요.
         *
         * 제한사항
         * numbers는 길이 1 이상 7 이하인 문자열입니다.
         * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
         * 013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
         * 입출력 예
         * numbers	return
         * 17	3
         * 011	2
         * 입출력 예 설명
         * 예제 #1
         * [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
         *
         * 예제 #2
         * [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
         *
         * 11과 011은 같은 숫자로 취급합니다.
         */
        String numbers = "3";
        int reuslt = solution(numbers);
        System.out.println("########## result: " + reuslt);
    }

    private static HashSet<Integer> hashSet = new HashSet<>();

    public static int solution(String numbers) {
        int answer = 0;
        int[] arrNumbers = numbers.chars().map(x -> x - '0').toArray();
        for (int i = 0; i < arrNumbers.length; i++) {
            permutation(0, arrNumbers, new boolean[arrNumbers.length], new int[i + 1]);
        }

        int cnt = 0;
        for (Integer value : hashSet) {
            System.out.println("########## value: " + value);
            boolean checked = true;
            if (value >= 2) {
                for (int i = 2; i < value; i++) {
                    if (value % i == 0) {
                        checked = false;
                        break;
                    }
                }
            } else {
                checked = false;
            }

            if (checked) {
                cnt++;
            }

        }

        return cnt;
    }

    private static void permutation(int currentDepth, int[] numbers, boolean[] visited, int[] results) {
        if (currentDepth == results.length) {
            int value = Integer.valueOf(Arrays.toString(results).replaceAll("\\[|\\]|,|\\s", ""));
            hashSet.add(value);
            return;
        }

        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                results[currentDepth] = numbers[i];
                permutation(currentDepth + 1, numbers, visited, results);
                visited[i] = false;
            }
        }
    }


//    private static int solution(String numbers) {
//        int answer = 0;
//        HashSet<Integer> hashSet = new HashSet<>();
//        int[] arrNumbers = numbers.chars().map(x -> x - '0').toArray();
//        for (int i = 0; i < numbers.length(); i++) {
//            permutation(0, arrNumbers, new Integer[i + 1], new boolean[numbers.length()], hashSet);
//        }
//
//        for (Integer value : hashSet) {
//            boolean isPermutation = true;
//            if (value < 2) {
//                isPermutation = false;
//            } else {
//                for (int i = 0; i < value; i++) {
//                    if (i >= 2 && value % i == 0) {
//                        isPermutation = false;
//                    }
//                }
//            }
//
//            if (isPermutation) {
//                answer++;
//            }
//        }
//
//        return answer;
//    }
//
//        private static void permutation(int currentDepth, int[] numbers, Integer[] temp, boolean[] visited, HashSet<Integer> hashSet) {
//        if (currentDepth == temp.length) {
//            int value = Integer.valueOf(Arrays.toString(temp).replaceAll("\\[|\\]|,|\\s", ""));
//            System.out.println("######## " + value);
//            hashSet.add(value);
//            return;
//        }
//
//        for (int i = 0; i < numbers.length; i++) {
////            if (!visited[i]) {
//                temp[currentDepth] = numbers[i];
//                visited[i] = true;
//                permutation(currentDepth + 1, numbers, temp, visited, hashSet);
//                visited[i] = false;
////            }
//        }
//    }
}
