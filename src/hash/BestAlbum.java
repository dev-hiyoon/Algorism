package hash;

import java.util.*;
import java.util.stream.Collectors;

public class BestAlbum {

    public static void main(String[] args) {
        String[] genres = new String[] { "classic", "pop", "classic", "classic", "pop", "classic", "classic", "classic", "classic" };
        int[] plays = new int[] { 800, 600, 150, 800, 2500, 800, 800, 800, 800 };

        // 장르 별, 최대 2개씩 [4, 1, 3, 0]
        int[] result = solution(genres, plays);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String, Map<Integer, Integer>> sortedAll = new HashMap<>();
        Map<String, Integer> sumMap = new HashMap<>();
        for (int i = 0; i < plays.length; i++) {
            sumMap.put(genres[i], sumMap.getOrDefault(genres[i], 0) + plays[i]);
            Map tempMap = sortedAll.getOrDefault(genres[i], new TreeMap<>());
            tempMap.put(i, plays[i]);
            sortedAll.put(genres[i], tempMap);
        }

        Map<String, Integer> sortedMap = sumMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        int cnt = 0;
        List<Integer> result = new ArrayList<Integer>();
        for (String genre : sortedMap.keySet()) {
            cnt = 0;
            Map<Integer, Integer> map = sortedAll.get(genre).entrySet().stream()
                    .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

            for (int idx : map.keySet()) {
                if (cnt <= 1) {
                    result.add(idx);
                    cnt++;
                }
            }
        }

        answer = result.stream().mapToInt(i->i).toArray();
        return answer;
    }
}
