package baekjoon.tony.twopointer;

import java.util.*;
import java.io.*;

public class G4_22945 {
    static int N;
    static int[] arr;
    static int ans = 0;

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
        int R = N;
        int L = 1;
        while(L < R) {
            int indexGap = R - L -1;
            int calculate = indexGap * Math.min(arr[L], arr[R]);
            if(ans < calculate) {
                ans = calculate;
            }
            if(arr[L] < arr[R]) {
                L++;
            } else {
                R--;
            }

        }
    }
}
