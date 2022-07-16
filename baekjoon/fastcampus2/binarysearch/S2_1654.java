package baekjoon.fastcampus2.binarysearch;

import java.util.*;
import java.io.*;

public class S2_1654 {
    static int K;
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[K+1];

        for(int i = 1; i <= K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long ans = binarySearch();
        System.out.println(ans);
    }

    static long binarySearch() {
        long L = 1;
        long R = Integer.MAX_VALUE;
        long result = 0;
        while(L <= R) {
            long mid = (L + R) / 2;
            if(determination(mid)) {
                result = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return result;
    }

    static boolean determination(long x) {
        int sum = 0;
        for(int i = 1; i <= K; i++) {
            sum += arr[i] / x;
        }
        return sum >= N;
    }
}
