package BAEKJOON_Algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2110 {
    static int N;
    static int C;
    static int[] home;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        home = new int[N+1];
        for (int i = 1; i <=N; i++) {
            home[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(home);
        binarySearch();
        System.out.println(ans);
    }

    static void binarySearch() {
        int L = 0;
        int R = 1000000000;
        while (L<=R) {
            int mid = (L + R) / 2;
            if(condition(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
    }

    static boolean condition(int length) {
        int current = home[1];
        int count = 1;
        for (int i = 2; i <=N; i++) {
            if (home[i] - current >= length) {
                count++;
                current = home[i];
            }
        }
        return count>=C;
    }
}
