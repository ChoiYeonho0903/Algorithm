package baekjoon.fastcampus2.binarysearch;

import java.io.*;
import java.util.*;

public class S3_2512 {
    static int N;
    static int M;
    static int[] arr;
    static int total;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        Arrays.sort(arr, 1, N+1);

        M = Integer.parseInt(br.readLine());

        int result = 0;
        if(total <= M) {
            result = arr[N];
        } else {
            result = binarySearch();
        }
        System.out.println(result);
    }

    static int binarySearch() {
        int L = 1;
        int R = 100_000;
        int result = 0;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(determination(mid)) {
                result = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return result;
    }

    static boolean determination(int x) {
        int sum = 0;
        for(int i = 1; i <= N; i++) {
            if(arr[i] >= x) {
                sum += x;
            } else {
                sum += arr[i];
            }
        }
        return sum <= M;
    }
}
