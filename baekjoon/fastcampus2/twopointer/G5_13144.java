package baekjoon.fastcampus2.twopointer;

import java.io.*;
import java.util.*;

public class G5_13144 {
    static int N;
    static int[] arr;
    static int[] count = new int[100_001];
    static long ans = 0L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        twoPointer();
        System.out.println(ans);
    }

    static void twoPointer() {
        int R = 0;
        for(int L = 1; L <= N; L++) {
            count[arr[L-1]]--;

            while(R+1 <= N && count[arr[R+1]] < 1) {
                R++;
                count[arr[R]]++;
            }

            ans += (R - L + 1);
        }
    }
}
