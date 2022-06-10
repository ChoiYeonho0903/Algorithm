package baekjoon.fastcampus.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G5_1068 {
    static int N;
    static ArrayList<Integer>[] lists;
    static int erase;
    static int root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        lists = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            lists[i] = new ArrayList<>();
        }
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x == -1) {
                root = i;
            } else {
                lists[x].add(i);
            }
        }
        erase = Integer.parseInt(br.readLine());
        int ans = dfs(root);
        System.out.println(ans);
    }

    static int dfs (int x) {
        int sum = 0;
        if (x == erase) {
            return 0;
        }
        if (lists[x].size() == 0) {
            return 1;
        }
        for (int i = 0; i < lists[x].size(); i++) {
            sum += dfs(lists[x].get(i));
        }
        if (sum == 0) sum = 1;
        return sum;
    }
}
