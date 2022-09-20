package PROGRAMMERS_Algorithm.kakao_2020;

public class Lv_2_1 {
    public int solution(String s) {
        int answer = s.length();

        for(int len = 1; len <= s.length(); len++) {
            String str = compression(s, len);
            answer = Math.min(answer, str.length());
        }

        return answer;
    }

    public String compression (String s, int len) {
        StringBuilder sb = new StringBuilder();
        String prev = s.substring(0, len);
        String cur = s.substring(0, len);
        int cnt = 1;
        int i;
        for(i = len; i <= s.length() - len; i += len) {
            cur = s.substring(i, i+len);
            if(prev.equals(cur)) {
                cnt++;
            } else {
                if(cnt != 1) {
                    sb.append(cnt);
                }
                sb.append(prev);
                prev = cur;
                cnt = 1;
            }
        }
        if(cnt > 1) {
            sb.append(cnt);
        }
        sb.append(cur);
        sb.append(s.substring(i, s.length()));
        return sb.toString();
    }
}
