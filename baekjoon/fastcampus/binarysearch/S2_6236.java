package baekjoon.fastcampus.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_6236 {
    static int N;
    static int M;
    static int[] money;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        money = new int[N+1];
        for (int i = 1; i <=N; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }
        binarySearch();
        System.out.println(ans);
    }

    static void binarySearch() {
        int L = 1;
        int R = 1000000000;
        while (L <= R){
            int mid = (L+R)/2;
            if(condition(mid)) {
                ans = mid;
                R = mid-1;
            } else {
                L = mid+1;
            }
        }
    }

    static boolean condition(int x) {
        int sum = 0;
        int count = 1;
        for (int i = 1; i <=N; i++) {
            if (money[i] > x) return false;
            sum += money[i];
            if(sum <= x) {
                continue;
            } else {
                count++;
                sum = money[i];
            }
        }
        return M >= count;
    }
}
