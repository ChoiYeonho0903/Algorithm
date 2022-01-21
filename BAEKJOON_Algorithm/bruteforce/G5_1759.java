package BAEKJOON_Algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//중복X, 순서O(조건)
public class G5_1759 {
    static int L;
    static int C;
    static char[] character;
    static int[] selected;
    static StringBuffer sb = new StringBuffer();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str = br.readLine();
        st = new StringTokenizer(str, " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        character = new char[C+1];
        selected = new int[L+1];
        str = br.readLine();
        st = new StringTokenizer(str, " ");
        for (int i = 1; i <=C; i++) {
            character[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(character);
        rec_func(1, 0);
        System.out.println(sb);
    }

    static void rec_func(int depth, int vowel) {
        if(depth==L+1) {
            if(vowel>=1 && L-vowel>=2) {
                for (int i = 1; i <= L; i++) {
                    sb.append(character[selected[i]]);
                }
                sb.append("\n");
            }
        } else {
            for (int i = selected[depth-1]+1; i <= C; i++) {
                selected[depth] = i;
                if (isVowel(character[i])) {
                    rec_func(depth+1, vowel+1);
                } else {
                    rec_func(depth+1, vowel);
                }
                selected[depth] = 0;
            }
        }
    }

    static boolean isVowel(char character) {
        if (character == 'a') {
            return true;
        }
        if (character == 'e') {
            return true;
        }
        if (character == 'i') {
            return true;
        }
        if (character == 'o') {
            return true;
        }
        if (character == 'u') {
            return true;
        }
        return false;
    }
}
