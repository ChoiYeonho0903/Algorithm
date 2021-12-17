package ETC.SDS_Algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Test1 {
    static int T;
    static int N;
    static int [] ans;
    static int [] card;
    static boolean [] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        ans = new int[T];
        for (int i = 0; i <T; i++) {
            N = scanner.nextInt();
            card = new int[N];
            visited = new boolean[N];
            for (int j = 0; j <N; j++) {
                card[j] = scanner.nextInt();
            }
            Arrays.sort(card);
            for (int j = N-1; j>=0; j--) {
                if(visited[j]) continue;
                visited[j] = true;
                boolean tf = false;
                int num = 0;
                int index = 0;
                if(card[j]%2==0) { //짝수
                    for (int k = 0; k <N; k++) {
                        if(visited[k]) continue;
                        if(card[k]%2==0) {
                            visited[k] = true;
                            tf = true;
                            break;
                        }
                        else {
                            num = card[k];
                            index = k;
                        }
                    }
                }
                else { //홀수
                    for (int k = 0; k <N; k++) {
                        if(visited[k]) continue;
                        if(card[k]%2!=0) {
                            visited[k] = true;
                            tf = true;
                            break;
                        }
                        else {
                            num = card[k];
                            index = k;
                        }
                    }
                }
                if(tf) {
                    ans[i] += card[j];
                }
                else {
                    ans[i] += num;
                    visited[index] = true;
                }
            }
        }
        for (int i = 0; i <ans.length; i++) {
            System.out.println("#"+(i+1)+" "+ans[i]);
        }
    }
}
