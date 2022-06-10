package baekjoon.fastcampus.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2470 {
    static int N;
    static int[] solution;
    static int[] ans = new int[2];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int range;
        int min = Integer.MAX_VALUE;
        N = Integer.parseInt(br.readLine());
        solution = new int[N+1];
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        for (int i = 1; i <=N; i++) {
            solution[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(solution, 1, N+1);
        for (int i = 1; i <=N; i++) {
            int tmp;
            int result = binarySearch(solution, i+1, N, solution[i]*(-1));
            if (i + 1 <= result-1 && result-1 <= N && Math.abs(solution[result-1] + solution[i]) < min) {
                min = Math.abs(solution[result-1] + solution[i]);
                ans[0] = solution[i];
                ans[1] = solution[result-1];
            }

            if (i + 1 <= result && result <= N && Math.abs(solution[result] + solution[i]) < min) {
                min = Math.abs(solution[result] + solution[i]);
                ans[0] = solution[i];
                ans[1] = solution[result];
            }
        }
        System.out.println(ans[0]+" "+ans[1]);
    }

    //A[L...R]에서 X 이상의 수 중 제일 왼쪽 인덱스를 return 하는 함수
    static int binarySearch(int[] A, int L, int R, int X) {
        int result = R+1;
        while(L<=R) {
            int mid = (L + R)/2;
            if(A[mid] >= X) {
                result = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }
        return result;
    }
}
