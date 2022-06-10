package baekjoon.etc.greedy;

import java.util.ArrayList;
import java.util.Scanner;

public class Greedy_4796 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList ans = new ArrayList();
        int L;
        int P;
        int V;
        int sum =0;
        int casenum;
        while(true) {
            sum =0;
            L = scan.nextInt();
            P = scan.nextInt();
            V = scan.nextInt();
            if(L==0 && P==0 && V==0)
                break;
            sum += L*(V/P);
            if(V%P >= L)
                sum += L;
            else
                sum += V%P;
            ans.add(sum);
        }
        for (int i = 0; i < ans.size(); i++) {
            casenum = i+1;
            System.out.println("Case " + casenum + ": " + ans.get(i));
        }
    }
}
