package PROGRAMMERS_Algorithm;

import java.util.Scanner;

public class Compression_kakao_2020 {
    static String s;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.next();
        System.out.println(solution(s));
    }
    private static int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <=s.length()/2; i++) {
            int compression = compression(i, s);
            answer = Math.min(answer, compression);
        }
        return answer;
    }

    private static int compression(int x, String s) {
        int count = 1;
        String comp = "";
        String current = "";
        String previous = "";
        for (int i = 0; i <=s.length()+x; i+=x) {
            //현재 문자열
            if(i >= s.length()) {
                current = "";
            }
            else if (i+x > s.length())
                current = s.substring(i);
            else
                current = s.substring(i, i+x);

            //이전 문자열과 같은지 확인
            if(i!=0) {
                if (previous.equals(current)) {
                    count++;
                }
                else if (count>=2) {
                    comp += count + previous;
                    count = 1;
                }
                else {
                    comp += previous;
                }
            }
            previous = current;
        }
        return comp.length();
    }
}
