package BAEKJOON_Algorithm;

import java.util.Scanner;

public class BF_15649 {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        arr = new int[M];
        visited = new boolean[N+1];
        backtracking(0);

    }

    static void backtracking(int k) {
        if(k == M) {
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println("");
            return;
        }
        else {
            for (int i = 1; i <=N; i++) {
                if(!visited[i]) {
                    arr[k] = i;
                    visited[i] = true;
                    backtracking(k+1);
                    visited[i] = false;
                }
            }
        }
        return;
    }
}
