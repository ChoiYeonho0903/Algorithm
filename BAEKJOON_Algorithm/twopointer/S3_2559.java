package BAEKJOON_Algorithm.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3_2559 {
    static int N;
    static int K;
    static int[] A;
    static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N+1];
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for (int i = 1; i <=N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        twoPointer();
        System.out.println(ans);
    }

    static void twoPointer() {
        int R = 1;
        int sum = 0;

        for (int L = 1; L <= N-K+1; L++) {
            while (R-L<K && R<=N) {
                sum += A[R++];
            }
            ans = Math.max(sum, ans);
            sum -= A[L];
        }
    }
}
