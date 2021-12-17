package ETC.SDS_Algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test4 {
    static int T;
    static int N;
    static int M;
    static int start_A;
    static int start_B;
    static ArrayList<Integer>[] position;
    static int [] visited;
    static int [] occupation_time;
    static int [][] ans;
    static void bfs() {
        Queue<Occupation> queue = new LinkedList<>();
        visited = new int[N+1];
        occupation_time = new int[N+1];
        visited[start_A] = 1;
        visited[start_B] = 2;
        occupation_time[1] = 0;
        occupation_time[N] = 0;
        queue.add(new Occupation(0, 1, start_A));
        queue.add(new Occupation(0, 2, start_B));
        while(!queue.isEmpty()) {
            Occupation current = queue.poll();
            if(visited[current.position_n]==-1) continue;
            for (int i = 0; i <position[current.position_n].size(); i++) {
                int tmp = position[current.position_n].get(i);
                if(visited[tmp]==-1) continue;
                else if(visited[tmp]==0) {
                    visited[tmp] = current.country;
                    occupation_time[tmp] = current.time+1;
                    queue.add(new Occupation(current.time+1, current.country, tmp));
                }
                else {
                    if(visited[tmp] != current.country && occupation_time[tmp] == current.time+1) {
                        visited[tmp] = -1;
                    }
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        ans = new int[T][2];
        for (int i = 0; i <T; i++) {
            N = scanner.nextInt();
            M = scanner.nextInt();
            start_A = scanner.nextInt();
            start_B = scanner.nextInt();
            position = new ArrayList[N+1];
            for (int j = 1; j <N+1; j++) {
                position[j] = new ArrayList<>();
            }
            for (int j = 0; j <M; j++) {
                int x1 = scanner.nextInt();
                int x2 = scanner.nextInt();
                position[x1].add(x2);
                position[x2].add(x1);
            }
            bfs();
            int A = 0;
            int B = 0;
            int empty = 0;
            for (int j = 1; j <visited.length; j++) {
                if(visited[j]==1) A++;
                else if(visited[j]==2) B++;
                else if(visited[j]==-1) ans[i][0]++;
                else empty++;
            }
            int majority = N/2+1;
            if(A+ans[i][0]+empty >= majority)
                if(A>=majority)
                    ans[i][1] = 0;
                else
                    ans[i][1] = majority-A;
            else
                ans[i][1] = -1;
        }
        for (int i = 0; i <ans.length; i++) {
            System.out.println("#"+(i+1)+" "+ans[i][0]+" "+ans[i][1]);
        }
    }
    public static class Occupation {
        int time;
        int country;
        int position_n;

        public Occupation(int time, int country, int position_n) {
            this.time = time;
            this.country = country;
            this.position_n = position_n;
        }
    }
}
