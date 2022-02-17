package BAEKJOON_Algorithm.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S3_2606 {
    static int computerNum;
    static int N;
    static ArrayList<Integer>[] lists;
    static boolean[] visited;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        computerNum = Integer.parseInt(br.readLine());
        lists = new ArrayList[computerNum+1];
        visited = new boolean[computerNum+1];
        for (int i = 1; i <= computerNum; i++) {
            lists[i] = new ArrayList<>();
        }
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lists[x].add(y);
            lists[y].add(x);
        }
        bfs(1);
        System.out.println(ans);
    }

    static void bfs (int x) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x] = true;
        int count = -1;
        while (!queue.isEmpty()) {
            count++;
            int tx = queue.poll();
            for (int i = 0; i < lists[tx].size(); i++) {
                int nx = lists[tx].get(i);
                if (visited[nx]) continue;
                queue.add(nx);
                visited[nx] = true;
            }
        }
        ans = count;
    }
}
