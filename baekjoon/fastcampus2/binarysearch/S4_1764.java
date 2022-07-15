package baekjoon.fastcampus2.binarysearch;

import java.io.*;
import java.util.*;

public class S4_1764 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static String[] A;
    static String[] B;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new String[N+1];
        B = new String[M+1];

        for(int i = 1; i <= N; i++) {
            A[i] = br.readLine();
        }

        for(int i = 1; i <= M; i++) {
            B[i] = br.readLine();
        }

        Arrays.sort(A, 1, N+1);
        Arrays.sort(B, 1, M+1);

        for(int i = 1; i <= M; i++) {
            if(binarySearch(B[i])) {
                sb.append(B[i]).append("\n");
                count++;
            }
        }

        System.out.println(count);
        System.out.print(sb);
    }

    static boolean binarySearch(String str) {
        int L = 1;
        int R = N;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(A[mid].equals(str)) {
                return true;
            } else if (A[mid].compareTo(str) < 0) {
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return false;
    }
}
