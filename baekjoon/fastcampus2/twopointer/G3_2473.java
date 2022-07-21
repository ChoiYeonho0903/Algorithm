package baekjoon.fastcampus2.twopointer;

import java.io.*;
import java.util.*;

public class G3_2473 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] arr;
    static int[] ans = new int[3];
    static long min = 3_000_000_000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, 1, N+1);

        for(int i = 1; i <= N; i++) {
            twoPointer(i);
        }
        Arrays.sort(ans);
        for(int i = 0; i < 3; i++) {
            sb.append(ans[i]).append(" ");
        }
        System.out.println(sb);
    }

    static void twoPointer(int index) {
        int L = 1;
        int R = N;
        int X = arr[index];
        while(L < R) {
            if(L == index) {
                L++;
                continue;
            }
            if(R == index) {
                R--;
                continue;
            }

            if(min > Math.abs((long) arr[L] + arr[R] + X)) {
                min = Math.abs((long) arr[L] + arr[R] + X);
                ans[0] = arr[L];
                ans[1] = arr[R];
                ans[2] = arr[index];
            }

            if((long) arr[L] + arr[R] + X < 0) {
                L++;
            } else {
                R--;
            }
        }
    }
}