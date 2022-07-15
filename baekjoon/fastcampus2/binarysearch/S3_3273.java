package baekjoon.fastcampus2.binarysearch;

import java.util.*;
import java.io.*;

public class S3_3273 {
    static int n;
    static int[] a;
    static int X;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        a = new int[n+1];
        String str = br.readLine();
        st = new StringTokenizer(str, " ");

        for(int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        X = Integer.parseInt(br.readLine());

        Arrays.sort(a, 1, n+1);

        for(int i = 1; i <= n; i++) {
            if(binarySearch(i+1, n, a[i])) {
                count++;
            }
        }

        System.out.println(count);
    }

    static boolean binarySearch(int L, int R, int x) {
        while(L <= R) {
            int mid = (L + R) / 2;
            if(a[mid] + x < X) {
                L = mid + 1;
            } else if (a[mid] + x > X) {
                R = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
