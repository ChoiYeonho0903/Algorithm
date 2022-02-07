package BAEKJOON_Algorithm.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_3273 {
    static int n;
    static int[] a;
    static int x;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        a = new int[n+1];
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for (int i = 1; i <=n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        x = Integer.parseInt(br.readLine());
        Arrays.sort(a, 1, n+1);
        twoPointer();
    }

    static void twoPointer() {
        int L = 1;
        int R = n;
        while (L < R) {
            if (a[L] + a[R] == x) {
                ans++;
            }
            if(a[L] + a[R] > x) {
                R--;
            } else {
                L++;
            }
        }
        System.out.println(ans);
    }
}
