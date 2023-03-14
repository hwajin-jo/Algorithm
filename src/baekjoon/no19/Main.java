package baekjoon.no19;

import java.util.Scanner;

// 1991 트리 순회
public class Main {
    static Node root = new Node('A', null, null);
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            Character data = sc.next().charAt(0);
            Character leftData = sc.next().charAt(0);
            Character rightData = sc.next().charAt(0);


            addTree(root, data, leftData, rightData);
        }

        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
    }

    public static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.leftNode);
        postOrder(node.rightNode);
        System.out.print(node.data);
    }

    public static void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.data);
        preOrder(node.leftNode);
        preOrder(node.rightNode);
    }

    public static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.leftNode);
        System.out.print(node.data);
        inOrder(node.rightNode);
    }
    public static void addTree(Node temp, Character data, Character leftData, Character rightData) {
        if (temp.data == data) {
            temp.leftNode = (leftData == '.' ? null : new Node(leftData,null,null));
            temp.rightNode = (rightData == '.' ? null : new Node(rightData,null,null));
        }
        else {
            if(temp.leftNode != null) addTree(temp.leftNode, data, leftData, rightData);
            if(temp.rightNode != null) addTree(temp.rightNode, data, leftData, rightData);
        }
    }
    static class  Node {
        Character data;
        Node leftNode;
        Node rightNode;

        public Node(Character e, Node leftNode, Node rightNode) {
            this.data = e;
            this.leftNode = leftNode;
            this.rightNode = rightNode;
        }
    }

}
