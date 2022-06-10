package baekjoon.etc.greedy;

import java.util.Scanner;

public class Greedy_1543 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String search = scanner.nextLine();
        int count = 0;
        for (int i = 0; i <str.length(); i++) {
            if(str.charAt(i) == search.charAt(0)) {
                for (int j = 0; j <search.length(); j++) {
                    try {
                        if(str.charAt(i+j) != search.charAt(j))
                            break;
                    }catch(StringIndexOutOfBoundsException e) {
                        break;
                    }

                    if(j==(search.length()-1)){
                        count++;
                        i+=(search.length()-1);
                    }
                }
            }
        }
        System.out.println(count);
    }
}
