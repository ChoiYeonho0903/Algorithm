package BAEKJOON_Algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1_2343 {
    static int N;
    static int M;
    static int[] bluRay;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        bluRay = new int[N+1];
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for (int i = 1; i <=N; i++) {
            bluRay[i] = Integer.parseInt(st.nextToken());
        }
        binarySearch(1, 1000000000);
        System.out.println(ans);
    }

    static void binarySearch(int L , int R) {
        while (L <= R) {
            int mid = (L+R)/2;
            if(condition(mid)) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
    }

    static boolean condition(int x) {
        int sum = 0;
        int count = 1;
        for (int i = 1; i <=N; i++) {
            if (bluRay[i] > x) return false;

            sum += bluRay[i];
            if (sum <= x) {
                continue;
            } else {
                count ++;
                sum = bluRay[i];
            }
        }
        return M >= count;
    }
}
