package BAEKJOON_Algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3_7795 {
    static StringBuilder sb = new StringBuilder();
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i <T; i++) {
            int ans = 0;
            String str = br.readLine();
            st = new StringTokenizer(str, " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] A = new int[N+1];
            int[] B = new int[M+1];
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for (int j = 1; j <= N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            for (int j = 1; j <= M; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(A);
            Arrays.sort(B);
            for (int j = 1; j <=N; j++) {
                ans +=binarySearch(B, 1,M, A[j]);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }

    // 배열 B에서 X 미만의 수(X 보다 작은 수) 중 제일 오른쪽 인덱스를 return 하는 함수
    // 그런 게 없다면 L - 1을 return 한다.
    static int binarySearch(int[] B, int L, int R, int X) {
        int result = L-1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if(B[mid] < X) {
                result = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return result;
    }
}
