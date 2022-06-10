package baekjoon.fastcampus.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_2512 {
    static int N;
    static int[] budget;
    static int totalBudget;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        budget = new int[N+1];
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for (int i = 1; i <=N; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
        }
        totalBudget = Integer.parseInt(br.readLine());
        Arrays.sort(budget, 1, N+1);
        binarySearch(1, budget[N]);
        System.out.println(ans);
    }

    static void binarySearch(int L, int R) {
        while (L <= R) {
            int mid = (L+R)/2;
            if(condition(mid)) {
                ans = mid;
                L = mid+1;
            } else {
                R = mid - 1;
            }
        }
    }

    static boolean condition(int x) {
        long sum = 0;
        for (int i = 1; i <=N; i++) {
            if(budget[i]-x < 0) {
                sum += budget[i];
            } else {
                sum += x;
            }
        }
        return totalBudget >= sum;
    }
}
