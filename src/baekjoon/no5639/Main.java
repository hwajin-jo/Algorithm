package baekjoon.no5639;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Node root = new Node(Integer.parseInt(br.readLine()));

        while (true) {
            String input = br.readLine();

            if (input == null || input.equals("")) break;

            int data = Integer.parseInt(input);
            root.insert(data);
        }

        postOrder(root, bw);

        bw.flush();
        bw.close();
    }

    static void postOrder(Node node, BufferedWriter bw) throws IOException {
        if (node == null) return;

        postOrder(node.left, bw);
        postOrder(node.right, bw);
        bw.write(node.data + "\n");
    }

   static class Node {
        int data;
        Node left;
        Node right;

        public Node (int data) {
            this.data = data;
        }

        public void insert(int data) {
            if (data < this.data) {
                if (this.left == null) this.left = new Node(data);
                else this.left.insert(data);
            } else {
                if (this.right == null) this.right = new Node(data);
                else this.right.insert(data);
            }
        }
    }
}
