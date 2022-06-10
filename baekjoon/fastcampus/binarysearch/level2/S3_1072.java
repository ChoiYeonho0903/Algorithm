package baekjoon.fastcampus.binarysearch.level2;

import java.io.*;
import java.util.*;

public class S3_1072 {
    static long X;
    static long Y;
    static long Z;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        Z = Y*100 / X;
        int ans = binarySearch();
        if (ans == 0) ans = -1;
        System.out.println(ans);
    }

    static int binarySearch() {
        int L = 1;
        int R = 1000000000;
        int result = 0;
        while(L <= R) {
            int mid = (L + R) / 2;
            if (condition(mid)) {
                R = mid-1;
                result = mid;
            } else {
                L = mid+1;
            }
        }
        return result;
    }

    static boolean condition(int x) {
        long nX = X + x;
        long nY = Y + x;
        long nZ = nY*100 / nX;
        if (nZ > Z) return true;
        else return false;
    }
}
