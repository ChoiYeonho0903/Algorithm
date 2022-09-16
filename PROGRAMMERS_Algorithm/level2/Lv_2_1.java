package PROGRAMMERS_Algorithm.level2;

import java.util.Arrays;

public class Lv_2_1 {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        int[] arr = new int[str.length];
        for(int i = 0; i < str.length; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(arr);
        answer += arr[0];
        answer += " ";
        answer += arr[arr.length-1];
        return answer;
    }
}
