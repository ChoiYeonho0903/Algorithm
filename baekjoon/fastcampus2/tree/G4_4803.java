package baekjoon.fastcampus2.tree;

import java.util.*;
import java.io.*;

public class G4_4803 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    static int n;
    static int m;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    static boolean tf;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            T++;
            ans = 0;
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) break;
            list = new ArrayList[n+1];
            visited = new boolean[n+1];
            for(int i = 1; i <= n; i++) {
                list[i] = new ArrayList<>();
            }
            for(int i = 0; i < m; i++) {
                str = br.readLine();
                st = new StringTokenizer(str, " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list[x].add(y);
                list[y].add(x);
            }

            for(int i = 1; i <= n; i++) {
                if(!visited[i]) {
                    tf = true;
                    dfs(i, -1);
                    if(tf) {
                        ans++;
                    }
                }

            }

            if(ans == 0) {
                sb.append("Case ").append(T).append(": No trees.\n");
            } else if(ans == 1) {
                sb.append("Case ").append(T).append(": There is one tree.\n");
            } else {
                sb.append("Case ").append(T).append(": A forest of ").append(ans).append(" trees.\n");
            }
        }

        System.out.print(sb);

    }

    static void dfs(int x, int parent) {
        visited[x] = true;
        for(int i = 0; i < list[x].size(); i++) {
            int y = list[x].get(i);
            if(!visited[y]) {
                dfs(y, x);
            } else {
                if(parent != y) {
                    tf = false;
                }
            }

        }
    }
}
