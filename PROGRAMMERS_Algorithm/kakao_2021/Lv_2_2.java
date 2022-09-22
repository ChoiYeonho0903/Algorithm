package PROGRAMMERS_Algorithm.kakao_2021;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lv_2_2 {
    Map<String, ArrayList<Integer>> map = new HashMap<>();
    int[] result;

    public int[] solution(String[] info, String[] query) {
        result = new int[query.length];

        // 1. Info 모든 경우의 수 map에 저장
        for(int i = 0; i < info.length; i++) {
            String[] arr = info[i].split(" ");
            recursion("", arr, 0);
        }

        // 2. map에 저장된 점수 list 오른차순으로 정렬
        List<String> list = new ArrayList<>(map.keySet());
        for(int i = 0; i < list.size(); i++) {
            List<Integer> scoreList = map.get(list.get(i));
            Collections.sort(scoreList);
        }

        for(int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] arr = query[i].split(" ");
            int score = Integer.parseInt(arr[1]);

            int idx = binarySearch(arr[0], score);
            result[i] = idx;
        }

        return result;
    }

    public int binarySearch(String str, int score) {
        if(!map.containsKey(str)) return 0;
        List<Integer> list = map.get(str);
        // for(int i : list) {
        //     System.out.println(i);
        // }
        // System.out.println();
        int L = 0;
        int R = list.size()-1;
        int result = -1;
        while(L <= R) {
            int mid = (L+R)/2;
            if(list.get(mid) < score) {
                L = mid+1;
                result = mid;
            } else {
                R = mid-1;
            }
        }
        return list.size() - (result + 1);
    }

    public void recursion(String str, String[] arr, int depth) {
        if(depth == 4) {
            if(map.containsKey(str)) {
                map.get(str).add(Integer.parseInt(arr[4]));
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(arr[4]));
                map.put(str, list);
            }
            return;
        }
        recursion(str+"-", arr, depth+1);
        recursion(str+arr[depth], arr, depth+1);
    }
}
