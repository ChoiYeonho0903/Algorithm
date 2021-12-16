package ETC.SDS_Algorithm;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Test2 {
    static int T;
    static int N;
    static String [] card;
    static int [] ans;
    static boolean [] visited;
    static ArrayList<Card> arrayList;
    static Stack<Card> stack = new Stack<>();
    static int max = 0;
    static boolean set(String A, String B, String C) {
        for (int i = 0; i <A.length(); i++) {
            if(A.charAt(i) == B.charAt(i) && B.charAt(i) != C.charAt(i))
                return false;
            else if(B.charAt(i) == C.charAt(i) && A.charAt(i) != B.charAt(i))
                return false;
            else if(A.charAt(i) == C.charAt(i) && C.charAt(i) != B.charAt(i))
                return false;
        }
        return true;
    }
    static void dfs(int index) {
        if(max>=N/3) {
            return;
        }
        if(max < stack.size()) {
            max = stack.size();
            if(max>=N/3) {
                return;
            }
        }
        for (int i = index; i <arrayList.size(); i++) {
            Card tmp = arrayList.get(i);
            if(!visited[tmp.index1] && !visited[tmp.index2] && !visited[tmp.index3]) {
                visited[tmp.index1] = true;
                visited[tmp.index2] = true;
                visited[tmp.index3] = true;
                stack.add(tmp);
                dfs(i+1);
                stack.pop();
                visited[tmp.index1] = false;
                visited[tmp.index2] = false;
                visited[tmp.index3] = false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        ans = new int[T];
        for (int i = 0; i <T; i++) {
            N = scanner.nextInt();
            card = new String[N];
            visited = new boolean[N];
            for (int j = 0; j <N; j++) {
                card[j] = scanner.next();
            }
            arrayList = new ArrayList<>();
            for (int j = 0; j <N; j++) {
                for (int k = j+1; k <N; k++) {
                    for (int l = k+1; l <N; l++) {
                        if(set(card[j], card[k], card[l])) {
                            arrayList.add(new Card(j, k, l));
                        }
                    }
                }
            }
            max = 0;
            dfs(0);
            ans[i] = max;
        }
        for (int i = 0; i <ans.length; i++) {
            System.out.println("#"+(i+1)+" "+ans[i]);
        }
    }
    public static class Card {
        int index1;
        int index2;
        int index3;

        public Card(int index1, int index2, int index3) {
            this.index1 = index1;
            this.index2 = index2;
            this.index3 = index3;
        }
    }
}
