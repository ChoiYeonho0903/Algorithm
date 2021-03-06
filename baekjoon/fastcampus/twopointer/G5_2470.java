package baekjoon.fastcampus.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2470 {
    static int N;
    static int[] A;
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
        Arrays.sort(A, 1, N+1);
        twoPointer();
    }

    static void twoPointer() {
        int R = N;
        int L = 1;
        int minSum = Integer.MAX_VALUE;
        int[] ans = new int[2];
        while (L < R) {
            if (minSum > Math.abs(A[L] + A[R])) {
                minSum = Math.abs(A[L] + A[R]);
                ans[0] = A[L];
                ans[1] = A[R];
            }
            if (A[L] + A[R] > 0) {
                R--;
            } else {
                L++;
            }
        }
        System.out.println(ans[0] + " " + ans[1]);
    }
}
