package baekjoon.fastcampus2.binarysearch;

import java.util.*;
import java.io.*;

public class S4_10816 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] A;
    static int M;
    static int[] B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        B = new int[M+1];
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i <= M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A, 1, N+1);

        for(int i = 1; i <= M; i++) {
            int lowerResult = lowerBinarySearch(B[i]);
            int upperResult = upperBinarySearch(B[i]);
            int count = upperResult - lowerResult - 1;

            sb.append(count).append(" ");
        }

        System.out.println(sb);
    }

    static int lowerBinarySearch(int x) {
        int L = 1;
        int R = N;
        int result = 0;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(A[mid] < x) {
                result = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return result;
    }

    static int upperBinarySearch(int x) {
        int L = 1;
        int R = N;
        int result = N+1;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(A[mid] > x) {
                result = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return result;
    }
}
