package baekjoon.fastcampus2.binarysearch;

import java.io.*;
import java.util.*;

public class S3_13702 {
    static int N;
    static int K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long result = binarySearch();

        System.out.println(result);
    }

    static long binarySearch() {
        long L = 0;
        long R = Integer.MAX_VALUE;
        long result = Integer.MAX_VALUE;
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
        int count = 0;
        for(int i = 1; i <= N; i++) {
            count += (arr[i] / x);
        }
        return count >= K;
    }
}
