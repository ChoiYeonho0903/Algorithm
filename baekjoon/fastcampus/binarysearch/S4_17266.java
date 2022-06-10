package baekjoon.fastcampus.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4_17266 {
    static int N;
    static int M;
    static int[] lamp;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        lamp = new int[M+1];
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for (int i = 1; i <=M; i++) {
            lamp[i] = Integer.parseInt(st.nextToken());
        }
        binarySearch();
        System.out.println(ans);
    }

    static void binarySearch() {
        int L = 1;
        int R = 100000;
        while (L <= R) {
            int mid = (L+R)/2;
            if (condition(mid)) {
                ans = mid;
                R = mid-1;
            } else {
                L = mid+1;
            }
        }
    }

    static boolean condition(int x) {
        if (lamp[1]-x > 0) return false;
        if (lamp[M]+x < N) return false;
        for (int i = 1; i <M; i++) {
            if ((lamp[i]+x) - (lamp[i+1]-x) < 0) {
                return false;
            }
        }
        return true;
    }
}
