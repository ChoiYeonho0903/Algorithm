package baekjoon.fastcampus2.bruteforce;

import java.util.*;
import java.io.*;

public class G5_1759 {
    static StringBuilder sb = new StringBuilder();
    static int L;
    static int C;
    static String[] arr;
    static int[] selected;
    static int consonant; // 자음자
    static int vowel; // 모음자

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new String[C + 1];
        selected = new int[L + 1];

        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for (int i = 1; i <= C; i++) {
            arr[i] = st.nextToken();
        }
        Arrays.sort(arr, 1, C + 1);
        rec_func(1);
        System.out.print(sb);
    }

    static void rec_func(int depth) {
        if (depth == L + 1) {
            if(vowel < 1 || consonant < 2) {
                return;
            }
            for (int i = 1; i <= L; i++) {
                sb.append(arr[selected[i]]);
            }
            sb.append("\n");
        } else {
            for (int i = selected[depth - 1] + 1; i <= C; i++) {
                if (arr[i].equals("a") || arr[i].equals("e") || arr[i].equals("i") || arr[i].equals("o") || arr[i].equals("u")) {
                    vowel++;
                    selected[depth] = i;
                    rec_func(depth+1);
                    selected[depth] = 0;
                    vowel--;
                } else {
                    consonant++;
                    selected[depth] = i;
                    rec_func(depth+1);
                    selected[depth] = 0;
                    consonant--;
                }
            }
        }
    }
}
