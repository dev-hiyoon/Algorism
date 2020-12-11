package queuestack;

import java.util.LinkedList;
import java.util.Locale;

public class LRU {
    public static void main(String[] args) {

    }

    public int solution(int cacheSize, String[] cities) {
        int cache_hit = 1;
        int cache_miss = 5;
        if (cacheSize == 0) {
            return cache_miss * cities.length;
        }

        int answer = 0;
        LinkedList<String> cache = new LinkedList();

        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toLowerCase(Locale.ROOT);
            if (cache.remove(city)) {
                cache.addFirst(city);
                answer += cache_hit;
            } else {
                if (cache.size() == cacheSize) {
                    cache.pollLast();
                }

                cache.addFirst(city);
                answer += cache_miss;
            }
        }

        return answer;
    }
}
