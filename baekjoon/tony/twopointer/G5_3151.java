package baekjoon.tony.twopointer;

import java.util.*;
import java.io.*;

public class G5_3151 {
    static int N;
    static int[] arr;
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
        Arrays.sort(arr, 1, N+1);
        twoPointer();
        System.out.println(ans);
    }

    static void twoPointer() {
        for(int i = 1; i <= N-2; i++) {
            int L = i+1;
            int R = N;
            while(L < R) {
                int sum = arr[i] + arr[L] + arr[R];

                if (sum == 0) {
                    int l = 1;
                    int r = 1;
                    if(arr[L] == arr[R]) {
                        int n = R - L + 1;
                        ans += (n * (n - 1) / 2);
                        break;
                    }

                    while(arr[L] == arr[L+1]) {
                        l++;
                        L++;
                    }

                    while(arr[R] == arr[R-1]) {
                        r++;
                        R--;
                    }

                    ans += l*r;
                }

                if (sum > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }
    }
}
