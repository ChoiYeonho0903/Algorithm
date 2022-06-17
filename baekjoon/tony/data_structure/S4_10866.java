package baekjoon.tony.data_structure;

import java.util.*;
import java.io.*;

public class S4_10866 {
    static StringBuilder sb = new StringBuilder();
    static Deque<Integer> deque = new LinkedList<>();
    static int N;

    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            String command = st.nextToken();
            switch (command) {
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    if(deque.size() == 0) {
                        sb.append(-1).append("\n");
                    } else {
                        Integer pollFirst = deque.pollFirst();
                        sb.append(pollFirst).append("\n");
                    }
                    break;
                case "pop_back":
                    if(deque.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        Integer pollLast = deque.pollLast();
                        sb.append(pollLast).append("\n");
                    }
                    break;
                case "size":
                    sb.append(deque.size()).append("\n");
                    break;
                case "empty":
                    if(deque.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;
                case "front":
                    if(deque.size() == 0) {
                        sb.append(-1).append("\n");
                    } else {
                        Integer peekFirst = deque.peekFirst();
                        sb.append(peekFirst).append("\n");
                    }
                    break;
                case "back":
                    if(deque.size() == 0) {
                        sb.append(-1).append("\n");
                    } else {
                        Integer peekLast = deque.peekLast();
                        sb.append(peekLast).append("\n");
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.print(sb);
    }
}
