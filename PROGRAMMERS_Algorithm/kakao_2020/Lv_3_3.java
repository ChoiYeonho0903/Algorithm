package PROGRAMMERS_Algorithm.kakao_2020;

public class Lv_3_3 {
    int[] selected;
    boolean[] visited;
    int[] list;
    int answer;
    public int solution(int n, int[] weak, int[] dist) {
        answer = dist.length+1;
        selected = new int[dist.length];
        visited = new boolean[dist.length];

        for(int i = 0; i < weak.length; i++) {
            list = rotate(weak, i, n);
            recursion(dist, 0);
        }

        if(answer > dist.length) {
            return -1;
        }
        return answer;
    }

    public int min(int[] list, int[] dist) {
        int ans = dist.length-1;
        int possible = list[0] + dist[ans];

        for(int i = 0; i < list.length; i++) {
            if(list[i] > possible) {
                ans--;
                if(ans < 0) {
                    break;
                }
                possible = list[i] + dist[ans];
            }
        }
        return dist.length - ans;
    }

    public void recursion(int[] dist, int depth) {
        if(dist.length == depth) {
            int x = min(list, selected);
            if(x > dist.length) {
                return;
            }
            answer = Math.min(answer, x);
        }
        for(int i = 0; i < dist.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            selected[depth] = dist[i];
            recursion(dist, depth+1);
            visited[i] = false;
            selected[depth] = 0;
        }
    }

    public int[] rotate(int[] weak, int idx, int n) {
        int[] list = new int[weak.length];
        int c = 0;
        for(int i = idx; i < weak.length; i++) {
            list[c] = weak[i];
            c++;
        }
        for(int i = 0; i < idx; i++) {
            list[c] = weak[i] + n;
            c++;
        }
        return list;
    }
}
