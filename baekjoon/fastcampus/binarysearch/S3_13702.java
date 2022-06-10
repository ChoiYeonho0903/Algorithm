package baekjoon.fastcampus.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_13702 {
    static int N;
    static int K;
    static int[] drink;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str= br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        drink = new int[N+1];
        for (int i = 1; i <=N; i++) {
            drink[i] = Integer.parseInt(br.readLine());
        }
        binarySearch();
        System.out.println(ans);
    }

    static void binarySearch() {
        long L = 0;
        long R = Integer.MAX_VALUE;
        while (L <= R) {
            long mid = (L+R)/2;
            if(condition(mid)) {
                ans = (int) mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
    }

    static boolean condition (long x) {
        int count = 0;
        for (int i = 1; i <=N; i++) {
            count += (drink[i]/x);
        }
        return count >= K;
    }
}
