package PROGRAMMERS_Algorithm;

import java.util.Arrays;

public class BF_3 {
    static int brown = 8;
    static int yellow = 1;
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(brown, yellow)));
    }
    public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        for (int i = 3; i <=Math.sqrt(total); i++) {
            if(total % i == 0) {
                if(((total/i)-2) * (i-2) == yellow) {
                    answer[0]=total/i;
                    answer[1]=i;
                    break;
                }
            }
        }
        return answer;
    }
}
