package baekjoon.fastcampus2.binarysearch;

import java.util.*;
import java.io.*;

public class S3_7795 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int N;
    static int M;
    static int[] A;
    static int[] B;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            ans = 0;
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N+1];
            B = new int[M+1];

            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 1; j <= N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A, 1, N+1);

            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 1; j <= M; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }

            for(int j = 1; j <= M; j++) {
                int result = binarySearch(B[j]);
                ans += (N - result);
            }
            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }

    static int binarySearch(int k) {
        int L = 1;
        int R = N;
        int result = 0;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(A[mid] <= k) {
                L = mid + 1;
                result = mid;
            } else {
                R = mid - 1;
            }
        }
        return result;
    }
}
