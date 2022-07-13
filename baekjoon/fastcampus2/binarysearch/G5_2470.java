package baekjoon.fastcampus2.binarysearch;

import java.io.*;
import java.util.*;

public class G5_2470 {
    static int N;
    static int[] arr;
    static int min = Integer.MAX_VALUE;
    static int[] ans = new int[2];

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

        for(int i = 1; i <= N; i++) {
            int result = binarySearch(i+1, N, -arr[i]);
            if(result+1 <= N && i+1 <= result+1) {
                int tmp = Math.abs(arr[result+1] + arr[i]);
                if(tmp < min) {
                    min = tmp;
                    arr[0] = arr[i];
                    arr[1] = arr[result+1];
                }
            }

            if(result <= N && i+1 <= result) {
                int tmp = Math.abs(arr[result] + arr[i]);
                if(tmp < min) {
                    min = tmp;
                    arr[0] = arr[i];
                    arr[1] = arr[result];
                }
            }
        }

        System.out.println(arr[0] + " " + arr[1]);
    }

    static int binarySearch(int L, int R, int x) {
        int result = L-1;
        while(L <= R) {
            int mid = (L + R) / 2;
            if(arr[mid] <= x) {
                L = mid+1;
                result = mid;
            } else {
                R = mid-1;
            }
        }
        return result;
    }
}
