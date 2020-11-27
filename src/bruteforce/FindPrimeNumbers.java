package bruteforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPrimeNumbers {

    public static void main(String[] args) {


        /*
        한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
        각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지
        return 하도록 solution 함수를 완성해주세요.

        제한사항
        numbers는 길이 1 이상 7 이하인 문자열입니다.
        numbers는 0~9까지 숫자만으로 이루어져 있습니다.
        013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
        입출력 예
        numbers	return
        17	3
        011	2
        입출력 예 설명
        예제 #1
        [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

        예제 #2
        [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.

        11과 011은 같은 숫자로 취급합니다.
         */
        String numbers = "17";
        int reuslt = solution(numbers);
        System.out.println("########## result: " + reuslt);
    }

    private static int solution(String numbers) {
        int answer = 0;
        List<Integer[]> results = new ArrayList();
        int[] arrNumbers = numbers.chars().map(x -> x - '0').toArray();
        for (int i = 1; i < numbers.length(); i++) {
            results.addAll(permutation(0, arrNumbers, new Integer[i], new boolean[i], results));
        }

        for (Integer[] result : results) {
            System.out.println(Arrays.toString(result));
        }

        return answer;
    }

    private static List<Integer[]> permutation(int currentDepth, int[] numbers, Integer[] temp, boolean[] visited, List<Integer[]> results) {
        if (currentDepth == temp.length) {
            results.add(temp);
            return results;
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            if (!visited[i]) {
                temp[currentDepth] = numbers[i];
                visited[i] = true;
                results.addAll(permutation(++currentDepth, numbers, temp, visited, results));
            }
        }

        return results;
    }
}
