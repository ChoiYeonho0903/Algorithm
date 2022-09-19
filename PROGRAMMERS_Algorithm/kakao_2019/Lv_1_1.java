package PROGRAMMERS_Algorithm.kakao_2019;

import java.util.*;

public class Lv_1_1 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] cnt = new int[N+1];
        int[] challenge = new int[N+1];
        ArrayList<ErrorRate> list = new ArrayList<>();

        for(int i = 0; i < stages.length; i++) {
            if(stages[i] == N+1) {
                continue;
            }
            cnt[stages[i]]++;
        }

        challenge[0] = stages.length;
        for(int i = 1; i <= N; i++) {
            challenge[i] = challenge[i-1] - cnt[i-1];
            if(challenge[i] == 0 || cnt[i] == 0) {
                list.add(new ErrorRate(i, 0.0));
                continue;
            }
            double rate = (double) cnt[i] / challenge[i];
            list.add(new ErrorRate(i, rate));
        }

        Collections.sort(list);

        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).idx;
        }

        return answer;
    }

    class ErrorRate implements Comparable<ErrorRate> {
        int idx;
        double rate;

        public ErrorRate (int idx, double rate) {
            this.idx = idx;
            this.rate = rate;
        }

        public int compareTo(ErrorRate e) {
            return Double.compare(e.rate, this.rate);
        }
    }
}
