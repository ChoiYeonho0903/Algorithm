package baekjoon.fastcampus2.twopointer;

import java.io.*;
import java.util.*;

public class G4_1806 {
    static int N;
    static int S;
    static int[] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        twoPointer();
        if(min == Integer.MAX_VALUE) {
            min = 0;
        }

        System.out.println(min);
    }

    static void twoPointer() {
        int R = 0;
        int sum = 0;
        for(int L = 1; L <= N; L++) {
            sum -= arr[L-1];

            while(R+1 <= N && sum < S) {
                R++;
                sum += arr[R];
            }

            if(sum >= S) {
                min = Math.min(min, R - L + 1);
            }
        }
    }
}
