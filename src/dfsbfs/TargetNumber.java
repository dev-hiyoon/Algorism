package dfsbfs;

import java.util.Arrays;

public class TargetNumber {
    public static void main(String[] args) {

        /**
         * 문제 설명
         * n개의 음이 아닌 정수가 있습니다. 이 수를 적절히 더하거나 빼서 타겟 넘버를 만들려고 합니다.
         * 예를 들어 [1, 1, 1, 1, 1]로 숫자 3을 만들려면 다음 다섯 방법을 쓸 수 있습니다.
         *
         * -1+1+1+1+1 = 3
         * +1-1+1+1+1 = 3
         * +1+1-1+1+1 = 3
         * +1+1+1-1+1 = 3
         * +1+1+1+1-1 = 3
         * 사용할 수 있는 숫자가 담긴 배열 numbers, 타겟 넘버 target이 매개변수로 주어질 때 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는
         * 방법의 수를 return 하도록 solution 함수를 작성해주세요.
         *
         * 제한사항
         * 주어지는 숫자의 개수는 2개 이상 20개 이하입니다.
         * 각 숫자는 1 이상 50 이하인 자연수입니다.
         * 타겟 넘버는 1 이상 1000 이하인 자연수입니다.
         * 입출력 예
         * numbers	        target	return
         * [1, 1, 1, 1, 1]	3	    5
         * 입출력 예 설명
         * 문제에 나온 예와 같습니다.
         */

        int[] numbers = new int[] {1, 2, 3, 4, 5};
        int target = 3;
        int result = solution(numbers, target);
        System.out.println(result);
    }

    private static int cnt = 0;

    private static int solution(int[] numbers, int target) {
        int answer = 0;
        for (int i = 0; i < numbers.length; i++) {
            combination(numbers, i + 1, 0, new boolean[numbers.length], target);
        }

        return cnt;
    }

    private static void combination(int[] nums, int r, int start, boolean[] visit, int target) {
        if (r == 0) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (visit[i]) {
                    sum -= nums[i];
                } else {
                    sum += nums[i];
                }
            }

            if (sum == target) {
                cnt++;
            }

            return;
        }

        for (int i = start; i < nums.length; i++) {
            visit[i] = true;
            combination(nums, r - 1, i + 1, visit, target);
            visit[i] = false;
        }
    }
}
