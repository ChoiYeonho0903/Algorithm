package baekjoon.fastcampus2.twopointer;

import java.util.*;
import java.io.*;

public class G5_2470 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] arr;
    static int min = Integer.MAX_VALUE;

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
        twoPointer();
        System.out.println(sb);
    }

    static void twoPointer() {
        int R = N;
        int L = 1;
        int l = 0;
        int r = 0;
        while(L < R) {
            int sum = arr[L] + arr[R];

            if(min > Math.abs(sum)) {
                l = arr[L];
                r = arr[R];
                min = Math.abs(sum);
            }

            if(sum == 0) {
                break;
            } else if(sum < 0) {
                L++;
            } else {
                R--;
            }
        }
        sb.append(l).append(" ").append(r);
    }
}
