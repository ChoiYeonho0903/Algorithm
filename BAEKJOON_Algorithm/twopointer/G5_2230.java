package BAEKJOON_Algorithm.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2230 {
    static int N;
    static int M;
    static int[] A;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N+1];
        for (int i = 1; i <=N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A, 1, N+1);
        twoPointer();
        System.out.println(ans);
    }

    static void twoPointer() {
        int R = 1;
        for (int L = 1; L <=N; L++) {
            while (R+1<=N && A[R]-A[L] < M) {
                R++;
            }
            if (A[R]-A[L] >= M) {
                ans = Math.min(ans, A[R]-A[L]);
            }
        }
    }
}
