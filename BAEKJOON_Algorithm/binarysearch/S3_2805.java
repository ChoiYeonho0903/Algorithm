package BAEKJOON_Algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_2805 {
    static int N;
    static int M;
    static int[] tree;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        tree = new int[N+1];
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for (int i = 1; i <= N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(tree);
        binarySearch();
        System.out.println(ans);
    }

    static void binarySearch() {
        int L = 0;
        int R = 1000000000;
        ans = 0;

        while (L<=R) {
           int mid = (L+R)/2;
           if(satisfy(mid)) {
               ans = mid;
               L = mid + 1;
           } else {
               R = mid - 1;
           }
        }
    }

    static boolean satisfy(int h) {
        long sum = 0L;
        for (int i = 1; i <=N; i++) {
            if(tree[i] - h > 0) {
                sum += (tree[i] - h);
            }
        }
        return sum >= M;
    }
}