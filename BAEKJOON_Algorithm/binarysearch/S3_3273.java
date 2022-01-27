package BAEKJOON_Algorithm.binarysearch;

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
        for (int i = 1; i <=n; i++) {
            if (binarySearch(i+1, n, x-a[i])) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    static boolean binarySearch(int L, int R, int X) {
        while(L<=R) {
            int mid = (L+R)/2;
            if(a[mid]==X) {
                return true;
            } else if (a[mid] < X) {
                L = mid+1;
            } else {
                R = mid-1;
            }
        }
        return false;
    }
}
