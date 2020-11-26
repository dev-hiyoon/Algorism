package order;

import java.util.Arrays;

public class HIndex {

    public static void main(String[] args) {
        /*
        H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다.
        위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
        어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면
        h의 최댓값이 이 과학자의 H-Index입니다.
        어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return
        하도록 solution 함수를 작성해주세요.

        제한사항
        과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
        논문별 인용 횟수는 0회 이상 10,000회 이하입니다.

        [3, 0, 6, 1, 5]	=> 3
        [12, 11, 10, 9, 8, 1] 5
        [6, 6, 6, 6, 6, 1] 5
        [4, 4, 4] 3
        [4, 4, 4, 5, 0, 1, 2, 3] 4
        [10, 11, 12, 13] 4
        [3, 0, 6, 1, 5] 3
        [0, 0, 1, 1] 1
        [0, 1] 1
        [10, 9, 4, 1, 1] 3
        이 과학자가 발표한 논문의 수는 5편이고, 그중 3편의 논문은 3회 이상 인용되었습니다.
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 그리고 나머지 2편의 논문은 3회 이하 인용되었기 때문에 이 과학자의 H-Index는 3입니다.
         */

        int[] array = new int[]{12, 11, 10, 9, 8, 1}; // 5
        int reuslt = solution(array);
        System.out.println(reuslt);
    }

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            for (int j = 0; j < citations.length; j++) {
                int minJ = 0;
                System.out.println(String.format("n번째%s, 체크: %s, 체크값: %s", i + 1, j + 1, citations[j]));
                if (i + 1 >= citations[j]
                        && i + 1 >= j + 1) {
                    minJ = j;
                }

                if (minJ + 1 <= i + 1
                        && i + 1 <= citations[j]
                        && i + 1 <= citations.length - j) {
                    System.out.println("############## insert");
                    answer = i + 1 > answer ? i + 1 : answer;
                }
            }
        }
        
        return answer;
    }
}