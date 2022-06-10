package baekjoon.fastcampus.bruteforce.level3;

import java.io.*;
import java.util.*;

public class S3_1051 {
    static int N;
    static int M;
    static int[][] A;
    static int max = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        for(int i = 0; i < N; i++) {
            str  = br.readLine();
            for(int j = 0; j < str.length(); j++) {
                A[i][j] = Integer.parseInt(str.substring(j, j+1));
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < str.length(); j++) {
                for(int k = 1; i + k < N && j + k < M; k++) {
                    if(A[i][j] != A[i+k][j]) continue;
                    if(A[i][j] != A[i][j+k]) continue;
                    if(A[i][j] != A[i+k][j+k]) continue;
                    if((k+1)*(k+1) > max) {
                        max = (k+1)*(k+1);
                    }
                }
            }
        }
        System.out.println(max);
    }
}
