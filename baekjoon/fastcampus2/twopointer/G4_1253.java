package baekjoon.fastcampus2.twopointer;

import java.io.*;
import java.util.*;

public class G4_1253 {
    static int N;
    static int[] arr;
    static int ans;

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
            if(twoPointer(i)) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    static boolean twoPointer(int index) {
        int R = N;
        int L = 1;
        int target = arr[index];
        while(L < R) {
            if(L == index) {
                L++;
                continue;
            }
            if(R == index) {
                R--;
                continue;
            }
            if(arr[L] + arr[R] < target) {
                L++;
            } else if (arr[L] + arr[R] > target) {
                R--;
            } else {
                return true;
            }
        }
        return false;
    }
}
