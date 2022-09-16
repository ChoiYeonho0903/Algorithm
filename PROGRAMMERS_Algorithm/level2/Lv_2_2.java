package PROGRAMMERS_Algorithm.level2;

public class Lv_2_2 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        s = s.toLowerCase();
        String[] str = s.split(" ");

        String tmp = "sd mo ";
        String[] tmp2 = tmp.split(" ");
        System.out.println(tmp2.length);
        for(int i = 0; i < str.length; i++) {
            StringBuilder sb = new StringBuilder();
            if(str[i].equals("")) {
                answer.append(" ");
                continue;
            }
            char c = str[i].charAt(0);
            if(!Character.isDigit(c)) {
                c = (char) (c-'a'+'A');
            }
            sb.append(c);
            sb.append(str[i].substring(1, str[i].length()));

            answer.append(sb.toString());
            if(i != str.length-1) {
                answer.append(" ");
            }
        }

        if(s.charAt(s.length()-1) == ' ') {
            answer.append(" ");
        }
        return answer.toString();
    }
}
