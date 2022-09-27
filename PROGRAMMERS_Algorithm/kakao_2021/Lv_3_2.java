package PROGRAMMERS_Algorithm.kakao_2021;

public class Lv_3_2 {
    int[] logsStartSec;
    int[] logsEndSec;
    int playTimeSec;
    int advTimeSec;

    public String solution(String play_time, String adv_time, String[] logs) {
        logsStartSec = new int[logs.length];
        logsEndSec = new int[logs.length];

        // 주어진 문자열 시간을 정수 Sec로 전환
        playTimeSec = strToInt(play_time);
        advTimeSec = strToInt(adv_time);
        for(int i = 0; i < logs.length; i++) {
            String[] str = logs[i].split("-");
            logsStartSec[i] = strToInt(str[0]);
            logsEndSec[i] = strToInt(str[1]);
        }

        int[] timeSec = new int[playTimeSec+2];
        for(int i = 0; i < logs.length; i++) {
            timeSec[logsStartSec[i]]++;
            timeSec[logsEndSec[i]]--;
        }
        for(int i = 1; i < playTimeSec; i++) {
            timeSec[i] += timeSec[i-1];
        }

        int answer = twoPointer(timeSec);
        return intToStr(answer);
    }

    public int twoPointer(int[] timeSec) {
        long maxTotal = 0;
        long sum = 0;
        int maxTime = 0;
        int R = -1;
        for(int L = 0; L < playTimeSec-advTimeSec+1; L++) {
            if(L != 0) {
                sum -= timeSec[L-1];
            }

            while(R+1-L < advTimeSec && R+1 < playTimeSec) {
                R++;
                sum += timeSec[R];
            }

            if(sum > maxTotal) {
                maxTotal = sum;
                maxTime = L;
            }
        }
        return maxTime;
    }

    public int strToInt(String time) {
        int totalTime = 0;
        String[] str = time.split(":");
        totalTime += Integer.parseInt(str[0]) * 3600;
        totalTime += Integer.parseInt(str[1]) * 60;
        totalTime += Integer.parseInt(str[2]);
        return totalTime;
    }

    public String intToStr(int time) {
        StringBuilder sb = new StringBuilder();
        int tmp = time/3600;
        if(tmp < 10) {
            sb.append("0");
            sb.append(tmp);
        } else {
            sb.append(tmp);
        }
        sb.append(":");
        time %= 3600;
        tmp = time/60;
        if(tmp < 10) {
            sb.append("0");
            sb.append(tmp);
        } else {
            sb.append(tmp);
        }
        sb.append(":");
        time %= 60;
        if(time < 10) {
            sb.append("0");
            sb.append(time);
        } else {
            sb.append(time);
        }
        return sb.toString();
    }
}
