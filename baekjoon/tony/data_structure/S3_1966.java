package baekjoon.tony.data_structure;

import java.util.*;
import java.io.*;

public class S3_1966 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            Queue<Document> queue = new LinkedList<>();

            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for(int j = 0; j < N; j++) {
                queue.add(new Document(j, Integer.parseInt(st.nextToken())));
            }

            int count = 0;

            while(true) {
                Document poll = queue.poll();
                boolean tf = false;
                for(Document document : queue) {
                    if(document.importance > poll.importance) {
                        tf = true;
                        break;
                    }
                }
                if(tf) {
                    queue.add(poll);
                } else {
                    count++;
                    if(poll.index == M) {
                        break;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    static class Document {
        int index;
        int importance;

        public Document(int index, int importance) {
            this.index = index;
            this.importance = importance;
        }
    }
}
