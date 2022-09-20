package PROGRAMMERS_Algorithm.kakao_2020;

import java.util.ArrayList;

public class Lv_3_2 {
    boolean[][] pillars; // 기둥
    boolean[][] beams; // 보
    public int[][] solution(int n, int[][] build_frame) {
        int[][] answer;
        pillars = new boolean[n+3][n+3];
        beams = new boolean[n+3][n+3];

        for(int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0] + 1;
            int y = build_frame[i][1] + 1;
            int a = build_frame[i][2];
            int b = build_frame[i][3];

            switch(b) {
                case 1:
                    switch (a) {
                        case 0:
                            if(canBuildPillar(x, y)) {
                                // System.out.println(x + " " + y);
                                pillars[x][y] = true;
                            }
                            break;
                        case 1:
                            if(canBuildBeam(x, y)) {
                                // System.out.println(x + " " + y);
                                beams[x][y] = true;
                            }
                            break;
                    }
                    break;
                case 0:
                    switch (a) {
                        case 0:
                            pillars[x][y] = false;
                            if(!canDestruct(x, y, n)) {
                                pillars[x][y] = true;
                            }
                            break;
                        case 1:
                            beams[x][y] = false;
                            if(!canDestruct(x, y, n)) {
                                beams[x][y] = true;
                            }
                            break;
                    }
                    break;
            }
        }

        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 1; i <= n+1; i++) {
            for(int j = 1; j <= n+1; j++) {
                if(pillars[i][j]) {
                    list.add(new int[]{i-1, j-1, 0});
                }
                if(beams[i][j]) {
                    list.add(new int[]{i-1, j-1, 1});
                }
            }
        }

        // System.out.println(list.size());
        answer = new int[list.size()][];
        for(int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public boolean canBuildPillar (int x, int y) {
        return y == 1 || pillars[x][y-1] || beams[x][y] || beams[x-1][y];
    }

    public boolean canBuildBeam (int x, int y) {
        return pillars[x][y-1] || pillars[x+1][y-1] || (beams[x-1][y] && beams[x+1][y]);
    }

    public boolean canDestruct (int x, int y, int n) {
        for(int i = 1; i <= n+1; i++) {
            for(int j = 1; j <= n+1; j++) {
                if(pillars[i][j] && !canBuildPillar(i, j)) {
                    return false;
                }
                if(beams[i][j] && !canBuildBeam(i, j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
