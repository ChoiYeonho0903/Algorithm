package PROGRAMMERS_Algorithm.kakao_2021;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Lv_3_3 {
    int[] dy = {0, 0, 1, -1};
    int[] dx = {1, -1, 0, 0};
    ArrayList<Integer>[] card = new ArrayList[7];
    int[][] cBoard;
    int answer = Integer.MAX_VALUE;
    int R;
    int C;
    public int solution(int[][] board, int r, int c) {
        cBoard = board;
        R = r;
        C = c;
        for(int i = 1; i <= 6; i++) {
            card[i] = new ArrayList<>();
        }

        int cardCnt = 0;
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                if(board[i][j] > 0) {
                    cardCnt = Math.max(board[i][j], cardCnt);
                    card[board[i][j]].add(i);
                    card[board[i][j]].add(j);
                }
            }
        }


        int[] selected = new int[cardCnt+1];
        boolean[] dVisited = new boolean[cardCnt+1];
        recursion(selected, dVisited, 1, cardCnt);

        answer += cardCnt*2;
        return answer;
    }

    public void recursion(int[] selected, boolean[] dVisited, int depth, int len) {
        if(depth == len+1) {
            int sum = 0;
            int r = R;
            int c = C;
            for(int i = 1; i < selected.length; i++) {
                int t1 = bfs(cBoard, r, c, card[selected[i]].get(0), card[selected[i]].get(1));
                int t2 = bfs(cBoard, r, c, card[selected[i]].get(2), card[selected[i]].get(3));
                if(t1 < t2) {
                    r = card[selected[i]].get(2);
                    c = card[selected[i]].get(3);
                    int d = bfs(cBoard, card[selected[i]].get(0), card[selected[i]].get(1), card[selected[i]].get(2), card[selected[i]].get(3));
                    sum += t1;
                    sum += d;
                } else {
                    r = card[selected[i]].get(0);
                    c = card[selected[i]].get(1);
                    int d = bfs(cBoard, card[selected[i]].get(2), card[selected[i]].get(3), card[selected[i]].get(0), card[selected[i]].get(1));
                    sum += t2;
                    sum += d;
                }

                cBoard[card[selected[i]].get(0)][card[selected[i]].get(1)] = 0;
                cBoard[card[selected[i]].get(2)][card[selected[i]].get(3)] = 0;
            }

            answer = Math.min(answer, sum);

            for(int i = 1; i < selected.length; i++) {
                cBoard[card[selected[i]].get(0)][card[selected[i]].get(1)] = selected[i];
                cBoard[card[selected[i]].get(2)][card[selected[i]].get(3)] = selected[i];
            }
        }

        for(int i = 1; i <= len; i++) {
            if(dVisited[i]) continue;
            selected[depth] = i;
            dVisited[i] = true;
            recursion(selected, dVisited,depth+1, len);
            dVisited[i] = false;
            selected[depth] = 0;
        }
    }

    public int bfs(int[][] board, int startY, int startX, int endY, int endX) {
        Queue<Integer> queue = new LinkedList<>();
        int[][] cnt = new int[4][4];
        boolean[][] visited = new boolean[4][4];
        queue.add(startY);
        queue.add(startX);
        cnt[startY][startX] = 0;
        visited[startY][startX] = true;

        while(!queue.isEmpty()) {
            int y = queue.poll();
            int x = queue.poll();

            for(int i = 0; i < 4; i++) {
                int ty = y + dy[i];
                int tx = x + dx[i];
                if(!isValid(ty, tx)) continue;
                if(visited[ty][tx]) continue;
                queue.add(ty);
                queue.add(tx);
                cnt[ty][tx] = cnt[y][x] + 1;
                visited[ty][tx] = true;
            }

            for(int i = 0; i < 4; i++) {
                int ty = y;
                int tx = x;
                while(true) {
                    if(!isValid(ty+dy[i], tx+dx[i])) break;
                    ty += dy[i];
                    tx += dx[i];
                    if(board[ty][tx] >= 1) break;
                }
                if(visited[ty][tx]) continue;
                queue.add(ty);
                queue.add(tx);
                cnt[ty][tx] = cnt[y][x] + 1;
                visited[ty][tx] = true;
            }
        }
        return cnt[endY][endX];
    }

    public boolean isValid(int y, int x) {
        if(y < 0 || x < 0 || y >= 4 || x >= 4) {
            return false;
        }
        return true;
    }
}
