package baekjoon.fastcampus.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5_11728 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] A;
    static int[] B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N+1];
        B = new int[M+1];
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for (int i = 1; i <= M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        twoPointer();
        System.out.println(sb);
    }

    static void twoPointer() {
        int pointA = 1;
        int pointB = 1;
        while (pointA<=N && pointB<=M) {
            if (A[pointA] <= B[pointB]) {
                sb.append(A[pointA]).append(" ");
                pointA++;
            } else {
                sb.append(B[pointB]).append(" ");
                pointB++;
            }
        }
        if (pointA <= N) {
            for (int i = pointA; i <= N; i++) {
                sb.append(A[i]).append(" ");
            }
        }
        if (pointB <= M) {
            for (int i = pointB; i <= M; i++) {
                sb.append(B[i]).append(" ");
            }
        }
    }
}
