package baekjoon.fastcampus2.twopointer;

import java.io.*;
import java.util.*;

public class S4_2003 {
    static int N;
    static int M;
    static int[] arr;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        twoPointer();
        System.out.println(ans);
    }

    static void twoPointer() {
        int R = 0;
        int sum = 0;
        for(int L = 1; L <= N; L++) {
            sum -= arr[L-1];

            while(R+1 <= N && sum + arr[R+1] <= M) {
                R++;
                sum += arr[R];
            }

            if(sum == M) {
                ans++;
            }
        }
    }
}
