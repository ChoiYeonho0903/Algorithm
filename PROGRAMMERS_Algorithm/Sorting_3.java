package PROGRAMMERS_Algorithm;

import java.util.Arrays;
import java.util.Collections;


public class Sorting_3 {
    static int[] citations = {12,9,9,9};
    public static void main(String[] args) {
        System.out.println(solution(citations));
    }
    public static int solution(int[] citations) {
        int answer = 0;
        Integer[] tmp = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Collections.reverseOrder());
        int sta = tmp[0];
        if(tmp.length == 1)
            answer = tmp[0];
        else {
            for (int i = sta; i > 0; i--) {
                int num = tmp.length;
                for (int j = 0; j <tmp.length; j++) {
                    if (i==tmp[j]) {
                        num = j+1;
                        break;
                    }
                    else if (i>tmp[j]) {
                        num = j;
                        break;
                    }
                }
                if(i <= num) {
                    answer = i;
                    break;
                }
            }
        }
        return answer;
    }
}
