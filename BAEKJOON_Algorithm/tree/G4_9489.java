package BAEKJOON_Algorithm.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G4_9489 {
    static StringBuilder sb = new StringBuilder();
    static int n;
    static int k;
    static ArrayList<Integer>[][] lists;
    static int sibling;
    static int depth;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            if (n == 0 && k == 0) break;
            lists = new ArrayList[n+1][];
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            int i = 1;
            int count = 1;
            int previous = Integer.parseInt(st.nextToken());
            int size = 1;
            int total = 0;
            lists[i] = new ArrayList[size];
            for (int j = 0; j < size; j++) {
                lists[i][j] = new ArrayList<>();
            }
            lists[i][count-1].add(previous);

            while (st.hasMoreTokens()) {
                int current = Integer.parseInt(st.nextToken());
                if (current - previous != 1) {
                    total += lists[i][count-1].size();
                    count++;
                    if (count > size) {
                        size = total;
                        total = 0;
                        i++;
                        lists[i] = new ArrayList[size];
                        for (int j = 0; j < size; j++) {
                            lists[i][j] = new ArrayList<>();
                        }
                        count = 1;
                    }
                }
                lists[i][count-1].add(current);
                previous = current;
                if (current == k) {
                    depth = i;
                    sibling = count-1;
                }
            }
            int sum = 0;
            if (depth != 0) {
                for (int j = 0; j < lists[depth].length; j++) {
                    if (sibling == j) continue;
                    sum += lists[depth][j].size();
                }
            }
            sb.append(sum).append("\n");
        }
        System.out.print(sb);
    }
}
