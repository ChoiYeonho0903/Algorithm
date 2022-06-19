package baekjoon.tony.data_structure;

import java.io.*;
import java.util.*;

public class S3_2346 {
    static StringBuilder sb = new StringBuilder();
    static Deque<Balloon> deque = new ArrayDeque<>();
    static int N;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for(int i = 0; i < N; i++) {
            deque.add(new Balloon(i+1, Integer.parseInt(st.nextToken())));
        }

        Balloon balloon = deque.pollFirst();
        int move = balloon.num;
        sb.append(balloon.index).append(" ");

        while(!deque.isEmpty()) {
            if(move > 0) {
                while(move > 1) {
                    Balloon poll = deque.pollFirst();
                    deque.addLast(poll);
                    move--;
                }
                Balloon poll = deque.pollFirst();
                move = poll.num;
                sb.append(poll.index).append(" ");
            } else {
                while(move < -1) {
                    Balloon poll = deque.pollLast();
                    deque.addFirst(poll);
                    move++;
                }
                Balloon poll = deque.pollLast();
                move = poll.num;
                sb.append(poll.index).append(" ");
            }
        }
        System.out.println(sb);
    }

    static class Balloon {
        int index;
        int num;

        public Balloon(int index, int num) {
            this.index = index;
            this.num = num;
        }
    }
}
