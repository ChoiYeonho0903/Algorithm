package baekjoon.fastcampus2.binarysearch;

import java.io.*;
import java.util.*;

public class S2_6236 {

    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int result = binarySearch();
        System.out.println(result);
    }

    static int binarySearch() {
        int L = 1;
        int R = 1_000_000_000;
        int result = R;
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
        int changes = x;
        int count = 1;
        for(int i = 1; i <= N; i++) {
            if(arr[i] > x) return false;

            if(changes >= arr[i]) {
                changes -= arr[i];
            } else {
                count++;
                changes = x - arr[i];
            }
        }
        return count <= M;
    }
}
