package baekjoon.fastcampus2.binarysearch;

import java.io.*;
import java.util.*;

public class S1_2343 {
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
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
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
        int sum = 0;
        int count = 1;
        for(int i = 1; i <= N; i++) {
            if(arr[i] > x) {
                return false;
            }

            if(sum + arr[i] <= x) {
                sum += arr[i];
            } else {
                count++;
                sum = arr[i];
            }
        }
        return count <= M;
    }
}
