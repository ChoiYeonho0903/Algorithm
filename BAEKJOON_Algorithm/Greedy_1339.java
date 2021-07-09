package BAEKJOON_Algorithm;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Greedy_1339 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int [] alpa = new int[26];
        Integer [] alpa2 = new Integer[26];
        String [] str = new String[N];
        int squard=0;
        int ans =0;
        int num=9;
        for (int i = 0; i <N; i++) {
            str[i] = scan.next();
        }
        for (int i = 0; i <N; i++) {
            squard = (int)Math.pow(10, str[i].length());
            for (int j = 0; j <str[i].length(); j++) {
                squard /=10;
                alpa[str[i].charAt(j)-'A'] += squard;
            }
        }
        alpa2 = Arrays.stream(alpa).boxed().toArray(Integer[]::new);
        Arrays.sort(alpa2, Collections.reverseOrder());
        alpa = Arrays.stream(alpa2).mapToInt(Integer::intValue).toArray();
        for (int i = 0; i <10; i++) {
            ans += alpa[i] * num;
            num--;
        }
        System.out.println(ans);
    }
}
