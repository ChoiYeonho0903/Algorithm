package baekjoon.fastcampus.topological_sort;

import java.util.*;
import java.io.*;

public class G3_1516 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static ArrayList<Integer>[] lists;
    static int[] inDeg;
    static int[] time;
    static int[] completedTime;
    static Queue<Integer> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        lists = new ArrayList[N+1];
        inDeg = new int[N+1];
        time = new int[N+1];
        completedTime = new int[N+1];

        for(int i = 1; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }
        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            time[i] = x;

            while(st.hasMoreTokens()) {
                x = Integer.parseInt(st.nextToken());
                if(x == -1) break;
                lists[x].add(i);
                inDeg[i]++;
            }
        }
        for(int i = 1; i <= N; i++) {
            if(inDeg[i] == 0) {
                queue.add(i);
                completedTime[i] = time[i];
            }
        }
        while(!queue.isEmpty()) {
            int x = queue.poll();
            for(int y : lists[x]) {
                completedTime[y]  = Math.max(completedTime[y], completedTime[x]);
                inDeg[y]--;
                if(inDeg[y] == 0) {
                    completedTime[y] += time[y];
                    queue.add(y);
                }
            }
        }
        for(int i = 1; i <= N; i++) {
            sb.append(completedTime[i]).append("\n");
        }
        System.out.print(sb);
    }
}
