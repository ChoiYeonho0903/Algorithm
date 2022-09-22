package PROGRAMMERS_Algorithm.kakao_2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lv_2_1 {
    String[] cOrders;
    List<String> list = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    int[] selected;

    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        cOrders = orders;
        for(int i = 0; i < course.length; i++) {
            for(int j = 0; j < orders.length; j++) {
                if(orders[j].length() < course[i]) continue;
                recursion("", orders[j], course[i], -1);
            }

            if(map.isEmpty()) continue;
            List<Integer> cntList = new ArrayList<>(map.values());
            int max = Collections.max(cntList);

            if(max <= 1) continue;
            for(String key : map.keySet()) {
                // System.out.println(key + " " + map.get(key));
                if(map.get(key) == max) {
                    list.add(key);
                }
            }
            map.clear();
        }

        Collections.sort(list);

        return list.stream().toArray(String[]::new);
    }

    public void recursion(String menu, String order, int len, int pre) {
        if(menu.length() == len) {
            char[] arr = menu.toCharArray();
            Arrays.sort(arr);
            menu = new String(arr);
            map.put(menu, map.getOrDefault(menu, 0) + 1);
        }
        for(int i = pre + 1; i < order.length(); i++) {
            recursion(menu+order.charAt(i), order, len, i);
        }
    }
}
