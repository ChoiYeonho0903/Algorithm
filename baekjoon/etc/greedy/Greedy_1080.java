package baekjoon.etc.greedy;

import java.util.Scanner;

public class Greedy_1080 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int [][] A = new int[N][M];
        int [][] B = new int[N][M];
        String tmp;
        int count = 0;
        for (int i = 0; i <N; i++) {
            tmp = scanner.next();
            for (int j = 0; j <M; j++) {
                A[i][j] = Character.getNumericValue(tmp.charAt(j));
            }
        }
        for (int i = 0; i <N; i++) {
            tmp = scanner.next();
            for (int j = 0; j <M; j++) {
                B[i][j] = Character.getNumericValue(tmp.charAt(j));
            }
        }
        if(N<3 || M <3) {
            for (int i = 0; i <N; i++) {
                for (int j = 0; j <M; j++) {
                    if(A[i][j]!=B[i][j]) {
                        count = -1;
                        System.out.println(count);
                        return;
                    }
                }
            }
        }
        else {
            for (int i = 0; i <N; i++) {
                for (int j = 0; j <M; j++) {
                    if(A[i][j]!=B[i][j]) {
                        if(i<N-2 && j<M-2) {
                            for (int k = i; k < i+3; k++) {
                                for (int l = j; l < j+3; l++) {
                                    if(A[k][l]==1)
                                        A[k][l]=0;
                                    else
                                        A[k][l]=1;
                                }
                            }
                            count++;
                        }
                        else {
                            count = -1;
                            System.out.println(-1);
                            return;
                        }
                    }

                }
            }
        }
        System.out.println(count);
    }
}
