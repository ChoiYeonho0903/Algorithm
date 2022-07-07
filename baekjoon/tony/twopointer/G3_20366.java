package baekjoon.tony.twopointer;

import java.io.*;
import java.util.*;

public class G3_20366 {
    static int N;
    static int[] arr;
    static int snowMan;
    static int min = Integer.MAX_VALUE;

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

        Arrays.sort(arr, 1, N+1);
        twoPointer();
        System.out.println(min);
    }

    static void twoPointer() {
        for(int i = 1; i <= N-3; i++) {
            for(int j = i+3; j <= N; j++) {
                int L = i+1;
                int R = j-1;
                while(L < R) {
                    int sum = arr[L] + arr[R] - arr[i] - arr[j];
                    if(Math.abs(sum) < min) {
                        min = Math.abs(sum);
                    }

                    if(sum > 0) {
                        R--;
                    } else {
                        L++;
                    }
                }
            }
        }
    }
}
