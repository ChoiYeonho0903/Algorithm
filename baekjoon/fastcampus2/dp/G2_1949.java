package baekjoon.fastcampus2.dp;

import java.util.*;
import java.io.*;

public class G2_1949 {
    static int N;
    static int[] A;
    static ArrayList<Integer>[] list;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        dp = new int[N+1][2];
        list = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N-1; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }

        dfs(1, 0);

        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    static void dfs(int x, int parent) {
        dp[x][0] = 0;
        dp[x][1] = A[x];

        for(int y : list[x]) {
            if(y == parent) continue;
            dfs(y, x);
            dp[x][0] += Math.max(dp[y][0], dp[y][1]);
            dp[x][1] += dp[y][0];
        }
    }
}