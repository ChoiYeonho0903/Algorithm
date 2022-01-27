package BAEKJOON_Algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_1654 {
    static int K;
    static int N;
    static int[] lan;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        lan = new int[K+1];
        for (int i = 1; i <=K; i++) {
            lan[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(binarySearch());
    }

    static long binarySearch() {
        long L = 1;
        long R = Integer.MAX_VALUE;
        long result=0;
        while (L<=R) {
            long mid = (L+R)/2;
            if(condition(mid)) {
                L = mid+1;
                result = mid;
            } else {
                R = mid-1;
            }
        }
        return result;
    }

    static boolean condition(long X) {
        int count = 0;
        for (int i = 1; i <=K; i++) {
            count += (lan[i]/X);
        }
        return count>=N;
    }
}
