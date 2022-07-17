package baekjoon.fastcampus2.binarysearch;

import java.util.*;
import java.io.*;

public class G2_1300 {
    static int N;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        long result = binarySearch();
        System.out.println(result);

    }

    static long binarySearch() {
        long L = 1;
        long R = (long) N * N;
        long result = 0;
        while(L <= R) {
            long mid = (L + R) / 2;
            if (determination(mid)) {
                result = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return result;
    }

    static boolean determination(long x) {
        long sum = 0;
        for(int i = 1; i <= N; i++) {
            sum += Math.min(N, x / i);
        }
        return sum >= k;
    }
}
