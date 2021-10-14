package PROGRAMMERS_Algorithm;

import java.util.HashMap;
import java.util.Map;

public class Hash_3 {
    static String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"}, {"green_turban", "headgear"}};
    public static void main(String[] args) {
        System.out.println(solution(clothes));
    }

    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <clothes.length; i++) {
            String key = clothes[i][1];
            if(map.containsKey(key)) {
                map.put(key, map.get(key)+1);
            }
            else {
                map.put(key, 1);
            }
        }
        for (String key : map.keySet()) {
            answer *= (map.get(key)+1);
        }
        return answer-1;
    }


}
