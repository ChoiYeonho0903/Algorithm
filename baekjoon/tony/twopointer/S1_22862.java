package baekjoon.tony.twopointer;

import java.util.*;
import java.io.*;

public class S1_22862 {
    static int N;
    static int K;
    static int[] arr;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        twoPointer();
        System.out.println(max);


    }

    static void twoPointer() {
        int delete = 0;
        int R = 0;
        for(int L = 1; L <=N; L++) {
            if(arr[L-1]%2 == 1) {
                delete--;
            }

            while (R+1 <= N) {
                R++;
                if(arr[R]%2 == 1) {
                    delete++;
                }

                if(delete > K) {
                    R--;
                    delete--;
                    break;
                }
            }

            if(max < R - L + 1 - delete) {
                max = R - L + 1 - delete;
            }
        }
    }
}
