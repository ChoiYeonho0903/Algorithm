package baekjoon.fastcampus.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_2473 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int A[];
    static int[] ans = new int[3];
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
        System.out.print(sb);
    }

    static void twoPointer() {
        long bestSum = Long.MAX_VALUE;
        for (int i = 1; i <=N-2; i++) {
            int target = A[i];
            int L = i+1;
            int R = N;
            while (L < R) {
                long sum = (long)A[i] + A[L] + A[R];
                if (bestSum > Math.abs(sum)) {
                    bestSum = Math.abs(sum);
                    ans[0] = target;
                    ans[1] = A[L];
                    ans[2] = A[R];
                }

                if (sum > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }
        sb.append(ans[0]).append(" ").append(ans[1]).append(" ").append(ans[2]);
    }
}
