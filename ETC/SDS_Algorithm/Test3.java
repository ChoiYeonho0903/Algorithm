package ETC.SDS_Algorithm;

import java.util.Scanner;

public class Test3 {
    static int T;
    static int N;
    static int [] ans;
    static int [] map;
    static int [] memorization;
    static int dp(int start_index) {
        memorization[start_index] = 0;
        int end_index = 0;
        if(start_index+16>=N) {
            end_index = N;
        }
        else {
            end_index = start_index+16;
        }
        int destination = start_index;
        for (int i = start_index+1; i<end_index; i++) {
            if(i-start_index<=6) {
                if(map[i]==2) {
                    memorization[i] = i-start_index+1;
                }
                else if(map[i]==3) {
                    memorization[i] = i-start_index;
                    destination=i;
                }
            }
            else {
                if(map[i]==2) {
                    int tmp = 0;
                    boolean tf = false;
                    for (int j = i-1; j >= i-6 ; j--) {
                        if(map[j]==2) {
                            tf = true;
                            tmp = j;
                        }
                    }
                    if(tf) {
                        memorization[i] = memorization[tmp] + i-tmp + 1;
                    }
                    else {
                        break;
                    }
                }
                else if(map[i]==3) {
                    int tmp = 0;
                    boolean tf = false;
                    for (int j = i; j >= i-6 ; j--) {
                        if(map[j]==2) {
                            tf = true;
                            tmp = j;
                        }
                    }
                    if(tf) {
                        memorization[i] = memorization[tmp] + i-tmp;
                        destination = i;
                    }
                    else
                        break;
                }
            }
        }
        return destination;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        ans = new int[T];
        for (int i = 0; i <T; i++) {
            N = scanner.nextInt();
            map = new int[N];
            int final_destination = 0;
            for (int j = 0; j <N; j++) {
                map[j] = scanner.nextInt();
                if(map[j]==3)
                    final_destination = j;

            }
            int destination = 0;
            memorization = new int[N];
            while(true) {
                int tmp = dp(destination);
                if(destination==tmp)
                    break;
                else {
                    destination = tmp;
                    ans[i] += memorization[destination];
                }
            }
            if(destination!=final_destination)
                ans[i]=-1;
        }
        for (int i = 0; i <ans.length; i++) {
            System.out.println("#"+(i+1)+" "+ans[i]);
        }
    }
}
