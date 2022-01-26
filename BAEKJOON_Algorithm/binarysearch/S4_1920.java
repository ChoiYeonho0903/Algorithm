package BAEKJOON_Algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S4_1920 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] A;
    static int[] B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for (int i = 1; i <=N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        B = new int[M+1];
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for (int i = 1; i <=M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A, 1, N+1);
        for (int i = 1; i <=M; i++) {
             sb.append(binarySearch(B[i])).append("\n");
        }
        System.out.print(sb);
    }

    static int binarySearch(int X) {
        int L = 1;
        int R = N;
        while (L<=R) {
            int mid = (L + R) / 2;
            if(A[mid] == X) {
                return 1;
            } else if (A[mid] > X) {
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return 0;
    }
}
