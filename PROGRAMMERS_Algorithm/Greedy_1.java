package PROGRAMMERS_Algorithm;

import java.util.*;

public class Greedy_1 {
    static int n = 5;
    static int[] lost = {2,4};
    static int[] reserve = {1, 3, 5};
    public static void main(String[] args) {
        System.out.println(solution(n, lost, reserve));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        Map<Integer, Integer> lostmap = new HashMap<>();
        Map<Integer, Integer> reservemap = new HashMap<>();
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for (int i = 0; i <lost.length; i++) {
            lostmap.put(lost[i], i);
        }
        for (int i = 0; i <reserve.length; i++) {
            reservemap.put(reserve[i], i);
        }

        for (int i = 0; i <lost.length; i++) {
            if(reservemap.containsKey(lost[i])) {
                reservemap.remove(lost[i]);
                lostmap.remove(lost[i]);
            }
        }
        for (int i = 1; i <=n; i++) {
            if(lostmap.containsKey(i)) {
                Iterator<Integer> iterator = reservemap.keySet().iterator();
                while (iterator.hasNext()) {
                    int tmp = iterator.next();
                    if(tmp == i-1 || tmp == i+1) {
                        iterator.remove();
                        answer++;
                        break;
                    }
                }
            }
            else
                answer++;
        }
        return answer;
    }
}
