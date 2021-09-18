package BAEKJOON_Algorithm;

import java.util.Scanner;

public class DP_1937 {
    static int n;
    static int [][] tree;
    static int [][] dp;
    static int [] dx = {0, 0, 1, -1};
    static int [] dy = {1, -1, 0, 0};
    public static int dfs(int y, int x) {
        if(dp[y][x] != 0) {
            return dp[y][x];
        }
        dp[y][x] = 1;
        for (int i = 0; i <4; i++) {
            int tdx = x + dx[i];
            int tdy = y + dy[i];
            if(tdx<0 || tdy<0 || tdx>=n || tdy>=n) continue;
            if(tree[tdy][tdx] > tree[y][x]) {
                dp[y][x] = Math.max(dp[y][x], dfs(tdy,tdx) + 1);
            }
        }
        return dp[y][x];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        tree = new int[n][n];
        dp = new int[n][n];
        int ans = 0;
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n; j++) {
                tree[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i <n; i++) {
            for (int j = 0; j <n; j++) {
                ans = Math.max(ans, dfs(i,j));
            }
        }
        System.out.println(ans);
    }

    private static class Point {
        int x;
        int y;

        public Point(int y, int x) {
            this.x = x;
            this.y = y;
        }
    }
}
