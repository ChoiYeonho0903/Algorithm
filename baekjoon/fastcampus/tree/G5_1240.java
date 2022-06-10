package baekjoon.fastcampus.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_1240 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int M;
    static int [][][] lists;
    static boolean[] visited;
    static int sum;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lists = new int[N+1][N+1][1];
        for (int i = 0; i < N - 1; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            lists[x][y][0] = z;
            lists[y][x][0] = z;
        }
        for (int i = 0; i < M; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sum = 0;
            visited = new boolean[N+1];
            dfs(x, y);
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs (int x, int y) {
        visited[x] = true;
        if (x == y) {
            ans = sum;
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (lists[x][i][0] != 0) {
                if (visited[i]) continue;
                sum += lists[x][i][0];
                dfs(i, y);
                sum -= lists[x][i][0];
            }
        }
    }
}
