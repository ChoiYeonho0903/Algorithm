package baekjoon.fastcampus.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_15565 {
    static int N;
    static int K;
    static int[] A;
    static int ans = 1000000;
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
        int R = 0;
        int count = 0;
        for (int L = 1; L <= N; L++) {
            // 최대로 R 이동
            while (R+1 <= N && count < K) {
                R++;
                if(A[R] == 1) {
                    count++;
                }
            }
            //정답 갱신
            if (count >= K) {
                ans = Math.min(ans, R - L + 1);
            }

            // L 옮기면서 count 값 바꾸기
            if(A[L]==1) count--;
        }
        if (ans == 1000000) ans = -1;
    }
}
