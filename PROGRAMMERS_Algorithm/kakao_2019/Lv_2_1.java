package PROGRAMMERS_Algorithm.kakao_2019;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Lv_2_1 {
    int N;
    int M;
    Set<String> used = new HashSet();
    int[] selected;
    int answer;
    public int solution(String[][] relation) {
        N = relation.length;
        M = relation[0].length;

        for(int len = 1; len <= M; len++) {
            selected = new int[len+1];
            dfs(1, len, relation, "");
        }

        return answer;
    }

    public void dfs(int depth, int len, String[][] relation, String select) {
        if(depth == len + 1) {
            String[] arr = new String[N];
            for(int i = 0; i < N; i++) {
                arr[i] = "";
            }
            for(int i = 1; i <= len; i++) {
                for(int j = 0; j < N; j++) {
                    arr[j] += relation[j][selected[i]-1];
                }
            }

            if(checkUnique(arr)) {
                answer++;
                used.add(select);
            }
            return;
        }

        for(int i = selected[depth-1] + 1; i <= M; i++) {
            String str = select + i;
            if(!checkMinimal(str)) continue;
            selected[depth] = i;
            dfs(depth+1, len, relation, str);
            selected[depth] = 0;
        }
    }

    public boolean checkUnique(String[] rel) {
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < rel.length; i++) {
            if(map.containsKey(rel[i])) {
                return false;
            }
            map.put(rel[i], 1);
        }

        return true;
    }

    public boolean checkMinimal (String str) {
        String[] arr = str.split("");
        for(String s : used) {
            int cnt = s.length();
            for(int i = 0; i < arr.length; i++) {
                if(s.contains(arr[i])) {
                    cnt--;
                }
            }
            if(cnt == 0) {
                return false;
            }
        }
        return true;
    }
}