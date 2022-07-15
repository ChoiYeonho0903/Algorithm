package baekjoon.fastcampus2.binarysearch;

import java.util.*;
import java.io.*;

public class S4_1920 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int[] A;

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

        Arrays.sort(A, 1, N+1);

        M = Integer.parseInt(br.readLine());
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 0; i < M; i++) {
            if(binarySearch(Integer.parseInt(st.nextToken()))) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }

        System.out.print(sb);
    }

    static boolean binarySearch(int x) {
        int L = 1;
        int R = N;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(A[mid] < x) {
                L = mid + 1;
            } else if(A[mid] > x) {
                R = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
