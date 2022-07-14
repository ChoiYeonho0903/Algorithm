package baekjoon.fastcampus2.binarysearch;

import java.util.*;
import java.io.*;

public class S2_2805 {
    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = binarySearch();

        System.out.println(ans);
    }

    static int binarySearch() {
        int L = 1;
        int R = 1_000_000_000;
        int result = 0;

        while(L <= R) {
            int mid = (L + R) / 2;
            if(calculate(mid)) {
                L = mid + 1;
                result = mid;
            } else {
                R = mid - 1;
            }
        }
        return result;
    }

    static boolean calculate(int x) {
        long sum = 0;
        for(int i = 1; i <= N; i++) {
            if(arr[i] - x > 0)
            sum += arr[i] - x;
        }
        if(sum >= M) {
            return true;
        }
        return false;
    }
}
