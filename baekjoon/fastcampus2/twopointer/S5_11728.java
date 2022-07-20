package baekjoon.fastcampus2.twopointer;

import java.io.*;
import java.util.*;

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
        for(int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i <= M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        twoPointer();
        System.out.println(sb);
    }

    static void twoPointer() {
        int La = 1;
        int Lb = 1;

        while(La <= N && Lb <= M) {
            if(A[La] < B[Lb]) {
                sb.append(A[La]).append(" ");
                La++;
            } else {
                sb.append(B[Lb]).append(" ");
                Lb++;
            }
        }

        if(La <= N) {
            for(int i = La; i <= N; i++) {
                sb.append(A[i]).append(" ");
            }
        }
        if(Lb <= M) {
            for(int i = Lb; i <= M; i++) {
                sb.append(B[i]).append(" ");
            }
        }
    }
}
