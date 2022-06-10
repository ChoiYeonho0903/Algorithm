package baekjoon.etc.greedy;

import java.util.*;

class Jewelry implements Comparable<Jewelry> {
    int weight;
    int price;

    Jewelry(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    @Override
    public int compareTo(Jewelry j) {
        return this.weight - j.weight;
    }
}

public class Greedy_1202 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        Jewelry [] jewelry = new Jewelry[N];
        int [] bag = new int[K];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        long ans=0;
        int j =0;
        for (int i = 0; i <N; i++) {
            jewelry[i] = new Jewelry(scanner.nextInt(), scanner.nextInt());
        }
        for (int i = 0; i <K; i++) {
            bag[i] = scanner.nextInt();
        }
        Arrays.sort(jewelry);
        Arrays.sort(bag);
        for (int i = 0; i <K; i++) {
            while(j<N && jewelry[j].weight <= bag[i]) {
                priorityQueue.add(jewelry[j++].price);
            }
            if(!priorityQueue.isEmpty()){
                ans+=priorityQueue.poll();
            }
        }
        System.out.println(ans);
    }
}
