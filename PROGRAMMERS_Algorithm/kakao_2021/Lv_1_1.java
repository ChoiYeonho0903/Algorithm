package PROGRAMMERS_Algorithm.kakao_2021;

public class Lv_1_1 {
    public String solution(String new_id) {
        String answer = "";
        return recommend(new_id);
    }

    public String recommend (String new_id) {
        StringBuilder sb;
        // 1단계
        new_id = new_id.toLowerCase();
        // 2단계
        sb = new StringBuilder();
        for(int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }
        new_id = sb.toString();
        // 3단계
        sb = new StringBuilder();
        int cnt = 0;
        for(int i = 0; i < new_id.length(); i++) {
            char c = new_id.charAt(i);
            if(c == '.') {
                cnt++;
            } else {
                if(cnt > 0) {
                    sb.append('.');
                    cnt = 0;
                }
                sb.append(c);
            }
        }
        if(cnt > 0) {
            sb.append('.');
        }
        new_id = sb.toString();
        // 4단계
        if(new_id.charAt(0) == '.') {
            if(new_id.length() == 1) {
                new_id = "";
            } else {
                new_id = new_id.substring(1, new_id.length());
            }
        }
        if(new_id.length() != 0 && new_id.charAt(new_id.length()-1) == '.') {
            if(new_id.length() == 1) {
                new_id = "";
            } else {
                new_id = new_id.substring(0, new_id.length()-1);
            }
        }

        // 5단계
        if(new_id.length() == 0) {
            new_id = "a";
        }
        // 6단계
        if(new_id.length() >= 16) {
            if(new_id.charAt(14) == '.') {
                new_id = new_id.substring(0, 14);
            } else {
                new_id = new_id.substring(0, 15);
            }
        }

        // 7단계
        sb = new StringBuilder();
        sb.append(new_id);
        if(new_id.length() <= 2) {
            char c = new_id.charAt(new_id.length()-1);
            for(int i = 0; i < 3 - new_id.length(); i++) {
                sb.append(c);
            }
        }
        new_id = sb.toString();
        System.out.println(new_id);
        return new_id;
    }
}
