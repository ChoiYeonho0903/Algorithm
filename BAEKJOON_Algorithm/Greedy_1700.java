package BAEKJOON_Algorithm;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Greedy_1700 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int [] use = new int[K+1];
        int tmp, maxc, count;
        int maxu = 0;
        int ans = 0;
        for (int i = 1; i<=K; i++) {
            tmp = scanner.nextInt();
            use[i] = tmp;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <=K; i++) {
            if(set.size()<N) {
                set.add(use[i]);
            }
            else {
                if(set.contains(use[i])) {
                    continue;
                }

                Iterator<Integer> iter = set.iterator();
                maxc = 0;
                while(iter.hasNext()) {
                    tmp = iter.next();
                    count =1;
                    for (int j = i+1; j <=K; j++) {
                        if(tmp==use[j]) {
                            break;
                        }
                        count++;
                    }
                    if(maxc<count) {
                        maxu = tmp;
                        maxc = count;
                    }
                }
                set.remove(maxu);
                ans++;
                set.add(use[i]);
            }
        }
        System.out.println(ans);
    }
}
