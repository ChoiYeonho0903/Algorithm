package BAEKJOON_Algorithm;

import java.util.Scanner;

public class STRING_2941 {
    static String [] alpa = {"c=", "c-","dz=", "d-", "lj", "nj", "s=", "z="};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int ans = 0;
        int start = 0;
        int end = 0;
        while(true) {
            boolean tf = false;
            for (int i = 0; i <alpa.length; i++) {
                end = start + alpa[i].length();
                if(str.length()-end<0)
                    continue;
                if(str.substring(start, end).equals(alpa[i])) {
                    tf = true;
                    start += alpa[i].length();
                    break;
                }
            }
            if(!tf) {
                start += 1;
            }
            ans++;
            if(start==str.length())
                break;
        }
        System.out.println(ans);
    }
}
