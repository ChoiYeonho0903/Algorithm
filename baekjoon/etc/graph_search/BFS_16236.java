package baekjoon.etc.graph_search;

import java.util.*;

public class BFS_16236 {
    static int N;
    static int [][] map;
    static boolean [][] visited;
    static Fish shark;
    static int size;
    static int eatNum;
    static int ans;
    static ArrayList<Fish> feed = new ArrayList<>();
    static int [] dx = {0, 0, 1, -1};
    static int [] dy = {1, -1, 0, 0};

    static void bfs() {
        Queue<Fish> queue = new LinkedList<>();
        visited = new boolean[N][N];

        visited[shark.y][shark.x] = true;
        queue.add(new Fish(shark.y, shark.x, 0));

        while(!queue.isEmpty()) {
            Fish current = queue.poll();
            for (int i = 0; i <4; i++) {
                int tdx = current.x + dx[i];
                int tdy = current.y + dy[i];

                //map 범위 벗어난것
                if(tdx<0 || tdy<0 || tdx>=N || tdy>=N) continue;
                //방분한 위치
                if(visited[tdy][tdx]) continue;

                //크기가 작은 물고기 발견
                if(map[tdy][tdx] != 0 && map[tdy][tdx] < size) {
                    visited[tdy][tdx] = true;
                    queue.add(new Fish(tdy, tdx, current.count + 1));
                    feed.add(new Fish(tdy, tdx, current.count + 1));
                }
                //빈칸이거나 물고기 크기가 같을 때
                else if(map[tdy][tdx] == 0 || map[tdy][tdx] == size) {
                    visited[tdy][tdx] = true;
                    queue.add(new Fish(tdy, tdx, current.count+1));
                }
            }
        }
    }

    static void eat() {
        //먹기
        Collections.sort(feed, new Comparator<Fish>() {
            @Override
            public int compare(Fish fish1, Fish fish2) {
                if(fish1.count == fish2.count) {
                    if(fish1.y == fish2.y) {
                        if(fish1.x > fish2.x)
                            return 1;
                        else
                            return -1;
                    }
                    else {
                        if(fish1.y > fish2.y)
                            return 1;
                        else
                            return -1;
                    }
                }
                else if(fish1.count > fish2.count)
                    return 1;
                else
                    return -1;
            }
        });

        //최적의 물고기 선택
       Fish choice = feed.get(0);
       map[choice.y][choice.x] = 0;
       ans += choice.count;

        //fish 위치 바꿔주기
        shark = new Fish(choice.y, choice.x, 0);

        //사이즈 변경
        eatNum++;
        if(eatNum >= size) {
            size++;
            eatNum = 0;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        map = new int[N][N];
        for (int i = 0; i <N; i++) {
            for (int j = 0; j <N; j++) {
                map[i][j] = scanner.nextInt();
                if(map[i][j] == 9) {
                    shark = new Fish(i, j,0);
                    map[i][j] = 0;
                    size = 2;
                    eatNum = 0;
                }
            }
        }

        while(true) {
            bfs();

            if(!feed.isEmpty()) {
                eat();

                feed.clear();
            }
            else
                break;
        }

        System.out.println(ans);
    }

    private static class Fish {
        int x;
        int y;
        int count;

        public Fish(int y, int x, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }
}
