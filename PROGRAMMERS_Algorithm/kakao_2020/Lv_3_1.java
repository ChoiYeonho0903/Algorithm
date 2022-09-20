package PROGRAMMERS_Algorithm.kakao_2020;

public class Lv_3_1 {
    // key의 길이
    int M;
    // Lock의 길이
    int N;
    int len;
    public boolean solution(int[][] key, int[][] lock) {
        M = key.length;
        N = lock.length;

        // Lock의 크기 확장
        len = N + M * 2 - 2;
        int[][] extendLock = new int[len][len];

        // 확장된 Lock 배열에 기존 Lock 복사
        for(int i = M-1; i < M+N-1; i++) {
            for(int j = M-1; j < M+N-1; j++) {
                extendLock[i][j] = lock[i-M+1][j-M+1];
            }
        }

        for(int i = 0; i < 4; i++) {
            if(check(key, extendLock)) {
                return true;
            }
            key = rotate(key);
        }
        return false;
    }

    public boolean check (int[][] key, int[][] lock) {
        for(int i = 0; i < len-M+1; i++) {
            for(int j = 0; j < len-M+1; j++) {
                for(int m = i; m < i+M; m++) {
                    for(int n = j; n < j+M; n++) {
                        lock[m][n] += key[m-i][n-j];
                    }
                }
                if(isOpen(lock)) {
                    return true;
                }
                for(int m = i; m < i+M; m++) {
                    for(int n = j; n < j+M; n++) {
                        lock[m][n] -= key[m-i][n-j];
                    }
                }
            }
        }
        return false;
    }

    public boolean isOpen(int[][] sum) {
        for(int i = M-1; i < M+N-1; i++) {
            for(int j = M-1; j < M+N-1; j++) {
                if(sum[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public int[][] rotate (int[][] key) {
        int[][] rotation = new int[M][M];

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < M; j++) {
                rotation[j][M-i-1] = key[i][j];
            }
        }
        return rotation;
    }
}
