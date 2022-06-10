package baekjoon.etc.string;

import java.util.ArrayList;
import java.util.Scanner;

public class STRING_1316 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String [] str = new String[N];
        int ans = 0;
        for (int i = 0; i <N; i++) {
            str[i] = scanner.next();
            ArrayList<Character> arrayList = new ArrayList<>();
            char previous = str[i].charAt(0);
            char current;
            Boolean tf = true;
            for (int j = 1; j <str[i].length(); j++) {
                current = str[i].charAt(j);
                if(previous == current)
                    continue;
                else {
                    for (int k = 0; k <arrayList.size(); k++) {
                        if(arrayList.get(k)==current || arrayList.get(k)==previous) {
                            tf = false;
                            break;
                        }
                    }
                }
                if(!tf)
                    break;
                else {
                    arrayList.add(previous);
                    previous = current;
                }
            }
            if(tf)
                ans++;
        }
        System.out.println(ans);
    }
}
