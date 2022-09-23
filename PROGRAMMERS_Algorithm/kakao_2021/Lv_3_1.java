package PROGRAMMERS_Algorithm.kakao_2021;

public class Lv_3_1 {
    int[][] dist;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        dist = new int[n+1][n+1];
        // 초기 거리 초기화
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) continue;
                dist[i][j] = 100_000 * n + 1;
            }
        }
        for(int i = 0; i < fares.length; i++) {
            int x = fares[i][0];
            int y = fares[i][1];
            int weight = fares[i][2];
            dist[x][y] = weight;
            dist[y][x] = weight;
        }

        // 플로이드 워셜 알고리즘
        // 노드를 1개부터 N개까지 k를 거쳐가는 경우를 모두 고려한다.
        for(int k = 1; k <= n; k++) {
            // 노드 i에서 j로 가는 경우
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1; i <=n ; i++) {
            min = Math.min(dist[s][i] + dist[i][a] + dist[i][b], min);
        }
        return min;
    }
}
