package BAEKJOON_Algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5_1181 {
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Word[] words;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        words = new Word[N];
        for (int i = 0; i <N; i++) {
            String str = br.readLine();
            words[i] = new Word(str.length(), str);
        }
        Arrays.sort(words);
        for (int i = 1; i < N; i++) {
            if(words[i-1].value.equals(words[i].value)) {
                words[i].size = 0;
            }
        }
        for (int i = 0; i <N; i++) {
            if(words[i].size == 0) continue;
            sb.append(words[i].value).append("\n");
        }
        System.out.print(sb.toString());
    }

    static class Word implements Comparable{
        int size;
        String value;

        public Word(int size, String value) {
            this.size = size;
            this.value = value;
        }

        @Override
        public int compareTo(Object o) {
            Word w = (Word) o;
            if(this.size != w.size) {
                return this.size - w.size;
            } else {
                return this.value.compareTo(w.value);
            }
        }
    }
}
