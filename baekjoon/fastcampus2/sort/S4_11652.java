package baekjoon.fastcampus2.sort;

import java.util.*;
import java.io.*;

public class S4_11652 {
    static int N;
    static long[] arr;
    static int currentCount;
    static int maxCount;
    static long maxValue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new long[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        currentCount = 1;
        maxValue = arr[0];
        for(int i = 1; i < N; i++) {
            if(arr[i-1] == arr[i]) {
                currentCount++;
            } else {
                currentCount = 1;
            }

            if(maxCount < currentCount) {
                maxCount = currentCount;
                maxValue = arr[i-1];
            }
        }

        System.out.println(maxValue);
    }
}
