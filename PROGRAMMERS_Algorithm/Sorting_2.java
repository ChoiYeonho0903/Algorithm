package PROGRAMMERS_Algorithm;

import java.util.*;

public class Sorting_2 {
    static int [] numbers = {3, 30, 34, 5, 9};
    public static void main(String[] args) {
        String answer = "";
        answer = solution(numbers);
        System.out.println(answer);
    }

    public static String solution(int[] numbers) {
        String answer = "";
        String [] num = new String[numbers.length];
        for (int i = 0; i <numbers.length; i++) {
            num[i] = Integer.toString(numbers[i]);
        }
        Arrays.sort(num, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return ((o2 + o1).compareTo(o1 + o2));
            }
        });
        if (num[0].equals("0"))
            return "0";
        else {
            for (int i = 0; i < num.length; i++) {
                answer += num[i];
            }
        }
        return answer;
    }
}
