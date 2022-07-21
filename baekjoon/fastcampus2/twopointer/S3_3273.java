package baekjoon.fastcampus2.twopointer;

import java.util.*;
import java.io.*;

public class S3_3273 {
    static int N;
    static int X;
    static int[] arr;
    static int ans;

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

        X = Integer.parseInt(br.readLine());

        Arrays.sort(arr, 1, N+1);

        twoPointer();
        System.out.println(ans);

    }

    static void twoPointer() {
        int L = 1;
        int R = N;
        while(L < R) {
            if(arr[L] + arr[R] > X) {
                R--;
            } else if (arr[L] + arr[R] < X) {
                L++;
            } else {
                ans++;
                R--;
            }
        }
    }
}
