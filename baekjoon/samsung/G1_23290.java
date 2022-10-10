package baekjoon.samsung;

import java.util.*;
import java.io.*;

public class G1_23290 {
    static int M;
    static int S;
    static int[][] dir = {{0,0}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    static int[][] sDir = {{-1,0}, {0,-1}, {1,0}, {0,1}};
    static Cell[][] cells = new Cell[5][5];
    static Cell[][] newCells;
    static int sX;
    static int sY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        cells = new Cell[5][5];
        for(int i = 1; i <= 4; i++) {
            for(int j = 1; j <= 4; j++) {
                cells[i][j] = new Cell(0);
            }
        }

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        M = Integer.parseInt(st.nextToken()); // 물고기의 수
        S = Integer.parseInt(st.nextToken()); // 마법 연습 횟수
        for(int i = 0; i < M; i++) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            cells[x][y].fishList.add(d);
        }
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        sX = Integer.parseInt(st.nextToken());
        sY = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= S; i++) {
            // 1. 물고기 칸 이동
            moveFish();

            // 2. 상어 이동
            moveShark(i);

            // 3. 두 번 전 연습에서 생긴 물고기의 냄새 삭제
            deodorize(i);

            // 4. 물고기 복제
            copy();

//            System.out.println(i+"번째");
//            for(int j = 1; j <= 4; j++) {
//                for(int k = 1; k <= 4; k++) {
//                    System.out.print(cells[j][k].fishList.size()+","+cells[j][k].fishSmell+" ");
//                }
//                System.out.println();
//            }
//            System.out.println(sX + " " + sY);
//            System.out.println();
        }

        int ans = 0;
        for(int i = 1; i <= 4; i++) {
            for(int j = 1; j <= 4; j++) {
                ans += cells[i][j].fishList.size();
            }
        }

        System.out.println(ans);
    }

    public static void moveFish() {
        newCells = new Cell[5][5];
        for(int i = 1; i <= 4; i++) {
            for(int j = 1; j <= 4; j++) {
                newCells[i][j] = new Cell(0);
            }
        }
        for(int i = 1; i <= 4; i++) {
            for(int j = 1; j <= 4; j++) {
                if(cells[i][j].fishList.size() != 0) {
                    for(int d : cells[i][j].fishList) {
                        int tx = 0;
                        int ty = 0;
                        int td = 0;
                        boolean flag = false;
                        // 이동할 수 없는 경우 방향을 45도씩 반시계 방향으로 회전
                        for(int k = 0; k < 8; k++) {
                            td = d - k;
                            if(td <= 0) {
                                td += 8;
                            }
                            tx = i + dir[td][0];
                            ty = j + dir[td][1];
                            // 격자 범위를 벗어나는 칸
                            if(isOutOfBounds(tx, ty)) continue;
                            // 상어가 있는 칸
                            if(isShark(tx, ty)) continue;
                            // 물고기 냄새가 있는 칸
                            if(isFishSmell(tx, ty)) continue;
                            flag = true;
                            break;
                        }

                        if(flag) {
                            newCells[tx][ty].fishList.add(td);
                        } else {
                            // 이동할 수 없는 경우 제자리에 있는다.
                            newCells[i][j].fishList.add(d);
                        }
                    }
                }
            }
        }
    }

    public static void deodorize(int time) {
        for(int i = 1; i <= 4; i++) {
            for(int j = 1; j <= 4; j++) {
                if(cells[i][j].fishSmell != 0) {
                   if(time - cells[i][j].fishSmell >= 2) {
                       cells[i][j].fishSmell = 0;
                   }
                }
            }
        }
    }

    static long maxSum;
    static int[][] maxSelected;

    public static void moveShark(int time) {
        maxSum = -1;
        maxSelected = new int[3][2];
        int[][] selected = new int[3][2];
//        boolean[][] visited= new boolean[5][5];
        dfs(0, sX, sY, selected);

        for(int i = 0; i < 3; i++) {
            if(newCells[maxSelected[i][0]][maxSelected[i][1]].fishList.size() != 0) {
                // 제외되는 물고기는 물고기 냄새를 남긴다.
                newCells[maxSelected[i][0]][maxSelected[i][1]].fishSmell = time;

                // 상어가 물고기가 잇는 같은 칸으로 이동하게 되면, 그 칸에 있는 모든 물고기는 격자에서 제외
                newCells[maxSelected[i][0]][maxSelected[i][1]].fishList.clear();
            }
        }

        // 상어 이동
        sX = maxSelected[2][0];
        sY = maxSelected[2][1];
    }

    public static void dfs(int depth, int x, int y, int[][] selected) {
        // 연속해서 3칸을 이동한다.
        if(depth == 3) {
            long sum = 0;
            boolean[][] visited = new boolean[5][5];
            for(int i = 0; i < 3; i++) {
                if(visited[selected[i][0]][selected[i][1]]) continue;
                visited[selected[i][0]][selected[i][1]] = true;
                sum += newCells[selected[i][0]][selected[i][1]].fishList.size();
            }

            // 제외되는 물고기의 수가 가장 많은 방법으로 이동
            if (maxSum < sum) {
                maxSum = sum;
                for(int j = 0; j < 3; j++) {
                    maxSelected[j][0] = selected[j][0];
                    maxSelected[j][1] = selected[j][1];
                }
            }
            return;
        }

        // 여러가지인 경우 사전 순으로 가장 앞서는 방법을 이용
        for(int i = 0; i < 4; i++) {
            int tx = x + sDir[i][0];
            int ty = y + sDir[i][1];
            if(isOutOfBounds(tx, ty)) continue;
            selected[depth][0] = tx;
            selected[depth][1] = ty;
            dfs(depth+1, tx, ty, selected);
            selected[depth][0] = 0;
            selected[depth][1] = 0;
        }
    }

    public static void copy() {
        for(int i = 1; i <= 4; i++) {
            for(int j = 1; j <= 4; j++){
                for(int d : newCells[i][j].fishList) {
                    cells[i][j].fishList.add(d);
                }
                if(newCells[i][j].fishSmell != 0) {
                    cells[i][j].fishSmell = newCells[i][j].fishSmell;
                }
            }
        }
    }

    public static boolean isShark(int x, int y) {
        if(x == sX && y == sY) {
            return true;
        }
        return false;
    }

    public static boolean isFishSmell(int x, int y) {
        if(cells[x][y].fishSmell != 0) {
            return true;
        }
        return false;
    }

    public static boolean isOutOfBounds(int x, int y) {
        if (x < 1 || y < 1 || x > 4 || y > 4) {
            return true;
        }
        return false;
    }

    static class Cell {
        int fishSmell;
        ArrayList<Integer> fishList = new ArrayList<>();

        public Cell(int fishSmell) {
            this.fishSmell = fishSmell;
        }
    }
}