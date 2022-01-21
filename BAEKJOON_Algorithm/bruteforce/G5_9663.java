package BAEKJOON_Algorithm.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class G5_9663 {
    static int N;
    static int count;
    static ArrayList<Integer> selectedX = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        rec_func(0);
        System.out.println(count);
    }

    static void rec_func(int depth) {
        if(depth == N) {
            count++;
        } else {
            for (int i = 0; i < N; i++) {
                if(promise(depth, i)) {
                    selectedX.add(i);
                    rec_func(depth+1);
                    selectedX.remove(selectedX.size()-1);
                }
            }
        }
    }

    static boolean promise(int y, int x) {
        for (int i = 0; i <selectedX.size(); i++) {
            if(selectedX.get(i) == x) {
                return false;
            }
            if (Math.abs(i - y) == Math.abs(selectedX.get(i) - x)) {
                    return false;
            }
        }
        return true;
    }
}
