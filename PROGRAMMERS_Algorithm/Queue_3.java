package PROGRAMMERS_Algorithm;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Queue_3 {
    static int bridge_length = 100;
    static int weight = 100;
    static int[] truck_weights = {10,10,10,10,10,10,10,10,10,10};
    public static void main(String[] args) {
        System.out.println(solution(bridge_length, weight, truck_weights));
    }
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int total_weight = 0;
        Queue<Truck> queue = new LinkedList<>();
        Queue<Truck> i_queue = new LinkedList<>();
        Iterator<Truck> iterator = null;
        for (int i = 0; i <truck_weights.length; i++) {
            queue.add(new Truck(truck_weights[i], 0));
        }
        Truck truck = queue.poll();
        truck.current_position++;
        i_queue.add(truck);
        answer++;
        total_weight += truck.weight;
        while(!i_queue.isEmpty()) {
            answer++;
            iterator = i_queue.iterator();
            while(iterator.hasNext()) {
                Truck current = iterator.next();
                current.current_position++;
                if(current.current_position>bridge_length) {
                    iterator.remove();
                    total_weight -= current.weight;
                }
            }
            if(!queue.isEmpty()) {
                if (queue.peek().weight + total_weight <= weight) {
                    truck = queue.poll();
                    truck.current_position++;
                    total_weight += truck.weight;
                    i_queue.add(truck);
                } else continue;
            }
        }
        return answer;
    }
    private static class Truck {
        int weight;
        int current_position;

        public Truck(int weight, int current_position) {
            this.weight = weight;
            this.current_position = current_position;
        }
    }
}
