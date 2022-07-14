package baekjoon.fastcampus2.binarysearch;

import java.io.*;
import java.util.*;

public class G5_2110 {
    static int N;
    static int C;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N+1];
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, 1, N+1);

        int result = binarySearch();
        System.out.println(result);
    }

    static int binarySearch() {
        int L = 1;
        int R = 1_000_000_000;
        int result = 0;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(determination(mid)) {
                result = mid;
                L = mid + 1 ;
            } else {
                R = mid - 1;
            }
        }
        return result;
    }

    static boolean determination(int x) {
        int count = 1;
        int last = arr[1];

        for(int i = 2; i <= N; i++) {
            if(arr[i] - last >= x) {
                count++;
                last = arr[i];
            }
        }
        return count >= C;
    }
}
