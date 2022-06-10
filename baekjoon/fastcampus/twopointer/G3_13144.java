package baekjoon.fastcampus.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3_13144 {
    static int N;
    static int[] A;
    static long ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for (int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        twoPointer();
        System.out.println(ans);
    }

    static void twoPointer() {
        int R = 0;
        int[] count = new int[100001];
        for (int L = 1; L <=N; L++) {
            // R을 옮길 수 있는 만큼 옮긴다.
            while (R+1 <= N && count[A[R + 1]] == 0) {
                R++;
                count[A[R]]++;
            }
            // 정답을 갱신한다.
            ans += R-L+1;

            // L을 옮겨주면서 A[L] 의 개수를 감소시킨다.
            count[A[L]]--;
        }
    }
}
