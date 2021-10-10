package PROGRAMMERS_Algorithm;

import java.util.ArrayList;

public class BF_2 {
    static String[] arr;
    static boolean[] visited;
    static int limit = 0;
    static ArrayList<String> arrayList = new ArrayList<>();
    static ArrayList<Integer> ans = new ArrayList<>();
    static String numbers = "011";
    public static void main(String[] args) {
        System.out.println(solution(numbers));
    }

    public static int solution(String numbers) {
        int answer = 0;
        arr = new String[numbers.length()];
        visited = new boolean[numbers.length()];
        for (int i = 0; i <numbers.length(); i++) {
            arrayList.add(numbers.substring(i, i+1));
        }
        for (int i = 1; i <=arrayList.size(); i++) {
            limit = i;
            backtracking(0);
        }
        answer = ans.size();
        return answer;
    }
    public static void backtracking(int k) {
        if(k == limit) {
            String str = "";
            int tmp = 0;
            for (int i = 0; i <limit; i++) {
                str += arr[i];
            }
            tmp = Integer.parseInt(str);
            if(!is_exist(tmp) && is_prime(tmp)) {
                ans.add(tmp);
            }
        }
        else {
            for (int i = 0; i <arrayList.size(); i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    arr[k] = arrayList.get(i);
                    backtracking(k+1);
                    visited[i] = false;
                }
            }
        }
    }
    public static boolean is_prime(int number) {
        if(number < 2) {
            return false;
        }
        if(number == 2) {
            return true;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if(number%i==0) {
                return false;
            }
        }
        return true;
    }

    public static boolean is_exist(int number) {
        for (Integer an : ans) {
            if(an == number) {
                return true;
            }
        }
        return false;
    }
}
