package baekjoon.fastcampus2.twopointer;

import java.io.*;
import java.util.*;

public class S1_15565 {
    static int N;
    static int K;
    static int[] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        twoPointer();
        if(min == Integer.MAX_VALUE) {
            min = -1;
        }
        System.out.println(min);
    }

    static void twoPointer() {
        int R = 0;
        int cnt = 0;
        for(int L = 1; L <= N; L++) {
            if(arr[L-1] == 1) {
                cnt--;
            }

            while(R+1 <= N && cnt < K) {
                R++;
                if(arr[R] == 1) {
                    cnt++;
                }
            }

            if(cnt >= K) {
                min = Math.min(min, R - L + 1);
            }
        }
    }
}
