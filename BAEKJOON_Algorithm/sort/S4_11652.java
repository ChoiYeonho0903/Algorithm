package BAEKJOON_Algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_11652 {
    static int N;
    static long[] card;
    static int maxCount;
    static long maxValue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        card = new long[N];
        for (int i = 0; i <N; i++) {
            card[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(card); //정렬

        int currentCount = 1;
        maxValue = card[0];
        for (int i = 1; i <N; i++) {
            if(card[i-1] != card[i]) {
                currentCount = 1;
            } else {
                currentCount++;
            }
            if(maxCount < currentCount) {
                maxValue = card[i-1];
                maxCount = currentCount;
            }
        }
        System.out.println(maxValue);
    }
}
