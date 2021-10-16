package PROGRAMMERS_Algorithm;

public class Dfs_2 {
    static int n  = 3;
    static int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
    static boolean[] visited;
    static int n_s;
    static int[][] computers_s;
    public static void main(String[] args) {
        System.out.println(solution(n, computers));
    }

    public static int solution(int n, int[][] computers) {
        int answer = 0;
        n_s = n;
        computers_s = computers;
        visited = new boolean[n];
        for (int i = 0; i <n; i++) {
            if(!visited[i]) {
                dfs(i);
                answer++;
            }
        }
        return answer;
    }

    public static void dfs(int x) {
        visited[x] = true;
        for (int i = 0; i <computers_s[x].length; i++) {
            if(x == i) {
                continue;
            }
            else {
                if(!visited[i] && computers_s[x][i] == 1) {
                    dfs(i);
                }
            }
        }
    }
}
