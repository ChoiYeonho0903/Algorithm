package baekjoon.fastcampus2.topological_sort;

import java.util.*;
import java.io.*;

public class G3_1516 {
    static int N;
    static ArrayList<Integer>[] list;
    static int[] inDegree;
    static int[] time;
    static int[] ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        inDegree = new int[N+1];
        time = new int[N+1];
        ans = new int[N+1];

        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            time[i] = Integer.parseInt(st.nextToken());
            while(true) {
                int x = Integer.parseInt(st.nextToken());
                if(x == -1) break;
                list[x].add(i);
                inDegree[i]++;
            }
        }

        bfs();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(ans[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                ans[i] = time[i];
            }
        }
        while(!queue.isEmpty()) {
            int x = queue.poll();
            for(int y : list[x]) {
                ans[y] = Math.max(ans[y], ans[x] + time[y]);
                inDegree[y]--;
                if(inDegree[y] == 0) {
                    queue.add(y);
                }
            }
        }
    }
}
