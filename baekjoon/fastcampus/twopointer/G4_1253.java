package baekjoon.fastcampus.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G4_1253 {
    static int N;
    static int[] A;
    static int ans;
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
        System.out.println(ans);
    }

    static void twoPointer() {
        for (int i = 1; i <=N; i++) {
            int L = 1;
            int R = N;
            while (L < R) {
                if (L!=i && R!=i && A[L]+A[R]==A[i]) {
                    ans++;
                    break;
                }
                if (A[L]+A[R]<A[i] || L==i) {
                    L++;
                } else {
                    R--;
                }
            }
        }
    }
}
