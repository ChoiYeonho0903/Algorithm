package baekjoon.fastcampus2.binarysearch;

import java.util.*;
import java.io.*;

public class S4_17266 {
    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i <= M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = binarySearch();
        System.out.println(result);
    }

    static int binarySearch() {
        int L = 1;
        int R = 100_000;
        int result = 100_000;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(determination(mid)) {
                result = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        return result;
    }

    static boolean determination(int x) {
        int standard = 0;
        for(int i = 1; i <= M; i++) {
            if(standard + x >= arr[i]) {
                standard = arr[i] + x;
            } else {
                return false;
            }
        }
        if(standard < N) {
            return false;
        }
        return true;
    }
}
