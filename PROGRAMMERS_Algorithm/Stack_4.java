package PROGRAMMERS_Algorithm;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class Stack_4 {
    static int[] prices = {1, 2, 3, 2, 3};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(prices)));
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int time = 0;
        Stack<Stock> stack = new Stack<>();
        Iterator<Stock> iterator = null;
        stack.add(new Stock(prices[0], 1));
        time++;
        for (int i = 1; i <prices.length; i++) {
            time++;
            while(true) {
                if(stack.isEmpty() || stack.peek().price <= prices[i]) {
                    stack.add(new Stock(prices[i], time));
                    break;
                }
                else {
                    Stock pop = stack.pop();
                    answer[pop.s_time-1] = time - pop.s_time;
                }
            }
        }
        while(!stack.isEmpty()) {
            Stock tmp = stack.pop();
            answer[tmp.s_time-1] = time - tmp.s_time;
        }
        return answer;
    }
    static private class Stock {
        private int price;
        private int s_time;

        public Stock(int price, int s_time) {
            this.price = price;
            this.s_time = s_time;
        }
    }
}
