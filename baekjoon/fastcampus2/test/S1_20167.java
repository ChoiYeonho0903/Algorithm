package baekjoon.fastcampus2.test;

import java.util.*;
import java.io.*;

public class S1_20167 {
    static int N;
    static int K;
    static int[] arr;
    static long[] dp;
    static ArrayList<Interval>[] intervals;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        dp = new long[N+1];
        intervals = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            intervals[i] = new ArrayList<>();
        }
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        twoPointer();

        System.out.println(dp[N]);
    }

    public static void twoPointer() {
        long sum = 0;
        for(int L = 1, R = 0; L <= N; L++) {


            while(R+1 <= N && sum < K) {
                R++;
                sum += arr[R];
            }

            if(sum >= K) {
                Interval i = new Interval();
                i.left = L;
                i.satisfy = sum - K;
                intervals[R].add(i);
            }

            sum -= arr[L];
        }

        for(int R = 1; R <= N; R++) {
            dp[R] = dp[R-1];
            for(Interval i : intervals[R]) {
                dp[R] = Math.max(dp[R], dp[i.left-1] + i.satisfy);
            }
        }
    }

    static class Interval {
        int left;
        long satisfy;
    }
}