package BAEKJOON_Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Pair implements Comparable<Pair>{
    private Integer start;
    private Integer finish;
    public Pair(Integer start, Integer finish) {
        this.start = start;
        this.finish = finish;
    }
    public Integer first() {
        return start;
    }
    public Integer second() {
        return finish;
    }

    @Override
    public int compareTo(Pair pair) {
        if(this.finish == pair.finish) {
            return start.compareTo(pair.first());
        }
        else
            return finish.compareTo(pair.second());
    }
}
public class Greedy_1931 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        ArrayList<Pair> pair = new ArrayList<Pair>();
        int last =0;
        int count=0;
        for(int i=0; i<N; i++) {
            pair.add(new Pair(scan.nextInt(), scan.nextInt()));
        }
        Collections.sort(pair);

        for(int i=0; i<N; i++) {
            if(last<=pair.get(i).first()){
                count++;
                last = pair.get(i).second();
            }
        }
        System.out.println(count);
    }
}
