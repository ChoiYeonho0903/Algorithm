package PROGRAMMERS_Algorithm.kakao_2019;

import java.util.ArrayList;
import java.util.Collections;

public class Lv3_1 {
    ArrayList<Integer> ans;
    ArrayList<Node> list = new ArrayList<>();
    public int[][] solution(int[][] nodeinfo) {

        for(int i = 0; i < nodeinfo.length; i++) {
            list.add(new Node(i+1, nodeinfo[i][1], nodeinfo[i][0], null, null));
        }

        // 정렬
        Collections.sort(list);

        Node root = list.get(0);
        for(int i = 1; i < list.size(); i++) {
            insertNode(root, list.get(i));
        }

        int[][] answer = new int[2][nodeinfo.length];
        ans = new ArrayList<>();
        preorder(root);
        answer[0] = ans.stream().mapToInt(Integer::intValue).toArray();
        ans = new ArrayList<>();
        postorder(root);
        answer[1] = ans.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public void insertNode(Node parent, Node child) {
        if(parent.x > child.x) {
            if(parent.left == null) {
                parent.left = child;
            } else {
                insertNode(parent.left, child);
            }
        } else {
            if(parent.right == null) {
                parent.right = child;
            } else {
                insertNode(parent.right, child);
            }
        }
    }

    class Node implements Comparable<Node> {
        int idx;
        int y;
        int x;
        Node left;
        Node right;

        public Node(int idx, int y, int x, Node left, Node right) {
            this.idx = idx;
            this.y = y;
            this.x = x;
            this.left = left;
            this.right = right;
        }

        // root node 부터 정렬
        public int compareTo(Node n) {
            if(this.y == n.y) {
                return this.x - n.x;
            }
            return n.y - this.y;
        }
    }

    public void preorder (Node node) {
        ans.add(node.idx);
        if(node.left != null) {
            preorder(node.left);
        }
        if(node.right != null) {
            preorder(node.right);
        }
    }

    public void postorder (Node node) {
        if(node.left != null) {
            postorder(node.left);
        }
        if(node.right != null) {
            postorder(node.right);
        }
        ans.add(node.idx);
    }
}
