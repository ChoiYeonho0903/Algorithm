package baekjoon.fastcampus.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G4_1806 {
    static int N;
    static int S;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        A = new int[N+1];
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for (int i = 1; i <=N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        twoPointer();
    }

    static void twoPointer() {
        int R = 0;
        int sum = 0;
        int ans = N+1;
        for (int L = 1; L <=N; L++) {
            // L-1을 구간에서 제외하기
            sum -= A[L-1];

            // R을 옮길 수 있을 때까지 옮기기
            while (R+1 <=N && sum < S) {
                sum += A[++R];
            }

            // [L ... R] 의 합, 즉 sum이 조건을 만족하면 정답 갱신하기
            if (sum >= S) {
                ans = Math.min(ans, R-L+1);
            }
        }
        // ans 값을 보고 불가능 판단하기
        if (ans == N+1) ans = 0;
        System.out.println(ans);
    }
}
