package baekjoon.fastcampus2.sort;

import java.util.*;
import java.io.*;

public class S4_15970 {
    static int N;
    static Dot[] dots;
    static int sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        dots = new Dot[N+1];
        for(int i = 1; i <= N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            dots[i] = new Dot();
            dots[i].position = Integer.parseInt(st.nextToken());
            dots[i].color = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(dots, 1, N+1);

        for(int i = 1; i <= N; i++) {
            int position = dots[i].position;
            int color = dots[i].color;
            int min = Integer.MAX_VALUE;
            if(i-1 >= 1) {
                if(color == dots[i-1].color) {
                    int tmp = position - dots[i-1].position;
                    if(tmp < min) {
                        min = tmp;
                    }
                }
            }
            if(i+1 <= N) {
                if(color == dots[i+1].color) {
                    int tmp = dots[i+1].position - position;
                    if(tmp < min) {
                        min = tmp;
                    }
                }
            }
            sum += min;
        }

        System.out.println(sum);
    }

    static class Dot implements Comparable<Dot>{
        int position;
        int color;

        @Override
        public int compareTo(Dot d) {
            if(this.color != d.color) {
                return this.color - d.color;
            }
            return this.position - d.position;
        }
    }
}
