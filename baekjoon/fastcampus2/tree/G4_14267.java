package baekjoon.fastcampus2.tree;

import java.util.*;
import java.io.*;

public class G4_14267 {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int m;
    static ArrayList<Integer>[] list;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        ans = new int[n+1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 1; i <= n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if(x == -1) {
                continue;
            }
            list[x].add(i);
        }

        for(int i = 0; i < m; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int amount = Integer.parseInt(st.nextToken());
            ans[x] += amount;
        }

        dfs(1);

        for(int i = 1; i <= n; i++) {
            sb.append(ans[i]).append(" ");
        }

        System.out.println(sb);

    }

    static void dfs(int x) {
        for(int y : list[x]) {
            ans[y] += ans[x];
            dfs(y);
        }
    }
}
